package com.example.brg_shopping.BusinessView.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new OrderWaitConfirmFragment();
            case 1: return new OrderDeliveringFragment();
            case 2: return new OrderDoneFragment();
            case 4: return new OrderCancelFragment();
            default: return new OrderWaitConfirmFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
