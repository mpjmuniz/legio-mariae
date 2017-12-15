package legiomariae.org.br.legiomariae

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class CatenaLegionis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catena_legionis)
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.latin_portuguese, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.btnLatim -> {
                Thread({
                    try {
                        runOnUiThread({
                            if(item.isChecked) {
                                Toast.makeText(this, "Trocando para o latim", Toast.LENGTH_SHORT)
                                        .show()
                                item.isChecked = false
                                tvAntInicial.text = resources.getString(R.string.antifonaCtLt)
                                tvAntFinal.text = resources.getString(R.string.antifonaCtLt)
                                tvMagnificat.text = resources.getString(R.string.magnificatCtLt)
                                tvPreces.text = resources.getString(R.string.precesCtLt)
                            }
                            else {
                                Toast.makeText(this, "Trocando para o português", Toast.LENGTH_SHORT)
                                        .show()
                                item.isChecked = true

                                tvAntInicial.text = resources.getString(R.string.antifonaCt)
                                tvAntFinal.text = resources.getString(R.string.antifonaCt)
                                tvMagnificat.text = resources.getString(R.string.magnificatCt)
                                tvPreces.text = resources.getString(R.string.precesCt)

                            }
                        })
                    } catch (e: InterruptedException) {
                        // TODO Auto-generated catch block
                        e.printStackTrace()
                    }
                }).run()
            }
            else -> {}
        }

        return true
    }*/
}
