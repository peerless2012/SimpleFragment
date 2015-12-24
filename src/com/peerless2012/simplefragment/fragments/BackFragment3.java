package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BackFragment3 extends Fragment{
	public final static String TAG = "BackFragment3";
	public final static String CONTENT = "content";
	private View rootView;
	
	public static Fragment newInstance(Context context,String content) {
		Bundle data = new Bundle();
		data.putString(BackFragment1.CONTENT,content);
		return Fragment.instantiate(context, BackFragment3.class.getName(),data);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//此方法介绍参照README.MD
		rootView = inflater.inflate(R.layout.fragment_back, container, false);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.BLUE);
		rootView.findViewById(R.id.netStep).setVisibility(View.GONE);
		return rootView;
	}
}
