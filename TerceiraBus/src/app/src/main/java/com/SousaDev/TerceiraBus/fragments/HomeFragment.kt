package com.SousaDev.TerceiraBus.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.data.Datasource
import com.SousaDev.TerceiraBus.data.Functions
import com.SousaDev.TerceiraBus.data.Stop
import com.SousaDev.TerceiraBus.models.CardModel
import com.SousaDev.TerceiraBus.models.RouteCardAdapter
import com.google.android.material.textfield.TextInputEditText
import java.util.ArrayList
import kotlin.math.log

private var vieww: View? = null

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home, container, false);
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val from: AutoCompleteTextView = view.findViewById(R.id.from_home)
        val to: AutoCompleteTextView = view.findViewById(R.id.to_home)
        val actv_from: ImageView = view.findViewById(R.id.actv1)
        val actv_to: ImageView = view.findViewById(R.id.actv2)
        setVieww(view)

        val search: Button = view.findViewById(R.id.homeSearch)
        val swapStops: ImageButton = view.findViewById(R.id.swapStops)
        from.visibility = View.INVISIBLE
        to.visibility = View.INVISIBLE
        actv_from.visibility = View.INVISIBLE
        actv_to.visibility = View.INVISIBLE
        swapStops.visibility = View.INVISIBLE
        val fav: TextView = view.findViewById(R.id.home_favouriteLabel1)
        fav.visibility = View.INVISIBLE

        val getDirections = view.findViewById<Button>(R.id.homeSearch)
        val destination = view.findViewById<TextInputEditText>(R.id.find_routes_map)
        var searchSTR: String = ""

        destination.doOnTextChanged { text, start, before, count ->
            searchSTR = text.toString()
        }

        getDirections.setOnClickListener{
            if (searchSTR != ""){
                val search_split: String = searchSTR.replace(" ", "+")
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=$search_split")
                    ).setPackage("com.google.android.apps.maps"))
            }
            else{
                Toast.makeText(context, resources.getString(R.string.map_dest_blank), Toast.LENGTH_SHORT).show()
            }
        }


        /**
        from.threshold = 2
        to.threshold = 2

        val adapter1: ArrayAdapter<Stop> = ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, Datasource().getStops().sortedWith(compareBy { it.name }))
        from.setAdapter(adapter1)
        val adapter2: ArrayAdapter<Stop> = ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, Datasource().getStops().sortedWith(compareBy { it.name }))
        to.setAdapter(adapter2)

        createCards(this.view)

        actv_from.setOnClickListener {
            //from.setAdapter(ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, Datasource().getCorrespondence(to.text.toString()) as MutableList<Stop>))
            from.showDropDown()
        }

        actv_to.setOnClickListener {
            //to.setAdapter(ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, Datasource().getCorrespondence(to.text.toString()) as MutableList<Stop>))
            to.showDropDown()
        }

        swapStops.setOnClickListener {
            val temp = from.text
            from.text = to.text
            to.text = temp
        }

        search.setOnClickListener{
            if (from.editableText.toString() != "" && to.editableText.toString() != "")
                swapFrags(SearchFragment(from.editableText.toString(), to.editableText.toString(), Functions().getOptions(from.editableText.toString(), to.editableText.toString())))
            else
                Toast.makeText(context, resources.getString(R.string.toast_search_message), Toast.LENGTH_SHORT).show()
        }

        //TODO: improve favorite save system
        saveFav()**/
    }

    private fun saveFav(){
        val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        val gson = Gson()

        val json: String = gson.toJson(Datasource().getFavorite())

        editor.putString("favorites", json)
        editor.commit()
    }

    private fun createCards(view: View?){
        val rv = view?.findViewById<RecyclerView>(R.id.home_recyclerview)
        val emptymsg = view?.findViewById<TextView>(R.id.home_emptymsg)
        emptymsg?.visibility = View.INVISIBLE
        var cards: MutableList<CardModel> = mutableListOf<CardModel>()

        for (fav in Datasource().getFavorite())
            cards.add(CardModel("", fav[0], fav[1], "", 0, delete = true))

        if (rv != null) {
            rv.layoutManager = LinearLayoutManager(view?.context)
            var adapter = RouteCardAdapter(view.context, cards as ArrayList<CardModel>, 2)
            rv?.adapter = adapter
        }
        if (cards.size == 0){
            emptymsg?.text = resources.getString(R.string.no_fav_message)
            emptymsg?.visibility = View.VISIBLE
        }

    }

    fun openFavRoute(origin: String, destination: String, view: View){
            val ctx: AppCompatActivity = view?.context as AppCompatActivity
            val f : Fragment = SearchFragment(origin, destination, Functions().getOptions(origin, destination))
            val t = ctx.supportFragmentManager.beginTransaction()

            if (t != null) {
                t.replace(R.id.frag_container, f)
                t.addToBackStack(null)
                t.commit()
            }
    }

    private fun setVieww(view: View){
        vieww = view
    }
    fun getVieww(): View? {
        return vieww
    }

    fun notifyDataChange(view: View){
        Log.d("error", Datasource().getFavorite().toString())

        var RV = view.findViewById<RecyclerView>(R.id.home_recyclerview)
        var emptymsg = view.findViewById<TextView>(R.id.home_emptymsg)
        var cards: MutableList<CardModel> = mutableListOf<CardModel>()

        for (fav in Datasource().getFavorite())
            cards.add(CardModel("", fav[0], fav[1], "", 0, delete = true))

        /**
        if (cards.isEmpty())
            emptymsg.visibility = View.VISIBLE
        else
            emptymsg.visibility = View.INVISIBLE
        **/
        //Log.d("error", cards.toString())

        var adapter = RouteCardAdapter(view.context, cards as ArrayList<CardModel>, 2)
        RV.adapter = adapter
        adapter.notifyDataSetChanged()
        }

    private fun swapFrags(f : Fragment) {
        val t = activity?.supportFragmentManager?.beginTransaction()
        if (t != null) {
            t.replace(R.id.frag_container, f)
            t.addToBackStack(null)
            t.commit()
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                /*
                R.id.bttnStores -> {
                    swapFrags(StoresFragment())
                }

                R.id.bttnProds -> {
                    swapFrags(CategoriesFragment())
                }

                R.id.searchBar -> {
                    view?.findViewById<SearchView>(R.id.searchBar)?.onActionViewExpanded()
                }*/
            }
        }
    }

}