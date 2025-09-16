package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private lateinit var coffeeTitle: TextView
    private lateinit var coffeeDesc: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi TextView setelah view terbuat
        coffeeTitle = view.findViewById(R.id.coffee_title)
        coffeeDesc = view.findViewById(R.id.coffee_desc)

        // Ambil data argument
        val coffeeId = arguments?.getInt(COFFEE_ID) ?: 0
        setCoffeeData(coffeeId)

        // Back button listener
        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle.text = getString(R.string.affogato_title)
                coffeeDesc.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle.text = getString(R.string.americano_title)
                coffeeDesc.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle.text = getString(R.string.latte_title)
                coffeeDesc.text = getString(R.string.latte_desc)
            }
            R.id.cappuccino -> {
                coffeeTitle.text = getString(R.string.cappuccino_title)
                coffeeDesc.text = getString(R.string.cappuccino_desc)
            }
            R.id.mocha -> {
                coffeeTitle.text = getString(R.string.mocha_title)
                coffeeDesc.text = getString(R.string.mocha_desc)
            }
        }
    }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"

        fun newInstance(coffeeId: Int): DetailFragment {
            val fragment = DetailFragment()
            fragment.arguments = Bundle().apply {
                putInt(COFFEE_ID, coffeeId)
            }
            return fragment
        }
    }
}
