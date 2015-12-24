package com.peerless2012.simplefragment;

import com.peerless2012.simplefragment.fragments.BackFragment1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class BackStackActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_back_stack);
		Fragment fragment = BackFragment1.newInstance(this,  "这是传递给第一个Fragment的内容");
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.fragment_content, fragment, BackFragment1.TAG);
//		transaction.addToBackStack(BackFragment1.TAG); //第一个就不加到回退栈了，如果加了，按返回会出现一个空白的页面
		transaction.commit();
	}
	
	
	public static void launch(Context context) {
		Intent intent = new Intent(context, BackStackActivity.class);
		context.startActivity(intent);
	}
}
