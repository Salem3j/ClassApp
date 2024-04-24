package com.kroger.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoxAdapter(private val foxes: List<Fox>) :
    RecyclerView.Adapter<FoxAdapter.FoxViewHolder>() {

    class FoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foxImage: ImageView = itemView.findViewById(R.id.fox_image)
        val foxName: TextView = itemView.findViewById(R.id.fox_name)
        val foxAge: TextView = itemView.findViewById(R.id.fox_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = FoxViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fox_card_view, parent, false),
    )

    override fun getItemCount() = foxes.size

    override fun onBindViewHolder(holder: FoxViewHolder, position: Int) {
        val fox = foxes[position]
        holder.foxName.text = holder.itemView.resources.getString(R.string.fox_name, fox.name)
        holder.foxAge.text = holder.itemView.resources.getString(R.string.fox_age, fox.age)
        holder.foxImage.setImageResource(fox.image)
    }
}