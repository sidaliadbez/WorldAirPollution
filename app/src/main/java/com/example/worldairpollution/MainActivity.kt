package com.example.worldairpollution

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

class MainActivity : AppCompatActivity() {
lateinit var option : Spinner
    lateinit var  result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        */



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
        recyclerView.adapter = adapter
    }

}
