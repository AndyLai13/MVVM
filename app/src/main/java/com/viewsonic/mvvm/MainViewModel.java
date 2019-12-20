package com.viewsonic.mvvm;

import android.content.Context;
import android.widget.Toast;

public class MainViewModel {

	Context mContext;
	MainViewModel(Context context) {
		mContext = context;
	}

	DataModel dataModel = new DataModel();

	public void refresh() {
		dataModel.retrieveData(new DataModel.onDataReadyCallback() {
			@Override
			public void onDataReady(String data) {
				Toast.makeText(mContext, "data = " + data, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
