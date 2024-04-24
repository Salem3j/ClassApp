package com.kroger.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class FoxListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val characters = mutableListOf<Fox>()

        val foxNames = listOf("Orange Fox", "Red Fox", "Arctic Fox", "Black Fox")

        for (i in 0..30) {
            characters.add(createFox(i, foxNames.random()))
        }

        val adapter = FoxAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createFox(id: Int, name: String) = Fox(
        id = id,
        name = name,
        age = Random.nextInt(10, 99),
        image = R.drawable.ic_launcher_background,
    )
}
