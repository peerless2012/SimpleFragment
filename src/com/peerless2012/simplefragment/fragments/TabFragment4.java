package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment4 extends BaseFragment {
	public final static String TAG = "TabFragment4";
	public final static String CONTENT = "content";
	private View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected int getViewLayoutRes(Bundle savedInstanceState) {
		return R.layout.fragment_tab;
	}

	@Override
	protected void initView(View rootView, Bundle savedInstanceState) {
		TextView content = (TextView) rootView.findViewById(R.id.content);
		rootView.setBackgroundColor(Color.GRAY);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
	}

	@Override
	protected void initListener(Bundle savedInstanceState) {
		
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		
	}
}
