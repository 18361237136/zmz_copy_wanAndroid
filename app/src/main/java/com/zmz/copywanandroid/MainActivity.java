package com.zmz.copywanandroid;

import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.zmz.copywanandroid.base.BaseActivity;
import com.zmz.copywanandroid.home.HomeFragment;
import com.zmz.copywanandroid.knowledge.KnowledgeFragment;
import com.zmz.copywanandroid.navigation.NavigationFragment;
import com.zmz.copywanandroid.project.ProjectFragment;
import com.zmz.copywanandroid.wechat.WechatFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_tab)
    TabLayout mainTab;

    private List<Fragment> fragments;

    private int[] unSelected={R.mipmap.home_unselected,R.mipmap.knowledge_system_unselected,R.mipmap.public_unselected,R.mipmap.navigation_unselected,R.mipmap.project_unselected};
    private int[] selected={R.mipmap.home_selected,R.mipmap.knowledge_system_selected,R.mipmap.public_selected,R.mipmap.navigation_selected,R.mipmap.project_selected};
    private String[] titles={"首页","知识体系","公众号","导航","项目"};

    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void setUpView() {
        initView();
    }

    private void initView(){
        fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new KnowledgeFragment());
        fragments.add(new WechatFragment());
        fragments.add(new NavigationFragment());
        fragments.add(new ProjectFragment());

        for(int i=0;i<titles.length;i++){
            mainTab.addTab(mainTab.newTab().setIcon(unSelected[i]).setText(titles[i]));
        }

        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTabSelectedFragment(tab.getPosition());

                for(int i=0;i<mainTab.getTabCount();i++){
                    if(i==tab.getPosition()){
                        mainTab.getTabAt(i).setIcon(selected[i]);
                    }else{
                        mainTab.getTabAt(i).setIcon(unSelected[i]);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabSelectedFragment(int position){
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=fragments.get(0);
                break;
            case 1:
                fragment=fragments.get(1);
                break;
            case 2:
                fragment=fragments.get(2);
                break;
            case 3:
                fragment=fragments.get(3);
                break;
            case 4:
                fragment=fragments.get(4);
                break;
        }
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
        }
    }


}
