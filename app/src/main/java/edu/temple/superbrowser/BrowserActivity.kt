package edu.temple.superbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class BrowserActivity : AppCompatActivity(), BrowserControlFragment.AddInterface {

    private var numFragments = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.page_display)

        viewPager2.adapter = object: FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return numFragments
            }

            override fun createFragment(position: Int): Fragment {
                return PageViewerFragment()
            }

        }


        // Ensure browser page isn't added twice

    }

    override fun addPage() {
        numFragments++
        val viewPager2 = findViewById<ViewPager2>(R.id.page_display)
        (viewPager2.adapter as FragmentStateAdapter).notifyDataSetChanged()
        viewPager2.setCurrentItem(numFragments -1, true)
    }
}