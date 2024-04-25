package com.kroger.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoxAdapter(private val foxes: List<Fox>) :
    RecyclerView.Adapter<FoxAdapter.FoxViewHolder>() {

    private fun onFoxClicked(adapaterPosition: Int) : Unit {
        foxes[adapaterPosition]
    }

    class FoxViewHolder(
        itemView: View,
        private val onFoxClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onFoxClicked(adapterPosition)
            }
        }

        val foxImage: ImageView = itemView.findViewById(R.id.fox_image)
        val foxName: TextView = itemView.findViewById(R.id.fox_name)
        val foxAge: TextView = itemView.findViewById(R.id.fox_age)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fox_card_view, parent, false)

        return FoxViewHolder(view) { position ->
            val fox = foxes[position]

            val bundle = bundleOf(
                "name" to fox.name,
                "age" to fox.age.toString(),
                "habitat" to fox.habitat,
                "image" to fox.image,
            )

            val detailFragment = FoxDetailFragment()

            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = foxes.size


    override fun onBindViewHolder(holder: FoxViewHolder, position: Int) {
        val fox = foxes[position]
        holder.foxName.text =
            holder.itemView.context.resources.getString(R.string.fox_name, fox.name)
        holder.foxAge.text =
            holder.itemView.context.resources.getString(R.string.fox_age, fox.age.toString())

        Glide.with(holder.itemView.context)
            .load(fox.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.foxImage)
    }
}