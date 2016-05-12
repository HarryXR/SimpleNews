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
package com.lauren.simplenews.adapter;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author Jamling
 */
public class BaseFragmentAdapter extends AfFragmentPagerAdapter {

    private List<Fragment> fragments;

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getItem(position).getClass().getSimpleName();
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public void setFragments(Fragment... fragments) {
        this.fragments = new ArrayList<>();
        if (fragments != null) {
            for (Fragment f : fragments) {
                this.fragments.add(f);
            }
        }
    }

}
