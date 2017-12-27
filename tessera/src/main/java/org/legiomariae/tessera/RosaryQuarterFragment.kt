package org.legiomariae.tessera


import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v13.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rosary_quarter.*

class RosaryQuarterFragment : Fragment() {

    /*
    * Layout code, no need to test
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rosary_quarter, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager.adapter = PageAdapter(childFragmentManager, activity.baseContext)

        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                // When swiping between pages, select the
                // corresponding tab.
                pager.currentItem = position
            }
        })
    }

    /*
    * TODO: try to test this class
    * */
    private class PageAdapter(fm: FragmentManager?, c : Context) : FragmentPagerAdapter(fm) {

        private val fragments = listOf(InitialPrayersFragment(), FinalPrayersFragment())
        private val titles = listOf(c.getString(R.string.ipr_title), c.getString(R.string.fpr_title))

        override fun getCount(): Int = fragments.count()

        override fun getItem(position: Int): Fragment? {
            try {
                return fragments[position]
            } catch(e:Exception){}
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }
}
