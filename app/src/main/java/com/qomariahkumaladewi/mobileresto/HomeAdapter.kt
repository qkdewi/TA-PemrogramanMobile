package com.qomariahkumaladewi.mobileresto

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HomeAdapter(private val context: Context, private val items: List<Item>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, parent,false))


    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.home_name)
        private val image = view.findViewById<ImageView>(R.id.home_image)

        fun bindItem(items: Item){
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
        }
    }
}