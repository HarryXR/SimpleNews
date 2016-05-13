package com.lauren.simplenews.about.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lauren.simplenews.R;

/**
 * Description :
 * Author : Harry
 * Blog   : https://github.com/HarryXR
 */
public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, null);
        return view;
    }
    protected CharSequence getTitle(){
        return getClass().getSimpleName();
    }
}
