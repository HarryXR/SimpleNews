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
package com.lauren.simplenews.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.lauren.simplenews.R;

/**
 * Description
 *
 * @author Jamling
 */
public class MainBottomTab extends RadioGroup implements RadioGroup.OnCheckedChangeListener {

    public MainBottomTab(Context context) {
        super(context);
    }

    public MainBottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Paint p = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        p.setColor(getContext().getResources().getColor(R.color.divider));
        setWillNotDraw(false);
        setOnCheckedChangeListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, getWidth(), 1, p);
    }

    private ViewPager viewPager;

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        if (this.viewPager != null){
            this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    check(getChildAt(position).getId());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (this.viewPager != null) {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (group.getChildAt(i).getId() == checkedId) {
                    this.viewPager.setCurrentItem(i, false);
                }
            }
        }
    }
}
