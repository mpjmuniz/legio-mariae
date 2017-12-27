package org.legiomariae.manual

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_manual.*
import java.io.InputStreamReader

/**
 * A simple [Fragment] subclass.
 */
class ManualFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manual, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wvManual.webViewClient = WebViewClient()
        wvManual.settings.domStorageEnabled = true
        wvManual.loadDataWithBaseURL("file:///android_asset/",
                                     InputStreamReader(activity.assets.open("Text/intro.html")).readText() , "text/html", "UTF-8", null)
    }
}