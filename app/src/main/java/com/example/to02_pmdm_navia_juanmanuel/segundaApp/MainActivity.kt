package com.example.to02_pmdm_navia_juanmanuel.segundaApp

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to02_pmdm_navia_juanmanuel.databinding.ActivityMainBinding
import com.example.to02_pmdm_navia_juanmanuel.segundaApp.adapter.adapter
import com.example.to02_pmdm_navia_juanmanuel.segundaApp.adapter.sitiosWebsProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sitiosWebsMutableList = sitiosWebsProvider.sitiosWebsLists.toMutableList()
    private lateinit var adapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configFilter()
        initRecyclerView()
        configSwipe()
    }

    private fun initRecyclerView() {
        adapter = adapter(
            sitiosWebList = sitiosWebsMutableList,
            onClickListener = { sitioWeb -> onItemSelected(sitioWeb) },
            onClickDelete = { position -> onDeletedItem(position) }
        )
        binding.recyclerSitiosWeb.layoutManager = LinearLayoutManager(this)
        binding.recyclerSitiosWeb.adapter = adapter
    }

    private fun onItemSelected(sitioWebs: sitiosWebs) {
        Toast.makeText(
            this,
            "${sitioWebs.description}\nEmail: ${sitioWebs.email}",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun onDeletedItem(position: Int) {
        sitiosWebsMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun configFilter() {
        binding.etFilter.addTextChangedListener{ userFilter ->
            val superHeroFiltered = sitiosWebsMutableList.filter { superHero -> superHero.name.lowercase().contains(userFilter.toString().lowercase()) }
            adapter.updateSitiosWebList(superHeroFiltered)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun configSwipe() {
//binding.swipe.isEnabled= false
        binding.swipe.setColorSchemeColors(R.color.holo_red_dark, R.color.black)
        binding.swipe.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.darker_gray))
        binding.swipe.setOnRefreshListener {
            Log.i("juanma","funciona")




            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipe.isRefreshing = false
            }, 2000 )
        }
    }
}
