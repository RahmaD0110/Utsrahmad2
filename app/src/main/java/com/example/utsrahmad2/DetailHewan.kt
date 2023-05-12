package com.example.utsrahmad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hewan)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hewan = intent.getParcelableExtra<Hewan>(MainActivity.INTENT_PARCELABLE)

        val imghewan = findViewById<ImageView>(R.id.img_item_photo)
        val namehewan = findViewById<TextView>(R.id.tv_item_name)
        val deschewan = findViewById<TextView>(R.id.tv_item_description)

        imghewan.setImageResource(hewan?.imghewan!!)
        namehewan.text = hewan.namehewan
        deschewan.text = hewan.deschewan
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}