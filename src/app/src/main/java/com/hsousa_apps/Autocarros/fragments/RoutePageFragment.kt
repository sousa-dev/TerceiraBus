package com.hsousa_apps.Autocarros.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.hsousa_apps.Autocarros.R
import com.hsousa_apps.Autocarros.data.Datasource
import com.hsousa_apps.Autocarros.data.Functions

class RoutePageFragment(private val id: String? = null, private val origin: String? = null, private val destination: String? = null, private val time: String? = null, private val op: Int? = 0) : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.route_page, container, false);
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val orig = view?.findViewById<TextView>(R.id.route_page_origin)
        val dest = view?.findViewById<TextView>(R.id.route_page_destination)
        val routeId = view?.findViewById<TextView>(R.id.route_page_id)
        val stops = view?.findViewById<TextView>(R.id.allStops)

        orig.text = origin
        dest.text = destination
        routeId.text = id


        if (op == 0){
            val allStops = Datasource().getAllStopTimes(id, time, origin, destination)
            for(stop in allStops)
                if(stop.value != "---") stops.text = stops.text.toString() + "\n" + stop.key + " - " + stop.value
        }
        else {
            val allTimes = Datasource().getAllTimes(id, origin, destination)
            for(stop in allTimes){
                stops.text = String.format("%s \n %-50s", stops.text.toString(), stop.key)
                stops.text = String.format("%s \n           ", stops.text.toString())
                for (value in stop.value)
                    if (value != "---") stops.text = String.format("%s%5s   ",stops.text.toString(), value)
            }

        }

        val fav = view?.findViewById<ImageButton>(R.id.favorite)

        if (listOf(origin, destination) in Datasource().getFavorite()){
            fav.setImageResource(R.mipmap.hearton)
            fav.tag = R.mipmap.hearton
        }

        if (op == 1) fav.visibility = View.INVISIBLE
        fav.setOnClickListener {
            if (fav.tag == R.mipmap.hearton){
                fav.setImageResource(R.mipmap.heartoff)
                fav.tag = R.mipmap.heartoff
                Datasource().removeFavorite(listOf(origin, destination) as List<String>)
                Toast.makeText(context, Functions().getFavRmMessage(), Toast.LENGTH_SHORT).show()
            }
            else{
                fav.setImageResource(R.mipmap.hearton)
                fav.tag = R.mipmap.hearton
                Datasource().addFavorite(origin, destination)
                Toast.makeText(context, Functions().getFavAddMessage(), Toast.LENGTH_SHORT).show()
            }
            val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val editor = pref.edit()
            val gson = Gson()

            val json: String = gson.toJson(Datasource().getFavorite())

            editor.putString("favorites", json)
            editor.commit()

        }

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