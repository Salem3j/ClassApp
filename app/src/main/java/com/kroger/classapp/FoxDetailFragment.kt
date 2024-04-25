package com.kroger.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class FoxDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_fox_detail,
            container,
            false
        )

        if(arguments != null) {
            val name = requireArguments().getString("name")
            val age = requireArguments().getString("age")
            val habitat = requireArguments().getString("habitat")
            val image = requireArguments().getString("image")

            view.findViewById<TextView>(R.id.fox_name_detail).text = resources.getString(R.string.fox_name, name)
            view.findViewById<TextView>(R.id.fox_age_detail).text = resources.getString(R.string.fox_age, age)
            view.findViewById<TextView>(R.id.fox_habitat_detail).text = resources.getString(R.string.fox_habitat, habitat)
            
            Glide.with(this).load(image).placeholder(R.drawable.ic_launcher_background).into(view.findViewById(R.id.fox_image_detail))
        }
        return view
    }

}