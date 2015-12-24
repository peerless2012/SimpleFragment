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

public class BackFragment2 extends Fragment  implements OnClickListener{
	public final static String TAG = "BackFragment2";
	public final static String CONTENT = "content";
	private View rootView;
	
	public static Fragment newInstance(Context context,String content) {
		Bundle data = new Bundle();
		data.putString(BackFragment1.CONTENT,content);
		return Fragment.instantiate(context, BackFragment2.class.getName(),data);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_back, container, false);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.GREEN);
		rootView.findViewById(R.id.netStep).setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		Fragment backFragment3 = BackFragment3.newInstance(getActivity(),  "这是传递给第三个Fragment的内容");
		transaction.add(R.id.fragment_content, backFragment3, BackFragment3.TAG);
		transaction.addToBackStack(BackFragment3.TAG);
		transaction.commit();
	}
}
