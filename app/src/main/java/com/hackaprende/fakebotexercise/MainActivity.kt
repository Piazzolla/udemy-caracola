package com.hackaprende.fakebotexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackaprende.fakebotexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.caracolaRecycler.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)

        val qandaList = mutableListOf<Qora>()

        qandaList.add(Qora("1","Comemos tacos hoy?", true))
        qandaList.add(Qora("2,","no", false))


        val adapter = CaracolaAdapter()
        binding.caracolaRecycler.adapter = adapter
        adapter.submitList(qandaList)
    }
}