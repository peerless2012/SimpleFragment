package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment3 extends BaseFragment {
	public final static String TAG = "TabFragment3";
	public final static String CONTENT = "content";
	private View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//此方法介绍参照README.MD
//		rootView = inflater.inflate(R.layout.fragment_tab, container, false);
		rootView = inflater.inflate(R.layout.fragment_tab, null);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		
		rootView.setBackgroundColor(Color.BLUE);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		return rootView;
	}

	@Override
	public void updateData(Bundle bundle) {
		
	}
}