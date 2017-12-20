package legiomariae.org.br.legiomariae.meeting


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import legiomariae.org.br.legiomariae.R

class FrankDuffFragment : Fragment() {

    /*
    * Layout code, no need to test
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_frank_duff, container, false)
    }

}