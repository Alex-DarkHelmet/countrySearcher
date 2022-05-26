package com.toxicalman.countrysearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.toxicalman.countrysearcher.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName = binding.searchEditText.text.toString()

            lifecycleScope.launch {
                val countries = restCountries.getCountryByName(countryName)
                val country: Country = countries.first()

                binding.countryNameTextView.text = country.name
                binding.resultOfCapital.text = country.capital
                binding.resultOfPopular.text = convertNumber(country.population)
                binding.resultOfLanguage.text = country.languages.joinToString { it.name }
                binding.resultOfRegion.text = country.region

                loadSvg(binding.imageView, country.flag)
            }
        }
    }
}


