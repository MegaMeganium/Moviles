package pe.edu.upc.catchup.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.json.JSONObject
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
import pe.edu.upc.catchup.network.NewsApi
import pe.edu.upc.catchup.viewControllers.adapters.ArticlesAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    var article = ArrayList<Article>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val articleRecycleView = view.articlesRecyclerView
        val articlesAdapter = ArticlesAdapter(article, view.context)
        val articlesLayoutManager = GridLayoutManager(view.context, 2)

        articleRecycleView.adapter = articlesAdapter
        articleRecycleView.layoutManager = articlesLayoutManager

        AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                .addPathParameter("apiKey", getString(R.string.news_api_key))
                .addPathParameter("country", "us")
                .setTag("CatchUp")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(object: JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        Log.d("Response", response.toString())
                        val status = response!!.getString("status")
                        if(status.equals("error", true)){
                            Log.d("CatchUp", response.getString("message"))
                            return
                        }
                        val jsonArticles = response.getJSONArray("articles")
                        Log.d("CatchUp",jsonArticles.length() as String /* .toString() */)
                        //TODO: convert JSONarray to ArrayList<Article> and assing to artices
                    }

                    override fun onError(anError: ANError?) {
                        /*anError!! -> fuerza sintactiamente a que se comporte como no nulo (podria se nulo)*/
                        Log.d("CatchUp", anError!!.message)
                    }

                })

        return view
    }

}
