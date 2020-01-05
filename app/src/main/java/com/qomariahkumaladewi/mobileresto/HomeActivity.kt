package com.qomariahkumaladewi.mobileresto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_home.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        val list = findViewById<RecyclerView>(R.id.rv_home)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MenuAdapter(this, items)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.resto_name)
        val image= resources.obtainTypedArray(R.array.resto_image)
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
