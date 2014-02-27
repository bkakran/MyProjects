package simpledb.buffer;

import simpledb.server.SimpleDB;

/**
 * The Class History.
 */
public class History {

/** The history. */
long[] history = new long[SimpleDB.getKForLRU()];

/** The last access time. */
long lastAccessTime;

/**
 * Gets the history.
 *
 * @return the history
 */
public long[] getHistory() {
	return history;
}

/**
 * Sets the history.
 *
 * @param i the i
 * @param time the time
 */
public void setHistory(int i, long time) {
	history[i] = time;
}

/**
 * Gets the last access time.
 *
 * @return the lastAccessTime
 */
public long getLastAccessTime() {
	return lastAccessTime;
}

/**
 * Sets the last access time.
 *
 * @param lastAccessTime the lastAccessTime to set
 */
public void setLastAccessTime(long lastAccessTime) {
	this.lastAccessTime = lastAccessTime;
}
}
