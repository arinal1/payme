package com.arinal.payme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
    }

    private fun initList(){
        val data = listOf(
            Data("Dana", R.drawable.logo_dana, "082243836969", "Muhammad Arinal", R.drawable.qr_dana, "id.dana"),
            Data("Gopay", R.drawable.logo_gopay, "082243836969",  "Arinal", R.drawable.qr_gopay, "com.gojek.app"),
            Data("LinkAja", R.drawable.logo_linkaja, "082243836969", "Muhammad Arinal Rido", R.drawable.qr_linkaja, "com.telkom.mwallet"),
            Data("Mandiri", R.drawable.logo_mandiri, "1390016584868", "Muhammad Arinal Rido", R.drawable.qr_mandiri, "com.bankmandiri.mandirionline"),
            Data("Ovo", R.drawable.logo_ovo, "082243836969", "Arinal Muhammad", R.drawable.qr_ovo, "ovo.id")
        )
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = MainAdapter(data, this)
    }
}
