package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
	/**
	 * The value that's manipulated atomically via the methods.
	 */
	private long mValue;

	/**
	 * The ReentrantReadWriteLock used to serialize access to mValue.
	 */

	// TODO -- you fill in here by replacing the null with an
	// initialization of ReentrantReadWriteLock.
	private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

	/**
	 * Creates a new SimpleAtomicLong with the given initial value.
	 */
	public SimpleAtomicLong(long initialValue)
	{
		// TODO -- you fill in here
		this.mValue = initialValue;
	}

	/**
	 * @brief Gets the current value.
	 * 
	 * @returns The current value
	 */
	public long get() {
		// Please use readlock for this method.
		mRWLock.readLock().lock();
		try{
			long value = mValue;
			// TODO -- you fill in here

			return value;
		}
		finally{
			mRWLock.readLock().unlock();
		}
	}

	/**
	 * @brief Atomically decrements by one the current value
	 *
	 * @returns the updated value
	 */
	public long decrementAndGet(){
		mRWLock.writeLock().lock();
		try{
			long value = mValue;
			value = value - 1;
			// TODO -- you fill in here
			mValue = value;
			return value;
		}
		finally{
			mRWLock.writeLock().unlock();
		}
	}

	/**
	 * @brief Atomically increments by one the current value
	 *
	 * @returns the previous value
	 */
	public long getAndIncrement(){
		mRWLock.writeLock().lock();
		try{
			long value = mValue;
			// TODO -- you fill in here
			++mValue;
			return value;
		}
		finally{
			mRWLock.writeLock().unlock();
		}

	}

	/**
	 * @brief Atomically decrements by one the current value
	 *
	 * @returns the previous value
	 */
	public long getAndDecrement(){
		mRWLock.writeLock().lock();
		try{
			long value = mValue;

			// TODO -- you fill in here
			mValue = mValue - 1;
			return value;
		}
		finally{
			mRWLock.writeLock().unlock();
		}
	}

	/**
	 * @brief Atomically increments by one the current value
	 *
	 * @returns the updated value
	 */
	public long incrementAndGet(){
		mRWLock.writeLock().lock();
		try{
			++mValue;
			// TODO -- you fill in here
			
			return mValue;
		}
		finally{
			mRWLock.writeLock().unlock();
		}
	}
}

