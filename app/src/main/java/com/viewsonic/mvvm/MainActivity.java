package com.viewsonic.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.viewsonic.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	MainViewModel mainViewModel;
	ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		MainViewModelFactory factory = new MainViewModelFactory("1.0");
		mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
		binding.setMainViewModel(mainViewModel);

		binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mainViewModel.refresh();
			}
		});

		mainViewModel.mData.observe(this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				binding.txtHelloWord.setText(s);

			}
		});

		mainViewModel.toastText.observe(this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
			}
		});
	}
}
