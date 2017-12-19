package legiomariae.org.br.legiomariae.tessera


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import legiomariae.org.br.legiomariae.R


/**
 * A simple [Fragment] subclass.
 */
class FinalPrayersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_final_prayers, container, false)
    }

}
