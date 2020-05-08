package com.example.worldairpollution


import android.app.Activity
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_detail_country.*
import kotlinx.android.synthetic.main.card_list_contry.view.*


class DetailCountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_country)
      var  toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

val valeur = intent.getStringExtra("valeur")
val nom = intent.getStringExtra("dowla")
        GlideToVectorYou.justLoadImage(this, Uri.parse(intent.getStringExtra("la3lam")), flag)
        Grandevaleur.setText(valeur)
        Nompay.setText(nom)
        if (valeur=="-"){
            Grandevaleur.setTextSize(20.0F)
            Grandevaleur.setTextColor(Color.parseColor("#000000"))
            Grandevaleur.text="NO Data Availeble :("
        }else{


            when(valeur.toInt()){
                in 0..50 -> Grandevaleur.setTextColor(Color.parseColor("#FF3F8F42"))
                in  51..100-> Grandevaleur.setTextColor(Color.parseColor("#FFE3A918"))
                in  101..150-> Grandevaleur.setTextColor(Color.parseColor("#FFF88510"))
                in  151..200-> Grandevaleur.setTextColor(Color.parseColor("#FFE86262"))
                in  201..300-> Grandevaleur.setTextColor(Color.parseColor("#FF9A00DC"))
                else -> Grandevaleur.setTextColor(Color.parseColor("#FF681616"))
            }
        }
}
}