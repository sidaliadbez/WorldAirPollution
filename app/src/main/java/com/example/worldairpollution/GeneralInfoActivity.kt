package com.example.worldairpollution

import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_generalinformation.*
import kotlinx.android.synthetic.main.activity_main.*

class GeneralInfoActivity : AppCompatActivity() {
    val header: MutableList<String> = ArrayList()
    val body: MutableList<MutableList<String>> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generalinformation)

        retour.setOnClickListener {
            val intent= Intent(this,
                MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }

        val pollutiondef: MutableList<String> = ArrayList()
        pollutiondef.add("Kind af pollution")


        val mesurePollution: MutableList<String> = ArrayList()
        mesurePollution.add("with some unit")




        header.add("What Is Pollution ?")
        header.add("How Do We Mesure pollution    ")


        body.add(pollutiondef)
        body.add(mesurePollution)


        expandableListView.setAdapter(ExpandableListAdapter(this,expandableListView, header, body))

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
