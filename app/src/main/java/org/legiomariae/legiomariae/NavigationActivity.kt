
package org.legiomariae.legiomariae

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_navigation.*
import org.legiomariae.R
import org.legiomariae.R.id.*
import org.legiomariae.manual.ManualFragment
import org.legiomariae.meeting.MeetingFragment
import org.legiomariae.meeting.worksheet.WorksheetFragment
import org.legiomariae.tessera.CatenaFragment
import org.legiomariae.tessera.RosaryQuarterFragment

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val tag : String = "current"

    /*
    * Only layout code, no need to test
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)
        val toggle = object : ActionBarDrawerToggle(
                this, drawer_layout, toolbar,
                R.string.all_nav_draw_open,
                R.string.all_nav_draw_close){

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                if (drawer_layout.isDrawerVisible(GravityCompat.END)) {
                    if (fragmentManager.findFragmentByTag(tag) !is ManualFragment) {
                        nav_right_view.background = null
                        drawer_layout.closeDrawer(GravityCompat.END)
                    }
                    else
                        (fragmentManager.findFragmentByTag(tag) as ManualFragment).inflateToc(nav_right_view)
                }

                super.onDrawerSlide(drawerView, slideOffset)
            }
        }
        displayFragment(savedInstanceState?.getInt("outerFragment") ?: nav_catena)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_left_view.setNavigationItemSelectedListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        val fragmentId = when(fragmentManager.findFragmentByTag(tag)){
            is RosaryQuarterFragment -> nav_quarter
            is MeetingFragment -> nav_meeting
            is ManualFragment -> nav_manual
            is WorksheetFragment -> nav_worksheet
            else -> nav_catena
        }

        outState?.putInt("outerFragment", fragmentId)

        super.onSaveInstanceState(outState)
    }

    /*
    * android studio generated code, no need to test
    * */
    override fun onBackPressed() {
        when {
            drawer_layout.isDrawerOpen(GravityCompat.START)
                -> drawer_layout.closeDrawer(GravityCompat.START)
            drawer_layout.isDrawerOpen(GravityCompat.END)
                -> drawer_layout.closeDrawer(GravityCompat.END)
            else
                -> super.onBackPressed()
        }
    }

    /*
    * Only screen redirection code, no need to test
    * */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayFragment(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun displayFragment(fragId : Int){
        val fragment = when(fragId){
            R.id.nav_quarter -> RosaryQuarterFragment()
            R.id.nav_meeting -> MeetingFragment()
            R.id.nav_worksheet -> WorksheetFragment()
            R.id.nav_manual -> ManualFragment()
            else -> CatenaFragment()
        }

        val title = when(fragId){
            R.id.nav_quarter -> getString(R.string.rqt_title)
            R.id.nav_meeting -> getString(R.string.wmt_title)
            R.id.nav_worksheet -> getString(R.string.wks_title)
            R.id.nav_manual -> getString(R.string.man_title)
            else -> getString(R.string.cat_title)
        }

        fragmentManager.beginTransaction()
            .replace(R.id.mainFragment, fragment, tag)
            .commit()
        tvFragmentTitle.text = title
    }
}
