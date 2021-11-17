package com.example.recyclerview_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bannerList: List<Banner> = listOf(
            Banner(R.drawable.ic_launcher_background,"Hello!!"),
            Banner(R.drawable.ic_launcher_background,"How are you ?"),
            Banner(R.drawable.ic_launcher_background,"I'm fine =)")
        )

        val bannersRecyclerView: RecyclerView = findViewById(R.id.banners_recyclerView)
            bannersRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        bannersRecyclerView.adapter = BannerAdapter(bannerList)
    }
}