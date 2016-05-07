package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import com.peerless2012.simplefragment.TranslateData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TabFragment2 extends BaseFragment implements OnClickListener{
	public final static String TAG = "TabFragment2";
	public final static String CONTENT = "content";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	

	@Override
	public void onClick(View v) {
		FragmentActivity activity = getActivity();
		if (activity != null && activity instanceof TranslateData) {
			Bundle data = new Bundle();
			data.putString("data","我是tab2的数据,我要传递给tab1");
			//指定更新数据的Fragment 和更新的数据
			((TranslateData)activity).transDataF2FByActivity(TabFragment1.TAG, data);
		}
	}


	@Override
	protected int getViewLayoutRes(Bundle savedInstanceState) {
		return R.layout.fragment_tab;
	}


	@Override
	protected void initView(View rootView, Bundle savedInstanceState) {
		TextView content = (TextView) rootView.findViewById(R.id.content);
		View viewById = rootView.findViewById(R.id.translate_data);
		viewById.setVisibility(View.VISIBLE);
		viewById.setOnClickListener(this);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.GREEN);
	}


	@Override
	protected void initListener(Bundle savedInstanceState) {
		
	}


	@Override
	protected void initData(Bundle savedInstanceState) {
		
	}
}
