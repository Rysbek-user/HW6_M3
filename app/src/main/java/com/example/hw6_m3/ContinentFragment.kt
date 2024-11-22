package com.example.hw6_m3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6_m3.databinding.FragmentContinentBinding

class ContinentFragment : Fragment() {

    private lateinit var binding: FragmentContinentBinding
    private val continentList = arrayListOf("Eurasia", "Africa", "North America", "South America", "Australia")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContinentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continentAdapter = ContinentAdapter(continentList) { position ->
            val countryFragment = CountryFragment().apply {
                arguments = Bundle().apply {
                    putString("key1", continentList[position])
                }
            }
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, countryFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.rvContinent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = continentAdapter
        }
    }
}
