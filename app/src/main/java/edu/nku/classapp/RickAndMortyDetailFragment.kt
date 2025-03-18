package edu.nku.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class RickAndMortyDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)

        // Get arguments bundle
        arguments?.let { bundle ->
            // 1. Retrieve all data
            val name = bundle.getString("name")
            val age = bundle.getInt("age")
            val planet = bundle.getString("planet")
            val imageUrl = bundle.getString("picture")

            // Get references to views
            val nameTextView = view.findViewById<TextView>(R.id.character_name_detail)
            val ageTextView = view.findViewById<TextView>(R.id.character_age_detail)
            val planetTextView = view.findViewById<TextView>(R.id.character_planet_detail)
            val imageView = view.findViewById<ImageView>(R.id.character_image_detail)

            // Set the data
            nameTextView.text = "Name: $name"
            ageTextView.text = "Age: $age"
            planetTextView.text = "Location: $planet"

            // Load image with Glide
            Glide.with(requireContext())
                .load(imageUrl)
                .into(imageView)
        }

        return view
    }
}