package com.peerless2012.simplefragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends BaseActivity  implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.tab_by_radiogroup_mode).setOnClickListener(this);
		findViewById(R.id.tab_by_fragment_tab_host_mode).setOnClickListener(this);
		findViewById(R.id.back_stack_mode).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back_stack_mode:
			//以后退栈的方式展示Fragment
			BackStackActivity.launch(this);
			break;
		case R.id.tab_by_radiogroup_mode:
			//以Tab的方式展示Fragment
			TabByRadioGroupActivity.launch(this);
			break;
			
		case R.id.tab_by_fragment_tab_host_mode:
			//以Tab的方式展示Fragment
			TabByFragmentTabHostActivity.launch(this);;
			break;

		default:
			break;
		}
	}
}
