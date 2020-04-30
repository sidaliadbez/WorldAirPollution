package com.example.worldairpollution

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_list_contry.view.*


class ApiAdapter(val context: Context, var blads: ArrayList<blad>): RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(pay: blad, pos: Int) {
            itemView.nompay.text = pay.country
            itemView.valeur.text=pay.homeFeed2.data.aqi.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_list_contry, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return blads.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pay = blads[position]
        holder.setData(pay,position)
    }

}
