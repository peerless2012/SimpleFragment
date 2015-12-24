---
# SimpleFragment
Android中对于Fragment的更优雅的使用方式以及数据传递。

## 以TAB的方式切换Fragment
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

## 以加入到后退栈的方式切换Fragment

  - 以全屏的方式展示Fragment
  - 加到回退栈中，模拟Activity的栈结构


## 关于LayoutInflater中的inflate方法的介绍

            public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)

- resource 布局资源的ID
- root 把resource填充成View的时候参考的父布局
    - 如果这个参数为空，那么把resource填充成view的时候，根元素的宽高等参数会不起作用，取而代之的是默认的参数（比如布局里面设置宽高是填充屏幕，但是加载的时候实际是包裹内容，即使把宽高这是成很高很高，也是没有什么卵用的）
    - 如果传递的父View，那么填充的时候就会正常填充根元素的属性，不会出现异常。
- attachToRoot 是否把填充的View添加到root上
    - 在Fragment的onCreate方法中这个参数应该为false，我们应该返回填充的View，让Fragment自己去添加（在ListView中，Adapter的getView方法中，也是一样的道理，填充的时候设置为false，然后返回给ListView，让ListView自己去添加）。
    - 在自定义ViewGroup的时候，这个可以设置为true，这样就不用自己手动去addView了。