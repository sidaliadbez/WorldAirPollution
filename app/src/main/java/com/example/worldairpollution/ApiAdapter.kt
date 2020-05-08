package com.example.worldairpollution

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.card_list_contry.view.*
import androidx.core.util.Pair


class ApiAdapter(val context: Context, var blads: ArrayList<blad>): RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var dowla: blad? = null
init {
itemView.details.setOnClickListener {
    val intent = Intent(context, DetailCountryActivity::class.java)

    //intent.putExtra("dowla", dowla)
    val p1 :Pair<View,String> = Pair(itemView.nompay,"nompay")
    val p2 :Pair<View,String> = Pair(itemView.flag,"drapeau")

    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, p1,p2)
    context.startActivity(intent, options.toBundle())
}
}
        fun setData(pay: blad, pos: Int) {
            dowla= pay
            itemView.nompay.text = pay.country
            itemView.valeur.text="Value: "+pay.homeFeed2.data.aqi
            if (pay.homeFeed2.data.aqi=="-"){
                itemView.etat.text="Stat: -"
            }else{


            when(pay.homeFeed2.data.aqi.toInt()){
                in 0..50 -> itemView.etat.text="Stat: Excellent"
                in  51..100-> itemView.etat.text= "Stat: Good"
                in  101..150-> itemView.etat.text= "Stat: Lightly Polluted"
                in  151..200-> itemView.etat.text= "Stat: Moderately Polluted"
                in  201..300-> itemView.etat.text= "Stat: Heavily Polluted"
                else -> itemView.etat.text= "Stat: Severely Polluted"
            }
            }
            GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(pay.api3[0].flag), itemView.flag)


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
