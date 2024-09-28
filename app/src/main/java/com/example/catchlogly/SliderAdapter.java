package com.example.catchlogly;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SliderAdapter extends FragmentStateAdapter {
    public SliderAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //add fragments here
        switch(position) {
            case 0:
                return new DeskFragment();
            case 1:
                return new BinderFragment();
            default:
                return new DeskFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
