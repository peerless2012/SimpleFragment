package com.peerless2012.simplefragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity  implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.tab_mode).setOnClickListener(this);
		findViewById(R.id.back_stack_mode).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back_stack_mode:
			//以后退栈的方式展示Fragment
			BackStackActivity.launch(this);
			break;
		case R.id.tab_mode:
			//以Tab的方式展示Fragment
			TabActivity.launch(this);
			break;

		default:
			break;
		}
	}
}
