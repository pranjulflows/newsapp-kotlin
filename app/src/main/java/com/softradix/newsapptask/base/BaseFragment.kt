package com.softradix.newsapptask.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController

class BaseFragment : Fragment() {
    private var mActivity: FragmentActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = requireActivity()
    }


    fun callFragment(view: View, fragmentId: Int) {
        view.findNavController().navigate(fragmentId)

    }
    fun callFragment(view: View, fragmentId: Int, bundle: Bundle) {
        view.findNavController().navigate(fragmentId,bundle)

    }
}