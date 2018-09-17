package pe.edu.upc.catchup.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_source.view.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Source
import pe.edu.upc.catchup.viewControllers.activities.SourceActivity

class SourceAdapter (var sources: List<Source>, val context: Context) :
        RecyclerView.Adapter<SourceAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_source, parent, false))
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    override fun onBindViewHolder(holder: SourceAdapter.ViewHolder, position: Int) {
        val source = sources[position]
        holder.logoTextView.text = source.name
        //falta el logoiMAGE
    }

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val logoImageView = view.logoImageView
        val logoTextView = view.logoTextView
        val sourceLayout = view.sourceLayout
        //FALTA EL LOGOimage

        fun updateForm(source: Source){
            logoImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            logoImageView.setErrorImageResId(R.mipmap.ic_launcher)
            logoImageView.setImageUrl(source.urlToLogo())
            logoTextView.text = source.name

            sourceLayout.setOnClickListener {view ->
                val context = view.context
                //donde estoy hacia donde voy
                context.startActivity(Intent(context, SourceActivity::class.java)
                        .putExtras(source.toBundle()))
            }


        }
    }

}