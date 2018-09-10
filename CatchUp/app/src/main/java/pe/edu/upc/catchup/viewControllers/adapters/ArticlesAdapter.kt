package pe.edu.upc.catchup.viewControllers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_aricle.view.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article

class ArticlesAdapter(val articles: List<Article>, val context: Context) :
        RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_aricle, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles.get(position)
        holder.titleTextView.text = article.title
        // TODO: Assign picure
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val pictureImageView = view.pictureimageView
        val titleTextView = view.titleTextView

    }
    /*cada vista tiene un viewholder*/
}