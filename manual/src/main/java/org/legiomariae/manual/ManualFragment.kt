package org.legiomariae.manual

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_manual.*

/**
 * A simple [Fragment] subclass.
 */
class ManualFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manual, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wvManual.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }
        wvManual.settings.domStorageEnabled = true
        wvManual.settings.javaScriptEnabled = true
        wvManual.settings.allowFileAccess = true
        wvManual.settings.allowUniversalAccessFromFileURLs = true
        wvManual.loadUrl("file:///android_asset/Text/intro.html")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun inflateToc(view : ListView){

        val items : List<String> = listOf("ABC", "DEF", "GHI")
        //view.background = context.getColor(R.color.icons)
        view.adapter = ArrayAdapter<String>(activity, R.layout.content_item, items)
    }
}