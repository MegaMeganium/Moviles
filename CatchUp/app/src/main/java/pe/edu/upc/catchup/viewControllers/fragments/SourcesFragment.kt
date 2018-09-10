package pe.edu.upc.catchup.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_surces.view.*

import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Source
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_surces, container, false)
        val sources = ArrayList<Source>()
        val sourcesRecyclerView = view.articlesRecyclerView

        sourcesRecyclerView.adapter = SourceAdapter(sources, view.context)
        sourcesRecyclerView.layoutManager = GridLayoutManager(view.context, 2)

        return view

    }


}
