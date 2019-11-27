package com.example.latihankotlin

import android.annotation.TargetApi
import android.content.ClipData
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.extras
        val img: FrameLayout = findViewById(R.id.fm_img)
        img.setBackgroundResource(bundle?.getInt("img")!!)
        val title: TextView = findViewById(R.id.tv_title)
        title.text = bundle?.getString("nama")
        val desc: TextView = findViewById(R.id.tv_desc)
        desc.text = bundle?.getString("desc")


    }
}
