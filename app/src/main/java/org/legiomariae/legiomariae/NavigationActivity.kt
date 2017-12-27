package org.legiomariae.legiomariae

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*
import org.legiomariae.R
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
        fragmentManager.beginTransaction()
                .replace(R.id.mainFragment, org.legiomariae.tessera.CatenaFragment(), tag)
                .commit()
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.all_nav_draw_open, R.string.all_nav_draw_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_left_view.setNavigationItemSelectedListener(this)
        tvFragmentTitle.text = getString(R.string.cat_title)
    }

    /*
    * android studio generated code, no need to test
    * */
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    /*
    * Only screen redirection code, no need to test
    * */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val currentFragment = fragmentManager.findFragmentByTag(tag)

        when (item.itemId) {
            R.id.nav_catena -> {
                if(currentFragment !is CatenaFragment) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, CatenaFragment(), tag)
                            .commit()
                    tvFragmentTitle.text = getString(R.string.cat_title)
                }
            }
            R.id.nav_quarto -> {
                if(currentFragment !is RosaryQuarterFragment) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, RosaryQuarterFragment(), tag)
                            .commit()
                    tvFragmentTitle.text = getString(R.string.rqt_title)
                }
            }
            R.id.nav_meeting -> {
                if(currentFragment !is MeetingFragment){
                    fragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, MeetingFragment(), tag)
                        .commit()
                    tvFragmentTitle.text = getString(R.string.wmt_title)
                }
            }
            R.id.nav_worksheet -> {
                if(currentFragment !is WorksheetFragment){
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, WorksheetFragment(), tag)
                            .commit()
                    tvFragmentTitle.text = getString(R.string.wks_title)
                }
            }
            R.id.nav_manual -> {
                if(currentFragment !is ManualFragment){
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, ManualFragment(), tag)
                            .commit()
                    tvFragmentTitle.text = getString(R.string.man_title)
                }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
