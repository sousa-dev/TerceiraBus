package com.SousaDev.TerceiraBus.models

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.fragments.HomeFragment
import com.SousaDev.TerceiraBus.fragments.SearchFragment
import java.util.ArrayList

class StopTimesAdapter(private val context: Context, private val Times: ArrayList<StopModel>) : RecyclerView.Adapter<StopTimesAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        // to inflate the layout for each item of recycler view.
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.stop_times_layout, parent, false)
        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        // to set data to textview and imageview of each card layout
        val time: StopModel = Times[position]
        holder.stop.text = time.name
        holder.time.text = time.times
        if (time.op) holder.stop.setTextColor(Color.parseColor("#981CC3"))
    }

    override fun getItemCount(): Int {
        return Times.size
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stop: TextView
        val time: TextView

        init {
            stop = itemView.findViewById(R.id.stop_name)
            time = itemView.findViewById(R.id.stop_time)
        }
    }

}