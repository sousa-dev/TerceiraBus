package com.SousaDev.TerceiraBus.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.data.Datasource
import com.SousaDev.TerceiraBus.data.Functions
import com.SousaDev.TerceiraBus.data.Route
import com.SousaDev.TerceiraBus.data.TypeOfDay
import com.SousaDev.TerceiraBus.models.CardModel
import com.SousaDev.TerceiraBus.models.RouteCardAdapter
import kotlin.collections.ArrayList


class SearchFragment(private var origin: String? = null, private var destination: String? = null, private var times: ArrayList<Route>? = null, private var unique_id: String = "") : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_layout, container, false);
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val from: TextView = view.findViewById(R.id.from_search)
        val to: TextView = view.findViewById(R.id.to_search)
        var TypeOfDay: TypeOfDay = TypeOfDay.WEEKDAY

        origin = origin?.let { Datasource().getStop(it).name }
        destination = destination?.let { Datasource().getStop(it).name }

        from.text = origin
        to.text = destination

        val swapStops: ImageButton = view.findViewById(R.id.swapStopsSearch)

        if (origin != null && destination != null) {
            createCards(this.view, origin!!, destination!!)
        }

        swapStops.setOnClickListener {
            val temp = from.text
            from.text = to.text
            to.text = temp

            origin = from.text.toString()
            destination = to.text.toString()

            if (listOf(origin, destination) !in Datasource().getFavorite()) {
                val fav = view?.findViewById<ImageButton>(R.id.favorite)
                fav.setImageResource(R.mipmap.heartoff)
                fav.tag = R.mipmap.heartoff
            }
            else{
                val fav = view?.findViewById<ImageButton>(R.id.favorite)
                fav.setImageResource(R.mipmap.hearton)
                fav.tag = R.mipmap.hearton
            }

            times = Functions().getOptions(from.text as String, to.text as String, TypeOfDay)
            createCards(this.view, from.text as String, to.text as String)
        }

        val SelectedTypeOfDay: RadioGroup = view.findViewById(R.id.weekdays)
        SelectedTypeOfDay.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.weekday_check) {
                TypeOfDay = com.SousaDev.TerceiraBus.data.TypeOfDay.WEEKDAY
                times = Functions().getOptions(from.text as String, to.text as String, TypeOfDay)
                createCards(this.view, from.text as String, to.text as String)
            } else if (checkedId == R.id.saturday_check) {
                TypeOfDay = com.SousaDev.TerceiraBus.data.TypeOfDay.SATURDAY
                times = Functions().getOptions(from.text as String, to.text as String, TypeOfDay)
                createCards(this.view, from.text as String, to.text as String)
            } else {
                TypeOfDay = com.SousaDev.TerceiraBus.data.TypeOfDay.SUNDAY
                times = Functions().getOptions(from.text as String, to.text as String, TypeOfDay)
                createCards(this.view, from.text as String, to.text as String)
            }
        }

        val fav = view?.findViewById<ImageButton>(R.id.favorite)

        if (listOf(origin, destination) in Datasource().getFavorite()) {
            fav.setImageResource(R.mipmap.hearton)
            fav.tag = R.mipmap.hearton
        }

        fav.setOnClickListener {
            if (fav.tag == R.mipmap.hearton) {
                fav.setImageResource(R.mipmap.heartoff)
                fav.tag = R.mipmap.heartoff
                Datasource().removeFavorite(listOf(origin, destination) as List<String>)
                Toast.makeText(
                    context,
                    resources.getString(R.string.remove_fav_toast_message),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                fav.setImageResource(R.mipmap.hearton)
                fav.tag = R.mipmap.hearton
                Datasource().addFavorite(origin, destination)
                Toast.makeText(
                    context,
                    resources.getString(R.string.add_fav_toast_message),
                    Toast.LENGTH_SHORT
                ).show()
            }
            val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val editor = pref.edit()
            val gson = Gson()

            val json: String = gson.toJson(Datasource().getFavorite())

            editor.putString("favorites", json)
            editor.commit()
        }
    }

    private fun createCards(view: View?, origin: String, destination: String){
        val rv = view?.findViewById<RecyclerView>(R.id.routes_recyclerView)
        val emptymsg = view?.findViewById<TextView>(R.id.emptymsg)
        emptymsg?.visibility = View.INVISIBLE
        var cards: MutableList<CardModel> = mutableListOf<CardModel>()
        Log.d("createCards", times
            .toString())

        if (times != null) {
            for(route in times!!) {
                Log.d(
                    "route.getStopTime",
                    route.getStopTime(Datasource().getStop(origin), 0).toString()
                )
                Log.d("route.info", route.info.toString())

                for (i in 0 until route.getNStops(route.getOrigin())!!)
                    route.getStopTime(Datasource().getStop(origin), i)?.let {
                        route.info?.let { it1 ->
                            CardModel(
                                route.id, origin, destination,
                                it, route.company, info = it1, unique_id = route.unique_id
                            )
                        }
                    }?.let { cards.add(it) }
            }
        }

        if(cards.size > 1) cards = cards.sortedWith(compareBy { it.time }).toList() as MutableList<CardModel>

        if (rv != null) {
            rv.layoutManager = LinearLayoutManager(view?.context)
            //Log.d("ERROR", cards.toString())
            rv?.adapter = RouteCardAdapter(view.context, cards as java.util.ArrayList<CardModel>)
        }
        if (cards.size == 0){
            emptymsg?.text = resources.getString(R.string.no_routes_found)
            emptymsg?.visibility = View.VISIBLE
        }

    }

    fun openRoutePage(
        id: String,
        origin: String,
        destination: String,
        time: String,
        view: View,
        op: Int = 0,
        TypeOfDay: TypeOfDay = com.SousaDev.TerceiraBus.data.TypeOfDay.WEEKDAY,
        info : String = "",
        unique_id: String = ""
    ){
        val ctx: AppCompatActivity = view?.context as AppCompatActivity
        val f : Fragment = RoutePageFragment(id, origin, destination, time, op, TypeOfDay, info, unique_id = unique_id)
        val t = ctx.supportFragmentManager.beginTransaction()

        if (t != null) {
            t.replace(R.id.frag_container, f)
            t.addToBackStack(null)
            t.commit()
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