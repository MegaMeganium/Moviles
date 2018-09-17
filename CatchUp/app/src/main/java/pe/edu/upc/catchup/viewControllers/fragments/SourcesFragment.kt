package pe.edu.upc.catchup.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_surces.view.*

import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Source
import pe.edu.upc.catchup.network.ArticleResponse
import pe.edu.upc.catchup.network.NewsApi
import pe.edu.upc.catchup.network.SourcesResponse
import pe.edu.upc.catchup.viewControllers.adapters.SourceAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SourcesFragment : Fragment() {

    var sources = ArrayList<Source>()
    lateinit var sourcesRecyclerView: RecyclerView
    lateinit var sourcesAdapter: SourceAdapter
    lateinit var sourcesLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_surces, container, false)

        sourcesRecyclerView = view.sourcesRecyclerView
        sourcesAdapter = SourceAdapter(sources, view.context)
        sourcesLayoutManager = GridLayoutManager(view.context, 2)

        sourcesRecyclerView.adapter = sourcesAdapter
        sourcesRecyclerView.layoutManager = sourcesLayoutManager

        NewsApi.requestSources(getString(R.string.news_api_key),
                {response -> handlerResponse(response)},
                {error -> handleError(error)})

        return view
    }

    private fun handlerResponse(response: SourcesResponse?) {
        val status = response!!.status
        if(status.equals("error", true)){
            Log.d("CatchUp", response.message)
            return
        }
        sources = response.sources!!
        sourcesAdapter.sources = sources
        sourcesAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?){
        Log.d("CatchUp", anError!!.message)
    }


}
