package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab_week_03.R

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout untuk fragment list
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte),
            view.findViewById<View>(R.id.cappuccino),
            view.findViewById<View>(R.id.mocha)
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val fragmentBundle = Bundle().apply {
                    putInt(COFFEE_ID, coffee.id)
                }

                // pastikan action ada di nav_graph.xml
                coffee.findNavController().navigate(
                    R.id.coffee_id_action,
                    fragmentBundle
                )

            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
