package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import com.peerless2012.simplefragment.TabActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment2 extends BaseFragment implements OnClickListener{
	public final static String TAG = "TabFragment2";
	public final static String CONTENT = "content";
	private View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//此方法介绍参照README.MD
		rootView = inflater.inflate(R.layout.fragment_tab, container, false);
//		rootView = inflater.inflate(R.layout.fragment_tab, null);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		View viewById = rootView.findViewById(R.id.translate_data);
		viewById.setVisibility(View.VISIBLE);
		viewById.setOnClickListener(this);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.GREEN);
		return rootView;
	}

	@Override
	public void updateData(Bundle bundle) {
		
	}

	@Override
	public void onClick(View v) {
		TabActivity tabActivity = (TabActivity) getActivity();
		Bundle data = new Bundle();
		data.putString("data","我是tab2的数据,我要传递给tab1");
		//指定更新数据的Fragment 和更新的数据
		tabActivity.updateFragmentData(TabFragment1.TAG, data);
	}
}
