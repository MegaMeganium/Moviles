package pe.edu.upc.catchup.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.json.JSONObject
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
import pe.edu.upc.catchup.network.ArticleResponse
import pe.edu.upc.catchup.network.NewsApi
import pe.edu.upc.catchup.viewControllers.adapters.ArticlesAdapter
import kotlin.math.log


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    var articles = ArrayList<Article>()
    lateinit var articlesRecyclerView: RecyclerView
    lateinit var articlesAdapter: ArticlesAdapter
    lateinit var articlesLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        articlesRecyclerView = view.articlesRecyclerView
        articlesAdapter = ArticlesAdapter(articles, view.context)
        articlesLayoutManager = GridLayoutManager(view.context, 2)

        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager

        AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                .addQueryParameter("apikey", getString(R.string.news_api_key))
                .addQueryParameter("country","us")
                .setPriority(Priority.LOW)
                .setTag("CatchUp")
                .build()
                .getAsObject(ArticleResponse::class.java, object: ParsedRequestListener<ArticleResponse> {
                    override fun onResponse(response: ArticleResponse?) {
                        Log.d("Response", response.toString())
                        val status = response!!.status
                        if(status.equals("error", true)){
                            Log.d("CatchUp", response.message)
                            return
                        }
                        articles = response.articles!!
                        articlesAdapter.articles = articles /*se debe convertir a mutable click y al foco rojo*/
                        articlesAdapter.notifyDataSetChanged()

                        /*val foundArticles = response.articles!!
                        Log.d("CatchUp","Found ${foundArticles.size}")
                        val firstSourceName = foundArticles.first().source.name
                        Log.d("CatchUp", "First Article Source Name is ${firstSourceName}")*/
                    }

                    override fun onError(anError: ANError?) {
                        Log.d("CatchUp", anError!!.message)
                    }

                })
        return view
    }

}

