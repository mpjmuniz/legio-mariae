package legiomariae.org.br.legiomariae.meeting

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*
import legiomariae.org.br.legiomariae.R
import legiomariae.org.br.legiomariae.tessera.CatenaFragment
import legiomariae.org.br.legiomariae.tessera.RosaryQuarterFragment

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val transaction = fragmentManager.beginTransaction()
        currentFragment = CatenaFragment()
        transaction.replace(R.id.mainFragment, currentFragment)
        transaction.commit()
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_catena -> {
                if(currentFragment !is CatenaFragment) {
                    val transaction = fragmentManager.beginTransaction()
                    currentFragment = CatenaFragment()
                    transaction.replace(R.id.mainFragment, currentFragment)
                    transaction.commit()
                    tvFragmentTitle.text = getString(R.string.title_ct)
                }
            }
            R.id.nav_quarto -> {
                if(currentFragment !is RosaryQuarterFragment) {
                    val transaction = fragmentManager.beginTransaction()
                    currentFragment = RosaryQuarterFragment()
                    transaction.replace(R.id.mainFragment, currentFragment)
                    transaction.commit()
                    tvFragmentTitle.text = getString(R.string.title_rq)
                }
            }
            R.id.nav_meeting -> {
                if(currentFragment !is MeetingFragment){
                    val transaction = fragmentManager.beginTransaction()
                    currentFragment = MeetingFragment()
                    transaction.replace(R.id.mainFragment, currentFragment)
                    transaction.commit()
                    tvFragmentTitle.text = getString(R.string.title_mt)
                }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
