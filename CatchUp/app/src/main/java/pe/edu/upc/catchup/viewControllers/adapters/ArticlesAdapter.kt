package pe.edu.upc.catchup.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_aricle.view.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
import pe.edu.upc.catchup.viewControllers.activities.ArticleActivity

class ArticlesAdapter(var articles: List<Article>, val context: Context) :
        RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_aricle, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles.get(position)
        holder.updateFrom(article)
        // TODO: Assign picure
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val pictureImageView = view.pictureimageView
        val titleTextView = view.titleTextView
        val articleLayout = view.articleLayout

        fun updateFrom(article: Article){
            pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
            pictureImageView.setImageUrl(article.urlToImage)
            titleTextView.text = article.title

            articleLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(Intent(context, ArticleActivity::class.java)
                        .putExtras(article.toBundle()))
                /*la info bundle lo pasa a la otra vista*/

            }
        }

    }
    /*cada vista tiene un viewholder*/
}