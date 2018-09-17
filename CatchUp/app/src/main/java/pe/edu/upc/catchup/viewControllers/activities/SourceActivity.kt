package pe.edu.upc.catchup.viewControllers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import pe.edu.upc.catchup.R

import kotlinx.android.synthetic.main.activity_source.*
import kotlinx.android.synthetic.main.content_source.*
import pe.edu.upc.catchup.models.Source

class SourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent ?: return
        /*si nadie me ha llamado con un intento entonces retorno*/
        val source = Source.from(intent.extras)
        logoImageView.setDefaultImageResId(R.mipmap.ic_launcher)
        logoImageView.setErrorImageResId(R.mipmap.ic_launcher)
        logoImageView.setImageUrl(source.urlToLogo())
        nameTextview.text = source.name
    }

}
