package com.example.retrofit.presentation.splashScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.retrofit.R
import com.example.retrofit.presentation.newsList.NewsListFragment
import com.example.retrofit.presentation.newsList.NewsListFragmentViewModel
import com.example.retrofit.utils.ext.activityComponent
import com.example.retrofit.utils.ext.openFragment
import javax.inject.Inject

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    companion object {
        const val TAG = "SplashScreenFragment"
        fun newInstance() = SplashScreenFragment()
    }

    @Inject
    lateinit var newsListFragmentViewModel: NewsListFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().activityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsListFragmentViewModel.loadNews("", requireContext())
        newsListFragmentViewModel.items.observe(viewLifecycleOwner) {
            requireActivity().openFragment(
                NewsListFragment.TAG,
                NewsListFragment.newInstance(),
                R.id.container
            )
        }
    }

}