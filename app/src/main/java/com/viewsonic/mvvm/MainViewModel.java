package com.viewsonic.mvvm;

import android.content.Context;
import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

	Context mContext;

	public ObservableField<String> mData = new ObservableField<>();
	public ObservableBoolean isLoading = new ObservableBoolean(false);
	DataModel dataModel = new DataModel();

	public void refresh() {
		isLoading.set(true);
		dataModel.retrieveData(new DataModel.onDataReadyCallback() {
			@Override
			public void onDataReady(String data) {
				Log.d("Andy", "data = " + data);
				mData.set(data);
				isLoading.set(false);
			}
		});
	}
}
