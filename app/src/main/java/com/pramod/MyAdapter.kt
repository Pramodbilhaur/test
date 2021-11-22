package com.pramod
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import model.Datum

class MyAdapter( private var model_var : List<Datum>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    var list: List<Datum> = model_var
    private inner class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        var parentPanel: RelativeLayout = itemview.findViewById(R.id.parentPanel)
        var message: TextView = itemview.findViewById(R.id.name)

        var year: TextView = itemview.findViewById(R.id.year)
        var color: TextView = itemview.findViewById(R.id.color)
        fun bind(position: Int) {

            val recyclerViewModel = list[position]
            parentPanel.setBackgroundColor(Color.parseColor(recyclerViewModel.color))
            message.text = recyclerViewModel.name
            year.text = recyclerViewModel.pantoneValue
            color.text = recyclerViewModel.color

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent, false)
        return MyViewHolder(itemview)
    }


    override fun getItemCount(): Int {
        return model_var.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).bind(position)
    }

}