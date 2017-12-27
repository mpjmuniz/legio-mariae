package org.legiomariae.tessera

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InitialPrayersFragment : Fragment() {

    /*
    * Layout code, no need to test
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.content_initial_prayers, container, false)

    /*@SuppressLint("NewApi")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fInitialPrayers.setOnScrollChangeListener { _ : View, _ : Int, dy : Int, _ : Int, _: Int ->
            if (dy > 0) fab.hide() else fab.show()
        }
    }*/
}
