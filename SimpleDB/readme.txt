The  team consists of: Amit S katti(askatti)
					   Bhargava Pejakala kakrannaya(bkakran)
					   
Files modified:
/SimpleDB/src/simpledb/buffer/BasicBufferMgr.java
/SimpleDB/src/simpledb/server/SimpleDB.java
/SimpleDB/src/simpledb/file/Page.java

Files added:
SimpleDB/src/simpledb/buffer/History.java


Test file used for task 1
/SimpleDB/src/simpledb/buffer/TestBuffer.java


Test file used for task 2
/SimpleDB/src/simpledb/buffer/TestLRU.java

Test file used for task 3
/SimpleDB/src/simpledb/buffer/TestPage.java

Notes:
We have added Map<Block,History> history in BasicBufferMgr to maintain history of pages in buffer.
We have added Map<Block,Buffer> bufferMap in BasicBufferMgr to maintain enhance searching operation for unpinned buffers.
----------------------------
