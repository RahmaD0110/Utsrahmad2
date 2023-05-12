package com.example.utsrahmad2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HewanAdapter (private val context: Context, private val hewan: List<Hewan>, val listener: (Hewan) ->Unit)
    : RecyclerView.Adapter<HewanAdapter.HewanViewHolder>(){


    class HewanViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imghewan = view.findViewById<ImageView>(R.id.img_item_photo)
        val namehewan = view.findViewById<TextView>(R.id.tv_item_name)
        val deschewan = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(hewan: Hewan, listener: (Hewan) -> Unit){
            imghewan.setImageResource(hewan.imghewan)
            namehewan.text = hewan.namehewan
            deschewan.text = hewan.deschewan
            itemView.setOnClickListener{
                listener(hewan)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HewanViewHolder {
        return HewanViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_hewan, parent, false)
        )
    }

    override fun getItemCount(): Int = hewan.size

    override fun onBindViewHolder(holder: HewanViewHolder, position: Int) {
        holder.bindView(hewan[position], listener)
    }
}