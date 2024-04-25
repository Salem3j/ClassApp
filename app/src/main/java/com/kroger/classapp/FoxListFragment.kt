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

        val foxImages = listOf(
            "https://images6.fanpop.com/image/photos/40000000/FOX-fox-40076151-960-633.jpg",
            "https://4.bp.blogspot.com/-yVYfwTNg6N8/VH4YIbkDNtI/AAAAAAAAuWE/RyRWjq5OxeE/s1600/tl-arcticfox.gif",
            "https://www.treehugger.com/thmb/MhvCK8fGBESkPol_goB6x4j7yLI=/2121x1414/filters:fill(auto,1)/red-fox--vulpes-vulpes-160516547-f158a46cbd6e4bfd872c1194371c3404.jpg",
            "https://i.pinimg.com/originals/8c/47/88/8c47885317bd376f78ab40292b6e94f7.jpg",
        )

        val foxHabitats = listOf(
            "Burrow",
            "Forest",
            "Snow",
            "Woods",
        )

        for (i in 0..30) {
            characters.add(createFox(i, foxNames.random(), foxHabitats.random(), foxImages.random()))
        }

        val adapter = FoxAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createFox(id: Int, name: String, habitat: String, image: String) = Fox(
        id = id,
        name = name,
        age = Random.nextInt(10, 99),
        habitat = habitat,
        image = image,
    )
}
