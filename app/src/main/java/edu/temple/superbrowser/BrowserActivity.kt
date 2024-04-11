package edu.temple.superbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Browser
import android.view.WindowManager
import androidx.annotation.Px
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class BrowserActivity : AppCompatActivity(), DataInterface {

    private var numFragments = 1
    private val titleList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

        val viewPager2 = findViewById<ViewPager2>(R.id.page_display)

        viewPager2.adapter = object: FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return numFragments
            }

            override fun createFragment(position: Int): Fragment {
                return PageViewerFragment()
            }

        }

        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                setTitle("SuperBrowser - " + position)
            }
        } )

        supportFragmentManager
            .beginTransaction()
            .add(R.id.browser_control, BrowserControlFragment())
            .commit()


        // Ensure browser page isn't added twice

    }

    override fun pageChange(title: String) {
        setTitle("SuperBrowser - " + title)
        titleList.add(title)
    }
    override fun addPage() {
        numFragments++
        val viewPager2 = findViewById<ViewPager2>(R.id.page_display)
        (viewPager2.adapter as FragmentStateAdapter).notifyDataSetChanged()
        viewPager2.setCurrentItem(numFragments -1, true)
    }


}