package com.example.recyclerviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newLayout: GridLayoutManager
    lateinit var myDogList: ArrayList<DogModel>
    lateinit var myAdapter:DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView= findViewById(R.id.dog_recyclerview)
        newLayout= GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        myRecyclerView.layoutManager = newLayout
        myRecyclerView.setHasFixedSize(true)

        myDogList = setUpData()

        myAdapter = DogAdapter(applicationContext, myDogList)
        myRecyclerView.adapter = myAdapter
        
        
        
    }

    private fun setUpData(): ArrayList<DogModel> {
        var tempList = ArrayList<DogModel>()

        val dogNames = arrayOf("Jamba", "Mika", "Nexus", "Ghost", "Lumine", "Kuki",
            "Thor", "Oskar(IDK age)", "Duke", "McLovin (IDK age)")

        val dogAges = doubleArrayOf(13.0, 5.0, 1.5, 1.0, 0.25, 15.0, 12.0, 0.0, 13.0, 0.0)
        val dogImages = intArrayOf(R.drawable.jambalist,
            R.drawable.mikalist,
            R.drawable.nexuslist,
            R.drawable.ghostlist,
            R.drawable.luminelist,
            R.drawable.kukilist,
            R.drawable.thorlist,
            R.drawable.oskarlist,
            R.drawable.dukelist,
            R.drawable.mclovinlist,)

        for(i in dogNames.indices)
            tempList.add(DogModel(dogImages[i],dogNames[i],dogAges[i]))
        return tempList

    }
}