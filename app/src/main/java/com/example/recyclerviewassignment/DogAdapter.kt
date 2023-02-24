package com.example.recyclerviewassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DogAdapter(var ctx: Context, var dogList: ArrayList<DogModel>):
RecyclerView.Adapter<DogAdapter.DogCardViewHolder>() {


    class DogCardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var dogImage = itemView.findViewById<ImageView>(R.id.dog_image)
        var dogName = itemView.findViewById<TextView>(R.id.dog_name)
        var dogAge = itemView.findViewById<TextView>(R.id.dog_age)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val newView = LayoutInflater.from(parent.context).inflate(R.layout.dog_card_layout, parent, false)
        return DogCardViewHolder((newView))
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        var myDogCard: DogModel = dogList[position]
        holder.dogImage.setImageResource(myDogCard.dogImage!!)
        holder.dogName.text = myDogCard.dogName
        holder.dogAge.text = myDogCard.dogAge.toString() + " Years Old"

        holder.dogImage.setOnClickListener{
            Toast.makeText(ctx, "You selected: " + myDogCard.dogName, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dogList.size
    }



}