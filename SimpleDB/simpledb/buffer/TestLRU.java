package simpledb.buffer;

import simpledb.file.Block;
import simpledb.file.Page;
import simpledb.log.LogMgr;
import simpledb.server.SimpleDB;

public class TestLRU {

public static void main(String[] args) {
	
Block[] blocks = new Block[6];
Buffer buff = new Buffer();
SimpleDB.initFileLogAndBufferMgr("simpleDB");

BufferMgr bm = SimpleDB.bufferMgr();

blocks[0] = new Block("rfc11.txt",0);			//Block A
blocks[1] = new Block("rfc11.txt",1);			//Block B
blocks[2] = new Block("rfc11.txt",2);			//Block C
blocks[3] = new Block("rfc11.txt",3);			//Block D
blocks[4] = new Block("rfc11.txt",4);			//Block E
blocks[5] = new Block("rfc11.txt",5);			//Block F
try
{
Thread.sleep(2000);
buff = bm.pin(blocks[0]);						//Block A at time 2
bm.unpin(buff);

Thread.sleep(3000);
buff = bm.pin(blocks[1]);						//Block B at time 5
bm.unpin(buff);

Thread.sleep(3000);
buff = bm.pin(blocks[0]);						//Block A at time 8
bm.unpin(buff);

Thread.sleep(8000);
buff = bm.pin(blocks[1]);						//Block B at time 16
bm.unpin(buff);

Thread.sleep(4000);
buff = bm.pin(blocks[2]);						//Block C at time 20
bm.unpin(buff);

Thread.sleep(4000);
buff = bm.pin(blocks[3]);						//Block D at time 24
bm.unpin(buff);

Thread.sleep(6000);
buff = bm.pin(blocks[4]);						//Block E at time 30
bm.unpin(buff);

Thread.sleep(10000);
buff = bm.pin(blocks[5]);						//Block F at time 40
bm.unpin(buff);

Thread.sleep(5000);
buff = bm.pin(blocks[0]);						//Block A at time 45
bm.unpin(buff);

Thread.sleep(9000);
buff = bm.pin(blocks[2]);						//Block C at time 54
bm.unpin(buff);

Thread.sleep(16000);
buff = bm.pin(blocks[3]);						//Block D at time 70
bm.unpin(buff);

Thread.sleep(10000);
buff = bm.pin(blocks[4]);						//Block E at time 80
bm.unpin(buff);

Thread.sleep(20000);
buff = bm.pin(blocks[5]);						//Block F at time 100
bm.unpin(buff);
System.out.println(bm.toString());
//2 4 3 5
} catch(InterruptedException e) {}
}

}
