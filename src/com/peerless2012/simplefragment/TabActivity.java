package com.peerless2012.simplefragment;

import com.peerless2012.simplefragment.fragments.TabFragment1;
import com.peerless2012.simplefragment.fragments.TabFragment2;
import com.peerless2012.simplefragment.fragments.TabFragment3;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

public class TabActivity extends FragmentActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_tab);
		findViewById(R.id.tab_1).setOnClickListener(this);
		findViewById(R.id.tab_2).setOnClickListener(this);
		findViewById(R.id.tab_3).setOnClickListener(this);
	}
	
	public static void launch(Context context) {
		Intent intent = new Intent(context, TabActivity.class);
		context.startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_1:
			Bundle bundle1 = new Bundle();
			bundle1.putString(TabFragment1.CONTENT, "这是传递给第一个TabFragment的数据");
			changeFragment(TabFragment1.class.getName(),TabFragment1.TAG, bundle1);
			break;
		case R.id.tab_2:
			Bundle bundle2 = new Bundle();
			bundle2.putString(TabFragment1.CONTENT, "这是传递给第二个TabFragment的数据");
			changeFragment(TabFragment2.class.getName(),TabFragment2.TAG, bundle2);
			break;
		case R.id.tab_3:
			Bundle bundle3 = new Bundle();
			bundle3.putString(TabFragment1.CONTENT, "这是传递给第三个TabFragment的数据");
			changeFragment(TabFragment3.class.getName(),TabFragment3.TAG, bundle3);
			break;

		default:
			break;
		}
		
	}
	private Fragment preFragment;

	private void changeFragment(String fragmentName,String tag,Bundle data) {
		 FragmentManager fragmentManager = getSupportFragmentManager();
		 Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
		 if (currentFragment != null && currentFragment == preFragment) return;
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (currentFragment == null) {
			currentFragment = Fragment.instantiate(this, fragmentName, data);
			transaction.add(R.id.fragment_content, currentFragment, tag);
			if (preFragment != null) {
				transaction.hide(preFragment);
			}
		}else {
			transaction.hide(preFragment);
			transaction.show(currentFragment);
		}
		preFragment = currentFragment;
		transaction.commit();
	}
}