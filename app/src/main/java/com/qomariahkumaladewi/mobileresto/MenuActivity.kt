package com.qomariahkumaladewi.mobileresto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val list = findViewById<RecyclerView>(R.id.list_menu)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MenuAdapter(this, items)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.food_name)
        val image= resources.obtainTypedArray(R.array.food_image)
        items.clear()

        for(i in name.indices) {
            items.add(
                Item(name[i],
                image.getResourceId(i, 0))
            )
        }

        image.recycle()
    }
}
