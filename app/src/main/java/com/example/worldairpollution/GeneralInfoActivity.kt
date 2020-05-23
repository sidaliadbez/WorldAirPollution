package com.example.worldairpollution

import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_generalinformation.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class GeneralInfoActivity : AppCompatActivity() {
    val header: MutableList<String> = ArrayList()
    val body: MutableList<MutableList<String>> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generalinformation)
        var  toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        retour.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }

        val pollutiondef: MutableList<String> = ArrayList()
        pollutiondef.add("Air pollution is a type of environmental pollution that affects the air and is usually caused by smoke or other harmful gases, mainly oxides of carbon, sulphur and nitrogen. In other words, air pollution is the contamination of air due to the presence or introduction of a substance which has a poisonous effect.")


        val mesurePollution: MutableList<String> = ArrayList()
        mesurePollution.add("Air pollution is caused by solid and liquid particles and certain gases that are suspended in the air. These particles and gases can come from car and truck exhaust, factories, dust, pollen, mold spores, volcanoes and wildfires. The solid and liquid particles suspended in our air are called aerosols.")

        val preventPollution: MutableList<String> = ArrayList()
preventPollution.add("-Reduce the number of trips you take in your car.\n" +"\n"+
        "-Reduce or eliminate fireplace and wood stove use.\n" +"\n"+
        "-Avoid burning leaves, trash, and other materials.\n" +"\n"+
        "-Avoid using gas-powered lawn and garden equipment.")
        val pollutants: MutableList<String> = ArrayList()
        pollutants.add("The proposed AQI will consider five pollutants (PM10, PM2.5, NO2, SO2, CO) for which short-term (up to 24-hourly averaging period) National Ambient Air Quality Standards are prescribed. Based on the measured ambient concentrations, corresponding standards and likely health impact, a sub-index is calculated for each of these pollutants. ")
        val aqi: MutableList<String> = ArrayList()
        aqi.add("The numbers are the Air Quality Indexes, which is based on a scale from 0 (good) to 500 (bad).The colors correspond to the different health impact categories (Excellent, Good, Lightly Polluted,Moderately Polluted,Heavily Polluted,Severely Polluted)")
        val corona : MutableList<String> = ArrayList()
        corona.add("The coronavirus pandemic has lead to an increase in air quality all around the world. Lockdowns have resulted in factories and roads shutting, thus reducing emissions.\n\nReuters visualisations, based on data from NASA’s Global Modeling and Data Assimilation team, show how concentrations of some pollutants fell drastically after the lockdowns started.\n" +
                "\n" +
                "Satellite observations record information on aerosols in the atmosphere. NASA’s model is then able to provide estimates of the distribution of these pollutants close to the Earth’s surface.")
        val pollutedcountries : MutableList<String> = ArrayList()
        pollutedcountries.add("World's most polluted countries 2019 AVG (PM2.5) :\n" +
                "1- Bengladesh :                83.30 µg/m³\n" +
                "2- Pakistan :                      65.81 µg/m³\n" +
                "3- Mongolia :                     62.00 µg/m³\n" +
                "4- Afghanistan :                58.80 µg/m³\n" +
                "5- India :                             58.08 µg/m³")

        header.add("What Is Air Pollution?")
        header.add("What cause air pollution?  ")
        header.add("What are are the polluants?  ")
        header.add("AQI scale: what do colors and numbers mean?  ")
        header.add("What are the most polluted countries?")
        header.add("How do we prevent air pollution?  ")
        header.add("Coronavirus and air poluttion  ")


        body.add(pollutiondef)
        body.add(mesurePollution)
        body.add(pollutants)
        body.add(aqi)
        body.add(pollutedcountries)
        body.add(preventPollution)
        body.add(corona)


        expandableListView.setAdapter(ExpandableListAdapter(this,expandableListView, header, body))

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
