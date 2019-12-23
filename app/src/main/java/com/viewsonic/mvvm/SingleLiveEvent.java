package com.viewsonic.mvvm;

import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

	private final AtomicBoolean mPending = new AtomicBoolean(false);

	@Override
	public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<? super T> observer) {
		if (hasActiveObservers()) {
			Log.d("Andy", "Multiple observers registered but only one will be notified of changes");
		}
		super.observe(owner, new Observer<T>() {
			@Override
			public void onChanged(T t) {
				if (mPending.compareAndSet(true, false)) {
					observer.onChanged(t);
				}
			}
		});
	}

	@Override
	public void setValue(T value) {
		mPending.set(true);
		super.setValue(value);
	}

	/**
	 * Used for cases where T is Void, to make calls cleaner.
	 */
	@MainThread
	void call() {
		setValue(null);
	}
}
