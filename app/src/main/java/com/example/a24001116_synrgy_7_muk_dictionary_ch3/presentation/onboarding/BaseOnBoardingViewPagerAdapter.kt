package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseOnBoardingViewPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoarding1Fragment()
            else -> OnBoarding1Fragment()
        }
    }
}