package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BackFragment1 extends Fragment  implements OnClickListener{
	public final static String TAG = "BackFragment1";
	public final static String CONTENT = "content";
	private View rootView;
	
	public static Fragment newInstance(Context context,String content) {
		Bundle data = new Bundle();
		data.putString(BackFragment1.CONTENT,content);
		return Fragment.instantiate(context, BackFragment1.class.getName(),data);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//此方法介绍参照README.MD
//		rootView = inflater.inflate(R.layout.fragment_back, container, false);
		rootView = inflater.inflate(R.layout.fragment_back, null);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.RED);
		rootView.findViewById(R.id.netStep).setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		Fragment backFragment2 = BackFragment2.newInstance(getActivity(),  "这是传递给第二个Fragment的内容");
		transaction.add(R.id.fragment_content, backFragment2, BackFragment2.TAG);
		transaction.addToBackStack(BackFragment2.TAG);
		transaction.commit();
	}
}
