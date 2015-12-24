# SimpleFragment
Android中对于Fragment的更优雅的使用方式以及数据传递。

##以TAB的方式切换Fragment
  - 查找要显示的Fragment
  - 如果不存在则创建新的并添加（add）进去
  - 如果已经存在，则隐藏当前的Fragment,显示找到的Fragment

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

  切换的时候
  
        Bundle bundle3 = new Bundle();
      	bundle3.putString(TabFragment1.CONTENT, "这是传递给第三个TabFragment的数据");
      	changeFragment(TabFragment3.class.getName(),TabFragment3.TAG, bundle3);

##以加入到后退栈的方式切换Fragment

  - 以全屏的方式展示Fragment
  - 加到回退栈中，模拟Activity的栈结构
