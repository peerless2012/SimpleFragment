package com.peerless2012.simplefragment.fragments;

import com.peerless2012.simplefragment.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment1 extends Fragment {

	public final static String TAG = "TabFragment1";
	public final static String CONTENT = "content";
	private View rootView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*
		 * @param resource ID 布局资源id
	     * 
	     * @param root 填充的View要被添加到的父ViewGroup（如果此参数为空，加载布局的时候，布局中根元素的宽高等属性会被设置成默认的宽高（依据布局不同大都是包裹内容），
	     * 所以如果此参数为空的话，即使在布局中设置为填充屏幕，实际上还是包裹内容）
	     * ps：ListView的Adapter中getView方法中的填充布局也是一样的道理。
	     * 
	     * @param 把布局填充成View的时候是否加到第二个参数指定的父ViewGroup上
	     * 如果填充后的布局是需要返回的，由控件本身添加，那么这个参数应该设置成false
		 * */
		rootView = inflater.inflate(R.layout.fragment_tab, container, false);
		TextView content = (TextView) rootView.findViewById(R.id.content);
		//获取传递数据的载体 Bundle
		Bundle data = getArguments();
		if (data != null) {
			content.setText(data.getString(CONTENT));
		}
		rootView.setBackgroundColor(Color.RED);
		return rootView;
	}
}
