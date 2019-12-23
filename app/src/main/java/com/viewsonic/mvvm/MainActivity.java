package com.viewsonic.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.viewsonic.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	MainViewModel mainViewModel;
	ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
		binding.setMainViewModel(mainViewModel);

		binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mainViewModel.refresh();
			}
		});
	}
}
