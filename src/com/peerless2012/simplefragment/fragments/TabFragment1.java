package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import com.peerless2012.simplefragment.ReceiveData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TabFragment1 extends BaseFragment implements ReceiveData{

	public final static String TAG = "TabFragment1";
	public final static String CONTENT = "content";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onDataReceived(Bundle bundle) {
		//更新数据
		String string = bundle.getString("data");
		Toast.makeText(getActivity(), "我收到从其他地方来的消息,消息内容是:\n"+string,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	protected int getViewLayoutRes(Bundle savedInstanceState) {
		return R.layout.fragment_tab;
	}

	@Override
	protected void initView(View rootView, Bundle savedInstanceState) {
		TextView content = (TextView) rootView.findViewById(R.id.content);
		//获取传递数据的载体 Bundle
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.RED);
	}

	@Override
	protected void onNewCreate(Bundle savedInstanceState) {
		super.onNewCreate(savedInstanceState);
	}
	
	@Override
	protected void initListener(Bundle savedInstanceState) {
		
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		
	}

}
