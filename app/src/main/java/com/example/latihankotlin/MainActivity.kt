package com.example.latihankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihankotlin.about.AboutActivity
import com.example.latihankotlin.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        travel_list.layoutManager = LinearLayoutManager(this)
        travel_list.adapter = RecyclerViewAdapter(this, items)

        about.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }

    private var items: MutableList<Item> = mutableListOf()

    private fun initData() {
        val name = resources.getStringArray(R.array.travel_name)
        val desc = resources.getStringArray(R.array.desc_name)
        val detail = resources.getStringArray(R.array.text_detail)
        val image = resources.obtainTypedArray(R.array.travel_image)
        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    desc[i],
                    detail[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        image.recycle()
    }
}
