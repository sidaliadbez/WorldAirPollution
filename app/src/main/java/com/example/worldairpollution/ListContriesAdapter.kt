package com.example.worldairpollution

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_list_contry.view.*

class ListContriesAdapter(val context: Context, var countries: List<country>): RecyclerView.Adapter<ListContriesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(pay: country, pos: Int) {
            itemView.nompay.text = pay.nomPay
            itemView.valeur.text= pay.valPay.toString()
            itemView.etat.text= pay.etatPay
            itemView.date.text= pay.datePay
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_list_contry, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pay = countries.get(position)
        holder.setData(pay,position)
    }

}