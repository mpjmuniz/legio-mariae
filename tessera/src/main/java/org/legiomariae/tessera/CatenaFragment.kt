package org.legiomariae.tessera

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CatenaFragment : Fragment() {

    /*
    * Layout code, no need to test
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.content_catena, container, false)

    /*override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*fCatena.setOnScrollChangeListener { _: NestedScrollView?,
                                            _: Int, scrollY: Int, _: Int, _: Int ->
            if(scrollY > 0 ) fab.hide() else fab.show()
        }*/


    }*/
}