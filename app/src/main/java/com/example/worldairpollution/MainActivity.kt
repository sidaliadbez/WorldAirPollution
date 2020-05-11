package com.example.worldairpollution

import android.content.Intent
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

        fetchJson()
/*
        option= findViewById(R.id.spinner) as Spinner
        result =findViewById(R.id.choiceView) as TextView
        val options = arrayOf("Value","Name")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,options)
        /*
        option.onItemSelectedListener= object  : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
               result.text="Please Select an Option"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result.text=options.get(position)
            }
        }*/




        var pay1 = country("Algerie",20,"Bonne","07/5/99")
        var pay2= country("USA",20,"Bonne","07/5/99")
        var countries = arrayListOf<country>()
        countries.add(pay1)
        countries.add(pay2)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = ListContriesAdapter(
            this,
            countries
        )
        recyclerView.adapter = adapter*/
    }


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
        var status2 :Status?= null
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
                            println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+homeFeed.data[i].country)
                             api2 =    gson.fromJson(body, Api2::class.java)
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
                       // status2 =    gson.fromJson(body, Status::class.java)
                        if (status1?.status.equals("ok")){

                            val api3 =    gson.fromJson(body, Array<Api3>::class.java)
                            val blad= api2?.let { blad(homeFeed.data[i].country, it,api3) }
                            if (blad != null) {
                                blads.add(blad)
                            }
                             runOnUiThread {
                                 setupRecyclerView(blads)
                             }
                        }

                    }
                }

            })





    }


    }

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


class HomeFeed(val data : List<data>): Serializable
class data (val country :String): Serializable
class Status(val status:String ): Serializable
class Api3(val flag:String ): Serializable
class Api2(val data: data2 ): Serializable
class data2(val aqi: String,val iaqi: iaqi ): Serializable
class iaqi(val t:t, val p : p, var co : co? = null, var so2 : so2? = null , var no2 : no2? = null , var pm10 : pm10? = null , var pm25 : pm25? = null): Serializable
class t(val v :String): Serializable
class p (val v : String): Serializable
class co(var v: String ="-" ): Serializable
class so2(var v: String ="-"): Serializable
class no2(var v: String ="-" ): Serializable
class pm25(var v: String ="-" ): Serializable
class pm10(var v: String ="-" ): Serializable
class blad(var country: String, var homeFeed2: Api2,var api3: Array<Api3>) : Serializable