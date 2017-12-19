package legiomariae.org.br.legiomariae.meeting

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
import legiomariae.org.br.legiomariae.R
import legiomariae.org.br.legiomariae.tessera.CatenaFragment
import legiomariae.org.br.legiomariae.tessera.FinalPrayersFragment
import legiomariae.org.br.legiomariae.tessera.InitialPrayersFragment

class MeetingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meeting, container, false)
    }

    private class PageAdapter(fm: FragmentManager?, c : Context) : FragmentPagerAdapter(fm) {

        /*
        * TODO: phase 1: put worksheet on navigation drawer
        *       phase 2: let only the president to configure the worksheet
        *
        * screens prioritization
        * TODO: c.getString(R.string.title_cl),
                c.getString(R.string.title_tr),
                c.getString(R.string.title_wr),
                c.getString(R.string.title_ct),
                c.getString(R.string.title_al),
                c.getString(R.string.title_sc),
                c.getString(R.string.title_om),
                c.getString(R.string.title_wd),
                c.getString(R.string.title_st),
                c.getString(R.string.title_fp),
                c.getString(R.string.title_fd)

                Future features:
                1. Worksheet available to everyone (Worksheet Substution)
                2. Manual availability to querying (manual substitution)
                3. Praesidium registration
                4. Worksheet available to president

                Spiritual Reading depends on 1
                Minutes Reading depends on 2

        * */

        private val fragments = listOf(InitialPrayersFragment(), PermanentInstructionFragment(),
                CatenaFragment(),
                FinalPrayersFragment(), FrankDuffFragment())
        /*private val titles = listOf() */
        private val titles = listOf(c.getString(R.string.title_ip), c.getString(R.string.title_pi),
                c.getString(R.string.title_ct), c.getString(R.string.title_fp), c.getString(R.string.title_fd))
        /*
        *  Ordem de relevância:
        *  Instrução Permanente -> só deve aparecer se estiver na primeira reunião do mês
        *  módulo de dúvidas -> mostrar em cada tela o que o manual diz sobre ela
        * */
        override fun getCount(): Int = fragments.count()

        override fun getItem(position: Int): android.app.Fragment? {
            try {
                return fragments[position]
            } catch(e:Exception){}
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager.adapter = PageAdapter(childFragmentManager, activity.baseContext)

        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                pager.currentItem = position
            }
        })
    }

}
