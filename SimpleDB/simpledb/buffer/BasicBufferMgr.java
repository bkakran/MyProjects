package simpledb.buffer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import simpledb.file.*;
import simpledb.server.SimpleDB;

/**
 * Manages the pinning and unpinning of buffers to blocks.
 * @author Edward Sciore
 *
 */
public class BasicBufferMgr {
   private Buffer[] bufferpool;
   private int numAvailable;
   //Map holding History values
   Map<Block,History> history = new Hashtable<Block,History>();
   //Map holding buffers used to increase faster access
   Map<Block,Buffer> bufferMap = new Hashtable<Block,Buffer>();
   
   /**
    * Creates a buffer manager having the specified number 
    * of buffer slots.
    * This constructor depends on both the {@link FileMgr} and
    * {@link simpledb.log.LogMgr LogMgr} objects 
    * that it gets from the class
    * {@link simpledb.server.SimpleDB}.
    * Those objects are created during system initialization.
    * Thus this constructor cannot be called until 
    * {@link simpledb.server.SimpleDB#initFileAndLogMgr(String)} or
    * is called first.
    * @param numbuffs the number of buffer slots to allocate
    */
   BasicBufferMgr(int numbuffs) {
      bufferpool = new Buffer[numbuffs];
      numAvailable = numbuffs;
      for (int i=0; i<numbuffs; i++)
         bufferpool[i] = new Buffer();
   }
   
   /**
    * Flushes the dirty buffers modified by the specified transaction.
    * @param txnum the transaction's id number
    */
   synchronized void flushAll(int txnum) {
      for (Buffer buff : bufferpool)
         if (buff.isModifiedBy(txnum))
         buff.flush();
   }
   
   /**
    * Pins a buffer to the specified block. 
    * If there is already a buffer assigned to that block
    * then that buffer is used;  
    * otherwise, an unpinned buffer from the pool is chosen.
    * Returns a null value if there are no available buffers.
    * @param blk a reference to a disk block
    * @return the pinned buffer
    */
   synchronized Buffer pin(Block blk) {
	  Buffer buff = findExistingBuffer(blk);
      if (buff == null) {
         buff = chooseUnpinnedBuffer();
         if (buff == null)
            return null;
     	long time = System.currentTimeMillis()/1000;
		if (buff.block() != null) {
				bufferMap.remove(buff.block());
				System.out.println("Time:" + time + " Replacement block:" + buff.block().toString()+" Incoming Block:" + blk.toString());
			} else {
				System.out.println("Time:" + time + " Buffer Available                            Incoming Block:" + blk.toString());
			}
         buff.assignToBlock(blk);
         reInitializeHistory(blk);
      }
      if (!buff.isPinned())
         numAvailable--;
      buff.pin();
      bufferMap.put(blk, buff);
      return buff;
   }


/**
    * Allocates a new block in the specified file, and
    * pins a buffer to it. 
    * Returns null (without allocating the block) if 
    * there are no available buffers.
    * @param filename the name of the file
    * @param fmtr a pageformatter object, used to format the new block
    * @return the pinned buffer
    */
   synchronized Buffer pinNew(String filename, PageFormatter fmtr) {
	  Buffer buff = chooseUnpinnedBuffer();
      if (buff == null)
         return null;
      if (buff.block() != null) {
			bufferMap.remove(buff.block());
		}
      buff.assignToNew(filename, fmtr);
      reInitializeHistory(buff.block());
      numAvailable--;
      buff.pin();
      bufferMap.put(buff.block(), buff);
      return buff;
   }
   
   /**
    * Unpins the specified buffer.
    * @param buff the buffer to be unpinned
    */
   synchronized void unpin(Buffer buff) {
      buff.unpin();
      if (!buff.isPinned())
         numAvailable++;
   }
   
   /**
    * Returns the number of available (i.e. unpinned) buffers.
    * @return the number of available buffers
    */
   int available() {
      return numAvailable;
   }
   
	private Buffer findExistingBuffer(Block blk) {
		//return from the map
		if (bufferMap.get(blk) != null) {
			updateHistory(blk);
			return bufferMap.get(blk);
		}
		return null;
	}
   
	private Buffer chooseUnpinnedBuffer() {
		long min = System.currentTimeMillis()/1000;
		long curTime = min;
		long timeDiff = 0;
		Buffer victim = null;
		//Run LRU-K algorithm
		for (Buffer buff : bufferpool) {
			if (!buff.isPinned()) {
				if (buff.block() == null) {
					victim = buff;
					return victim;
				} else {
					long last = history.get(buff.block()).getLastAccessTime();
					timeDiff = curTime - last;
					long historyTime = history.get(buff.block()).getHistory()[SimpleDB.getKForLRU() - 1];
					if (timeDiff > SimpleDB.getCorelatedReferenePeriod()
							&& (historyTime < min)) {
						victim = buff;
						min = historyTime;
				}
				}
			}
		}
		//Run LRU-1 in case there are multiple history with 0 value
		if (SimpleDB.getKForLRU() > 1 && min == 0) {
			List<Buffer> buffList = new ArrayList<Buffer>();
			for (Buffer buff : bufferpool) {
				long histTime = history.get(buff.block()).getHistory()[SimpleDB.getKForLRU() - 1];
				if (histTime == min) {
					buffList.add(buff);
				}
			}
			if (!buffList.isEmpty() && buffList.size() > 1) {
				long secondMin = curTime;
				for (Buffer buffer : buffList) {
					long histTime = history.get(buffer.block()).getHistory()[0];
					long last = history.get(buffer.block()).getLastAccessTime();
					timeDiff = curTime - last;
					if (timeDiff > SimpleDB.getCorelatedReferenePeriod()
							&& (histTime < secondMin)) {
						victim = buffer;
						secondMin = histTime;
				}
				}
			}
		}
		return victim;
	}


	private void updateHistory(Block blk) {
		//Update the history block
		History hist = history.get(blk);
		long correlation_period_of_referenced_page = 0;
		long currentTime = System.currentTimeMillis()/1000;
		if (hist != null) {
			if ((currentTime - hist.getLastAccessTime()) > SimpleDB
					.getCorelatedReferenePeriod()) {
				correlation_period_of_referenced_page = hist.getLastAccessTime() - hist.getHistory()[0];
				for (int i = 1; i <=hist.getHistory().length-1; i++) {
					hist.getHistory()[i] = hist.getHistory()[i-1] + correlation_period_of_referenced_page;
				}
				hist.setHistory(0,currentTime);
				hist.setLastAccessTime(currentTime);
			} else {
				/*a correlated reference */
				hist.setLastAccessTime(currentTime);
			}
		}
	}
	
	//reintialiaze history block
	private void reInitializeHistory(Block blk) {
		History hist = history.get(blk);
		if (hist != null) {
			for (int i = 1; i <= SimpleDB.getKForLRU()-1; i++) {
				hist.getHistory()[i] = hist.getHistory()[i - 1];
			}
		} else {
			hist = new History();
			history.put(blk, hist);
		}
		long currentTime = System.currentTimeMillis()/1000;
		hist.setLastAccessTime(currentTime);
		hist.setHistory(0, currentTime);
	}
	
	@Override
	public String toString() {
		String val = "";
		for (Block value : bufferMap.keySet()) {
			val = val + value.number() + " ";
		}
		return val;
	}
}
