package pe.edu.upc.catchup.viewControllers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import pe.edu.upc.catchup.R

import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.content_article.*
import pe.edu.upc.catchup.models.Article

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //val intent = intent
        //if(intent == null) return
        val intent = intent?: return
        val article = Article.from(intent.extras)/*quiero los extra de bundle que me paso la vista anterior*/

        pictureimageView.setDefaultImageResId(R.mipmap.ic_launcher)
        pictureimageView.setErrorImageResId(R.mipmap.ic_launcher)
        pictureimageView.setImageUrl(article.urlToImage)
        titleTextView.text = article.title
        descriptionTextView.text = article.description
    }

}
