package com.peerless2012.simplefragment;

import com.peerless2012.simplefragment.fragments.BaseFragment;
import com.peerless2012.simplefragment.fragments.TabFragment1;
import com.peerless2012.simplefragment.fragments.TabFragment2;
import com.peerless2012.simplefragment.fragments.TabFragment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 *以RadioGroup和RadioButton的方式切换内容区域的Fragment（缺点是无法对底部做更多的效果）
 */
public class TabByRadioGroupActivity extends BaseActivity
				implements OnCheckedChangeListener
				,TranslateData{

	private RadioGroup mRadioGroup;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_tab_radiogroup);
		mRadioGroup = (RadioGroup) findViewById(R.id.tab);
		mRadioGroup.setOnCheckedChangeListener(this);
//		mRadioGroup.check(R.id.tab_1);
		((RadioButton) findViewById(R.id.tab_1)).setChecked(true);;
	}
	
	public static void launch(Context context) {
		Intent intent = new Intent(context, TabByRadioGroupActivity.class);
		context.startActivity(intent);
	}

	private Fragment preFragment;

	/**
	 * @param fragmentName Fragment的完整类名
	 * @param tag Tag名称（添加的时候带上，可以根据tag找到添加的fragment）
	 * @param data 切换fragment需要携带的数据
	 */
	private void changeFragment(String fragmentName,String tag,Bundle data) {
		 FragmentManager fragmentManager = getSupportFragmentManager();
		 //根据tag找到对应的Fragment
		 Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
		 //如果选中的就是现在显示的，直接返回（如果需求不同则去掉本行）
		 if (currentFragment != null && currentFragment == preFragment) return;
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (currentFragment == null) {
			
			//参数对应到函数的注释上面,这样写的好处是，如果fragment被回收，在fragment被重新创建的时候会携带之前传递的数据
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
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
			switch (checkedId) {
			case R.id.tab_1:
				Bundle bundle1 = new Bundle();
				bundle1.putString(TabFragment1.CONTENT, "这是传递给第一个TabFragment的数据");
				changeFragment(TabFragment1.class.getName(),TabFragment1.TAG, bundle1);
				break;
			case R.id.tab_2:
				Bundle bundle2 = new Bundle();
				bundle2.putString(TabFragment2.CONTENT, "这是传递给第二个TabFragment的数据");
				changeFragment(TabFragment2.class.getName(),TabFragment2.TAG, bundle2);
				break;
			case R.id.tab_3:
				Bundle bundle3 = new Bundle();
				bundle3.putString(TabFragment3.CONTENT, "这是传递给第三个TabFragment的数据");
				changeFragment(TabFragment3.class.getName(),TabFragment3.TAG, bundle3);
				break;

			default:
				break;
			}
	}

	@Override
	public void transDataF2FByActivity(String tag, Bundle data) {
		BaseFragment fragmentByTag = (BaseFragment) getSupportFragmentManager().findFragmentByTag(tag);
		if (fragmentByTag != null && fragmentByTag instanceof ReceiveData) {
			((ReceiveData)fragmentByTag).onDataReceived(data);
		}
	}
}
