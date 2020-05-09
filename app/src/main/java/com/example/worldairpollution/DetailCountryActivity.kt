package com.example.worldairpollution


import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.activity_detail_country.*


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
            Grandevaleur.text="NO Data Available :("
        }else{

                textquality.text="Quality of the air : "
            when(valeur.toInt()){
                in 0..50 ->{
                    Grandevaleur.setTextColor(Color.parseColor("#FF3F8F42"))
                    qualite.text="Excellent"
                    qualite.setTextColor(Color.parseColor("#FF3F8F42"))
                }
                in  51..100-> {
                    Grandevaleur.setTextColor(Color.parseColor("#FFFFC125"))
                    qualite.text="Good"
                    qualite.setTextColor(Color.parseColor("#FFFFC125"))
                }
                in  101..150-> {
                    Grandevaleur.setTextColor(Color.parseColor("#FFF88510"))
                    qualite.text="Lightly Polluted"
                    qualite.setTextColor(Color.parseColor("#FFF88510"))
                }
                in  151..200-> {
                    Grandevaleur.setTextColor(Color.parseColor("#FFE86262"))
                    qualite.text="Moderately Polluted"
                    qualite.setTextColor(Color.parseColor("#FFE86262"))
                }
                in  201..300-> {
                    Grandevaleur.setTextColor(Color.parseColor("#FF9A00DC"))
                    qualite.text="Heavily Polluted"
                    qualite.setTextColor(Color.parseColor("#FF9A00DC"))
                }
                else -> {
                    Grandevaleur.setTextColor(Color.parseColor("#FF681616"))
                    qualite.text="Severely Polluted"
                    qualite.setTextColor(Color.parseColor("#FF681616"))
                }
            }
        }


/*
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5.0F,10.0F,5.0F,5.0F)
        pieChart.dragDecelerationFrictionCoef= 0.96f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.transparentCircleRadius=61f

        val listPie = ArrayList<PieEntry>()
        listPie.add(PieEntry(37F, "Algeria"))
        listPie.add(PieEntry(23F, "UK"))
        listPie.add(PieEntry(14F, "USA"))
        listPie.add(PieEntry(35F, "Dubai"))
        listPie.add(PieEntry(40F, "Marocco"))
        listPie.add(PieEntry(23F, "Russia"))
        val pieDataSet = PieDataSet(listPie, "Countries")
        pieDataSet.sliceSpace=3f
        pieDataSet.selectionShift=5f
        pieDataSet.setColors(255)

        val data= PieData(pieDataSet)
        data.setValueTextSize(10f)
        data.setValueTextColor(Color.YELLOW)
        pieChart.data= data*/
        var pieChart : PieChart = findViewById(R.id.piechartco)
        val listPie = ArrayList<PieEntry>()
        val listColors = ArrayList<Int>()

        listPie.add(PieEntry(30F, ""))
        listColors.add(Color.GREEN)
        listPie.add(PieEntry(70F, ""))
        listColors.add((-0xE27E7E7E).toInt())

        var pieDataSet = PieDataSet(listPie, "")
        pieDataSet.colors = listColors

        var pieData = PieData(pieDataSet)
        pieData.setValueTextSize(0f)
        pieChart.data = pieData
        pieChart.legend.isEnabled= false
        pieChart.setUsePercentValues(false)
        pieChart.isDrawHoleEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setHoleColor((-0xFFF9F9F9).toInt())

       //pieChart.animateY(1000, Easing.EaseInOutBack)


                    ///PieChart 2///
        pieChart  = findViewById(R.id.piechartso)
        val listPie2 = ArrayList<PieEntry>()
        val listColors2 = ArrayList<Int>()

        listPie2.add(PieEntry(30F, ""))
        listColors2.add(Color.GREEN)
        listPie2.add(PieEntry(70F, ""))
        listColors2.add((-0xE27E7E7E).toInt())

         pieDataSet = PieDataSet(listPie2, "")
        pieDataSet.colors = listColors2

         pieData = PieData(pieDataSet)
        pieData.setValueTextSize(0f)
        pieChart.data = pieData
        pieChart.legend.isEnabled= false
        pieChart.setUsePercentValues(false)
        pieChart.isDrawHoleEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setHoleColor((-0xFFF9F9F9).toInt())


                         ///PieChart 3///
        pieChart  = findViewById(R.id.piechartno)
        val listPie3= ArrayList<PieEntry>()
        val listColors3 = ArrayList<Int>()

        listPie3.add(PieEntry(30F, ""))
        listColors3.add(Color.GREEN)
        listPie3.add(PieEntry(70F, ""))
        listColors3.add((-0xE27E7E7E).toInt())

        pieDataSet = PieDataSet(listPie3, "")
        pieDataSet.colors = listColors3

        pieData = PieData(pieDataSet)
        pieData.setValueTextSize(0f)
        pieChart.data = pieData
        pieChart.legend.isEnabled= false
        pieChart.setUsePercentValues(false)
        pieChart.isDrawHoleEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setHoleColor((-0xFFF9F9F9).toInt())




                ///PieChart 4///
        pieChart  = findViewById(R.id.piechartpm25)
        val listPie5 = ArrayList<PieEntry>()
        val listColors5 = ArrayList<Int>()

        listPie5.add(PieEntry(30F, ""))
        listColors5.add(Color.GREEN)
        listPie5.add(PieEntry(70F, ""))
        listColors5.add((-0xE27E7E7E).toInt())

        pieDataSet = PieDataSet(listPie5, "")
        pieDataSet.colors = listColors5

        pieData = PieData(pieDataSet)
        pieData.setValueTextSize(0f)
        pieChart.data = pieData
        pieChart.legend.isEnabled= false
        pieChart.setUsePercentValues(false)
        pieChart.isDrawHoleEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setHoleColor((-0xFFF9F9F9).toInt())

        ///PieChart 3///
        pieChart  = findViewById(R.id.piechartpm10)
        val listPie4 = ArrayList<PieEntry>()
        val listColors4 = ArrayList<Int>()

        listPie4.add(PieEntry(30F, ""))
        listColors4.add(Color.GREEN)
        listPie4.add(PieEntry(70F, ""))
        listColors4.add((-0xE27E7E7E).toInt())

        pieDataSet = PieDataSet(listPie4, "")
        pieDataSet.colors = listColors4

        pieData = PieData(pieDataSet)
        pieData.setValueTextSize(0f)
        pieChart.data = pieData
        pieChart.legend.isEnabled= false
        pieChart.setUsePercentValues(false)
        pieChart.isDrawHoleEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setHoleColor((-0xFFF9F9F9).toInt())

}

    override fun onBackPressed() {
        piechartco.postDelayed(Runnable { piechartco.setVisibility(View.GONE) }, 200)
        piechartno.postDelayed(Runnable { piechartno.setVisibility(View.GONE) }, 200)
        piechartso.postDelayed(Runnable { piechartso.setVisibility(View.GONE) }, 200)
        piechartpm25.postDelayed(Runnable { piechartpm25.setVisibility(View.GONE) }, 200)
        piechartpm10.postDelayed(Runnable { piechartpm10.setVisibility(View.GONE) }, 200)
            /*piechartco.setVisibility(View.GONE)
            piechartno.setVisibility(View.GONE)
            piechartso.setVisibility(View.GONE)
            piechartpm10.setVisibility(View.GONE)
            piechartpm25.setVisibility(View.GONE)*/



        super.onBackPressed()
    }
}
