package org.legiomariae.meeting

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
import kotlinx.android.synthetic.main.fragment_meeting.*
import org.legiomariae.meeting.workitems.FrankDuffFragment
import org.legiomariae.meeting.workitems.PermanentInstructionFragment
import org.legiomariae.tessera.CatenaFragment
import org.legiomariae.tessera.FinalPrayersFragment
import org.legiomariae.tessera.InitialPrayersFragment

class MeetingFragment : Fragment() {

    /*
    * only layout code, no need to test
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meeting, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager.adapter = PageAdapter(childFragmentManager, activity.baseContext)

        /*
        * TODO: put the catena time to half the time from the minutes signature to the meeting's end
        * */

        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                pager.currentItem = position
            }
        })

        pager.currentItem = savedInstanceState?.getInt("currentFragment") ?: 0
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt("currentFragment", pager.currentItem)
        super.onSaveInstanceState(outState)
    }

    /*
    TODO: find a way to test this, make fields configurable
    */
    private class PageAdapter(fm: FragmentManager?, c : Context) : FragmentPagerAdapter(fm) {

        /* TODO: make this configurable*/
        private val fragments = listOf(InitialPrayersFragment(),
                PermanentInstructionFragment(), CatenaFragment(),
                FinalPrayersFragment(), FrankDuffFragment())

        private val titles = listOf(
                c.getString(R.string.ipr_title), c.getString(R.string.pin_title),
                c.getString(R.string.cat_title), c.getString(R.string.fpr_title),
                c.getString(R.string.fdf_title))

        override fun getCount(): Int = fragments.count()

        override fun getItem(position: Int): android.app.Fragment? {
            try {
                return fragments[position]
            } catch(e:Exception){}
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }
}
