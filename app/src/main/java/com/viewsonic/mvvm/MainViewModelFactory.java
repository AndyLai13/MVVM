package com.viewsonic.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

	String version;

	MainViewModelFactory(String version) {
		this.version = version;
	}

	@SuppressWarnings("unchecked")
	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
		if (modelClass.isAssignableFrom(MainViewModel.class)) {
			return (T) new MainViewModel(version);
		}
		throw new IllegalArgumentException("Unknown ViewModel class");
	}
}
