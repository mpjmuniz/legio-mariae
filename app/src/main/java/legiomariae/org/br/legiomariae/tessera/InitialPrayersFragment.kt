package legiomariae.org.br.legiomariae.tessera

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import legiomariae.org.br.legiomariae.R

class InitialPrayersFragment : Fragment() {

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
