package com.example.worldairpollution

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.worldairpollution.R.layout.activity_generalinformation
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ColorTemplate.*
import com.google.gson.GsonBuilder
import com.r0adkll.slidr.Slidr
import okhttp3.*
import java.io.IOException
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
lateinit var option : Spinner
    lateinit var  result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageButton.setOnClickListener {
            val intent= Intent(this,
                GeneralInfoActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
val homeFeed = fetchJson1()
        print("hehe")
        var blads = arrayListOf<blad>()
        if ( homeFeed !=null){

        for ( i in 0 until homeFeed?.data?.size!!){

           val api2 =  fetchJson3(homeFeed.data[i].country)
            val  api3= fetchJson4(api2,homeFeed.data[i].country)
            if (api2 != null && api3 != null){
                val blad = blad(homeFeed.data[i].country,api2,api3)
                if (blad != null){
                    blads.add(blad)
                }

            }

        }
        setupRecyclerView(blads)
        }
        print(homeFeed!!.data[0].country)
        var barChart :BarChart = findViewById(R.id.barchart)
        barchart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)
        barChart.setMaxVisibleValueCount(300)
        barChart.setPinchZoom(false)
        barChart.setDrawGridBackground(false)
        var barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f,40f))
        barEntries.add(BarEntry(2f,44f))
        barEntries.add(BarEntry(3f,30f))
        barEntries.add(BarEntry(4f,36f))
        barEntries.add(BarEntry(5f,40f))
        barEntries.add(BarEntry(6f,44f))
        barEntries.add(BarEntry(7f,30f))
        barEntries.add(BarEntry(8f,36f))
        barEntries.add(BarEntry(9f,30f))
        barEntries.add(BarEntry(10f,200f))

            val  leftAxis : YAxis= barChart.getAxisLeft();
        leftAxis.textColor=Color.WHITE
        leftAxis.axisLineColor=Color.WHITE
      val rightAxis :YAxis = barChart.getAxisRight();
    rightAxis.setEnabled(false);
var contry = ArrayList<String>()
        contry.add("algeria")
        contry.add("algeria")
        contry.add("algeria")
        contry.add("algeria")
        contry.add("algeria")
    val xAxis:XAxis = barChart.getXAxis();

    xAxis.setEnabled(false);
        var barDataSet = BarDataSet(barEntries,"Data Set1")

        barDataSet.color=  Color.parseColor("#FFE434")

        var data = BarData(barDataSet)
        data.barWidth=0.5f
        data.setValueTextColor(Color.WHITE)
        data.setValueTextSize(10f)
        barChart.animateY(3000, Easing.EaseInOutBack)
        barchart.description.isEnabled = false
        barChart.legend.isEnabled= false
        barChart.data= data
    }




/*
    fun fetchJson()  {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.airvisual.com/v2/countries?key=7be3b8fb-772d-4a92-ab9b-01690c31aff6")
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print("sooooooooooooooooorry")
            }

            override fun onResponse(call: Call, response: Response) {
                var cool = response.body()?.string()
                print(cool )
                val gson = GsonBuilder().create()
                val homeFeed= gson.fromJson(cool,HomeFeed::class.java)
                    fetchJson2(homeFeed)
            }

        })

    }

    fun fetchJson2(homeFeed: HomeFeed) {
        var blads = arrayListOf<blad>()
        var api2: Api2? = null
        var status1 :Status?= null
        for (i in 0..homeFeed.data.size - 1){

        val client = OkHttpClient()
        val request = Request.Builder()

            .url("https://api.waqi.info/feed/"+homeFeed.data[i].country+"/?token=43e2d6a3b897ab60ac376128719ee9cce0f790bb")
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print("sooooooooooooooooorry")
            }

            override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful){

                        var body = response.body()?.string()
                        val gson = GsonBuilder().create()
                        status1 =    gson.fromJson(body, Status::class.java)
                        if (status1?.status.equals("ok")){
                             api2 =    gson.fromJson(body, Api2::class.java)
                            println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+homeFeed.data[i].country + api2?.data?.aqi + api2?.data?.time?.s)
                        }

}
            }

        })





            val client2 = OkHttpClient()
            val request2 = Request.Builder()

                .url("https://restcountries.eu/rest/v2/name/"+homeFeed.data[i].country)
                .build()


            client2.newCall(request2).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    print("sooooooooooooooooorry")
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful){


                        var body = response.body()?.string()
                        val gson = GsonBuilder().create()
                        if (status1?.status.equals("ok")){

                            val api3 =    gson.fromJson(body, Array<Api3>::class.java)
                            val blad = blad(homeFeed.data[i].country,api2!!,api3)
                            if (homeFeed.data[i].country=="Algeria"){
                                print("hello")
                            }
                            val coco= api2?.let { blad(homeFeed.data[i].country, it,api3) }
                            if (blad != null) {
                                blads.add(blad)
                            }

                        }
                    }

                }

            })





    }
        runOnUiThread {
            println("taille:  "+blads.size)
            for (blad in blads){
                println("Le pay: "+blad.country )
            }
            blads.sortedBy { it.country }
            setupRecyclerView(blads)
        }

    }
*/
    private fun setupRecyclerView(blads: ArrayList<blad>) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = ApiAdapter(
            this, blads
        )
        recyclerView.adapter = adapter
    }



}


fun fetchJson1()  : HomeFeed? {
    val client = OkHttpClient()
    var homeFeed :HomeFeed? = null
    val request = Request.Builder()
        .url("https://api.airvisual.com/v2/countries?key=7be3b8fb-772d-4a92-ab9b-01690c31aff6")
        .build()


    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            print("sooooooooooooooooorry")
        }

        override fun onResponse(call: Call, response: Response) {
            var cool = response.body()?.string()
            print(cool )
            val gson = GsonBuilder().create()
             val homefeed= gson.fromJson(cool,HomeFeed::class.java)
         //   homeFeed!!.data?= homefeed!!.data?
                println("hehe")

        }

    })
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+homeFeed!!.data[0]?.country)
    return homeFeed
}

fun fetchJson3(name:String): Api2?{
    var blads = arrayListOf<blad>()
    var api2: Api2? = null
    var status1 :Status?= null
        val client = OkHttpClient()
        val request = Request.Builder()

            .url("https://api.waqi.info/feed/"+name+"/?token=43e2d6a3b897ab60ac376128719ee9cce0f790bb")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print("sooooooooooooooooorry")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){

                    var body = response.body()?.string()
                    val gson = GsonBuilder().create()
                    status1 =    gson.fromJson(body, Status::class.java)
                    if (status1?.status.equals("ok")){
                        api2 =    gson.fromJson(body, Api2::class.java)
                        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+name + api2?.data?.aqi + api2?.data?.time?.s)
                    }

                }
            }

        })

return api2
}




fun fetchJson4(api2: Api2?, name :String) : Array<Api3>? {
    var api3 : Array<Api3>? =null
    val client2 = OkHttpClient()
    val request2 = Request.Builder()

        .url("https://restcountries.eu/rest/v2/name/"+name)
        .build()


    client2.newCall(request2).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            print("sooooooooooooooooorry")
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful){
                if (api2 != null){



                var body = response.body()?.string()
                val gson = GsonBuilder().create()
                    api3 =    gson.fromJson(body, Array<Api3>::class.java)
                }
            }

        }

    })
return  api3
}
class HomeFeed(val data : List<data>): Serializable
class data (val country :String): Serializable
class Status(val status:String ): Serializable
class Api3(val flag:String ): Serializable
class Api2(val data: data2 ): Serializable
class data2(val aqi: String,val iaqi: iaqi , val time : time): Serializable
class iaqi(val t:t, val p : p, var co : co? = null, var so2 : so2? = null , var no2 : no2? = null , var pm10 : pm10? = null , var pm25 : pm25? = null): Serializable
class t(val v :String): Serializable
class time(val s :String): Serializable
class p (val v : String): Serializable
class co(var v: String ="-" ): Serializable
class so2(var v: String ="-"): Serializable
class no2(var v: String ="-" ): Serializable
class pm25(var v: String ="-" ): Serializable
class pm10(var v: String ="-" ): Serializable
class blad(var country: String, var homeFeed2: Api2,var api3: Array<Api3>) : Serializable