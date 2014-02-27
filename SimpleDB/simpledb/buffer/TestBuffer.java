package simpledb.buffer;

import simpledb.file.Block;
import simpledb.file.Page;
import simpledb.log.LogMgr;
import simpledb.server.SimpleDB;

public class TestBuffer {

public static void main(String[] args) {
	
Block[] blocks = new Block[4];
Buffer[] buffer = new Buffer[blocks.length];
SimpleDB.initFileLogAndBufferMgr("simpleDB");
BufferMgr bm = SimpleDB.bufferMgr();

for (int i = 0; i < blocks.length; i++) {
	blocks[i] = new Block("test.txt",i);
	buffer[i] = bm.pin(blocks[i]);

}

for (int i = 0; i < blocks.length; i++) {
	bm.unpin(buffer[i]);
}

Block blk = new Block("test.txt", blocks.length-1);
long starttime = System.nanoTime();
Buffer b = bm.pin(blk);
long endtime = System.nanoTime();
System.out.println("Time for operation is:" + (endtime - starttime));
}
}
