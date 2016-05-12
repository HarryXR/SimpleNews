/*
 * Copyright (C) 2015-2016 QuickAF
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ieclipse.af.demo;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.ieclipse.af.demo.common.ui.BaseActivity;
import cn.ieclipse.af.demo.common.ui.BaseFragmentAdapter;
import cn.ieclipse.af.demo.common.ui.MainBottomTab;
import cn.ieclipse.af.demo.sample.appui.AppUIFragment;
import cn.ieclipse.af.demo.sample.volley.VolleyFragment;

/**
 * Description
 *
 * @author Jamling
 */
public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private MainBottomTab mBottomTab;
    private BaseFragmentAdapter mAdapter;

    @Override
    protected int getContentLayout() {
        return R.layout.main_viewpager;
    }

    @Override
    protected void initWindowFeature() {
        super.initWindowFeature();
        setShowTitleBar(false);
    }

    @Override
    protected void initContentView(View view) {
        super.initContentView(view);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mAdapter = new BaseFragmentAdapter(getFragmentManager());
        mAdapter.setFragments(new AppUIFragment(), new VolleyFragment());
    }

    @Override
    protected void initBottomView() {
        super.initBottomView();
        mBottomTab = (MainBottomTab) View.inflate(this, R.layout.main_bottom_tab, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomBar.addView(mBottomTab, params);
        mBottomTab.setViewPager(mViewPager);
        mBottomTab.setBadge(0, 1);
    }

    @Override
    protected void initData() {
        super.initData();
        mViewPager.setAdapter(mAdapter);
    }
}
