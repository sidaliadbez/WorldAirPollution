package com.example.worldairpollution


import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.mikephil.charting.animation.Easing
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

        var blad: blad?=null
        val bundel: Bundle?= intent.extras
        blad= bundel?.getSerializable("blad") as? blad


        GlideToVectorYou.justLoadImage(this, Uri.parse(blad?.api3?.get(0)?.flag), flag)
        Grandevaleur.setText(blad?.homeFeed2?.data?.aqi)
        Nompay.setText(blad?.country)



        if (blad?.homeFeed2?.data?.aqi=="-"){
            Grandevaleur.setTextSize(20.0F)
            Grandevaleur.setTextColor(Color.parseColor("#000000"))
            Grandevaleur.text="NO Data Available :("
        }else{

                textquality.text="Quality of the air : "
            when(blad?.homeFeed2?.data?.aqi?.toInt()){
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







        var couleurco = -0x000000
        var coval = 0F
        if (blad?.homeFeed2?.data?.iaqi?.co==null){
            val text = textco.text.toString()
            textco.text= text+ " :   /"
        }else{
            val text = textco.text.toString()
            textco.text= text+ " :   "+ blad?.homeFeed2?.data?.iaqi?.co!!.v
            when(blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()){
                in 0F .. 1.0F-> {
                    couleurco = Color.parseColor("#ff3f8f42")
                    coval= ((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat())*100/ 1F)*0.2F

                }
                in 1.1F..2F ->{
                    couleurco = Color.parseColor("#FF97DC5B")
                    coval= (((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()-1.1F)*100/ (2F-1.1F))*0.2F)+ 20F

                }
                in 2.1F .. 10F-> {
                    couleurco = Color.parseColor("#FFE434")
                    coval= (((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()-2.1F)*100/ (10F-2.1F))*0.26F)+40
                }
                in 10.1F .. 17F-> {
                    couleurco = Color.parseColor("#FFF88510")
                    coval= (((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()-10.1F)*100/ (17F-10.1F))*0.17F) + 66F

                }
                in 17.1F .. 34F-> {
                    couleurco = Color.parseColor("#FFE86262")
                    coval= (((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()-17.1F)*100/ (13F-17.1F))*0.13F) + 83F

                }
                else-> {
                    couleurco = Color.parseColor("#FF681616")
                    coval= (((blad?.homeFeed2?.data?.iaqi?.co!!.v.toFloat()-34.1F)*100/ (60F-34.1F))*0.04F) + 96F


                }
            }
        }














        var couleurso2 = -0x000000
        var so2val = 0F
        if (blad?.homeFeed2?.data?.iaqi?.so2==null){
            val text = textso2.text.toString()
            textso2.text= text+ " :   /"
        }else{
            val text = textso2.text.toString()
            textso2.text= text+ " :   "+ blad?.homeFeed2?.data?.iaqi?.so2!!.v
            when(blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()){
                in 0F .. 40F-> {
                    couleurso2 = Color.parseColor("#ff3f8f42")
                    so2val= ((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat())*100/ 40F)*0.5F

                }
                in 40.01F..80F ->{
                    couleurso2 = Color.parseColor("#FF97DC5B")
                    so2val= (((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()-40.01F)*100/ (80F-40.01F))*0.2F)+ 50F

                }
                in 80.01F .. 380F-> {
                    couleurso2 = Color.parseColor("#FFE434")
                    so2val= (((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()-80.01F)*100/ (380F-80.01F))*0.1F)+70F
                }
                in 380.01F .. 800F-> {
                    couleurso2 = Color.parseColor("#FFF88510")
                    so2val= (((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()-380.01F)*100/ (800F-380.01F))*0.1F) + 80F

                }
                in 800.01F .. 1600F-> {
                    couleurso2 = Color.parseColor("#FFE86262")
                    so2val= (((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()-800.01F)*100/ (1600F-800.01F))*0.05F) + 90F

                }
                else-> {
                    couleurso2 = Color.parseColor("#FF681616")
                    so2val= (((blad?.homeFeed2?.data?.iaqi?.so2!!.v.toFloat()-1600.01F)*100/ (3200F-1600.01F))*0.05F) + 95F


                }
            }
        }

        var couleurno2 = -0x000000
        var no2val = 0F
        if (blad?.homeFeed2?.data?.iaqi?.no2==null){
            val text = textno2.text.toString()
            textno2.text= text+ " :   /"
        }else{
            val text = textno2.text.toString()
            textno2.text= text+ " :   "+ blad?.homeFeed2?.data?.iaqi?.no2!!.v
            when(blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()){
                in 0F .. 40F-> {
                    couleurno2 = Color.parseColor("#ff3f8f42")
                    no2val= ((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat())*100/ 40F)*0.5F

                }
                in 40.01F..80F ->{
                    couleurno2 = Color.parseColor("#FF97DC5B")
                    no2val= (((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()-40.01F)*100/ (80F-40.01F))*0.2F)+ 50F

                }
                in 80.01F .. 180F-> {
                    couleurno2 = Color.parseColor("#FFE434")
                    no2val= (((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()-80.01F)*100/ (180F-80.01F))*0.1F)+70F
                }
                in 180.01F .. 280F-> {
                    couleurno2 = Color.parseColor("#FFF88510")
                    no2val= (((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()-180.01F)*100/ (280F-180.01F))*0.1F) + 80F

                }
                in 280.01F .. 400F-> {
                    couleurno2 = Color.parseColor("#FFE86262")
                    no2val= (((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()-280.01F)*100/ (400F-280.01F))*0.05F) + 90F

                }
                else-> {
                    couleurno2 = Color.parseColor("#FF681616")
                    no2val= (((blad?.homeFeed2?.data?.iaqi?.no2!!.v.toFloat()-400.01F)*100/ (800F-400.01F))*0.05F) + 95F


                }
            }
        }

        var couleurpm10 = -0x000000
        var pm10val = 0F
        if (blad?.homeFeed2?.data?.iaqi?.pm10==null){
            val text = textpm10.text.toString()
            textpm10.text= text+ " :   /"
        }else{
            val text = textpm10.text.toString()
            textpm10.text= text+ " :   "+ blad?.homeFeed2?.data?.iaqi?.pm10!!.v
            when(blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()){
                in 0F .. 50F-> {
                    couleurpm10 = Color.parseColor("#ff3f8f42")
                    pm10val= ((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat())*100/ 50F)*0.5F

                }
                in 50.01F..100F ->{
                    couleurpm10 = Color.parseColor("#FF97DC5B")
                    pm10val= (((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()-50.01F)*100/ (100F-50.01F))*0.2F)+ 50F

                }
                in 100.01F .. 250F-> {
                    couleurpm10 = Color.parseColor("#FFE434")
                    pm10val= (((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()-100.01F)*100/ (250F-100.01F))*0.1F)+70
                }
                in 250.01F .. 350F-> {
                    couleurpm10 = Color.parseColor("#FFF88510")
                    pm10val= (((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()-250.01F)*100/ (350F-250.01F))*0.1F) + 80F

                }
                in 350.01F .. 430F-> {
                    couleurpm10 = Color.parseColor("#FFE86262")
                    pm10val= (((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()-350.01F)*100/ (430F-350.01F))*0.05F) + 90F

                }
                else-> {
                    couleurpm10 = Color.parseColor("#FF681616")
                    pm10val= (((blad?.homeFeed2?.data?.iaqi?.pm10!!.v.toFloat()-430.01F)*100/ (860F-430.01F))*0.05F) + 95F


                }
            }
        }



        var couleurpm25 = -0x000000
        var pm25val = 0F
        if (blad?.homeFeed2?.data?.iaqi?.pm25==null){
            val text = textpm25.text.toString()
            textpm25.text= text+ " :   /"
        }else{
            val text = textpm25.text.toString()
            textpm25.text= text+ " :   "+ blad?.homeFeed2?.data?.iaqi?.pm25!!.v
            when(blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()){
                in 0F .. 30F-> {
                    couleurpm25 = Color.parseColor("#ff3f8f42")
                    pm25val= ((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat())*100/ 30F)*0.2F

                }
                in 30.01F..60F ->{
                    couleurpm25 = Color.parseColor("#FF97DC5B")
                    pm25val= (((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()-30.01F)*100/ (60F-30.01F))*0.2F)+ 20F

                }
                in 60.01F .. 90F-> {
                    couleurpm25 = Color.parseColor("#FFE434")
                    pm25val= (((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()-60.01F)*100/ (90F-60.01F))*0.26F)+40F
                }
                in 90.01F .. 120F-> {
                    couleurpm25 = Color.parseColor("#FFF88510")
                    pm25val= (((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()-90.01F)*100/ (120F-90.01F))*0.17F) + 66F

                }
                in 120.01F .. 250F-> {
                    couleurpm25 = Color.parseColor("#FFE86262")
                    pm25val= (((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()-120.01F)*100/ (250F-120.01F))*0.13F) + 83F

                }
                else-> {
                    couleurpm25 = Color.parseColor("#FF681616")
                    pm25val= (((blad?.homeFeed2?.data?.iaqi?.pm25!!.v.toFloat()-250.01F)*100/ (500F-430.01F))*0.4F) + 96F


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

        listPie.add(PieEntry(coval, ""))
        listColors.add(couleurco)
        listPie.add(PieEntry(100F-coval, ""))
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
        pieChart.animateY(2000, Easing.EaseInOutBack)


                    ///PieChart 2///
        pieChart  = findViewById(R.id.piechartso)
        val listPie2 = ArrayList<PieEntry>()
        val listColors2 = ArrayList<Int>()

        listPie2.add(PieEntry(so2val, ""))
        listColors2.add(couleurso2)
        listPie2.add(PieEntry(100F - so2val, ""))
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
        pieChart.animateY(2000, Easing.EaseInOutBack)


                         ///PieChart 3///
        pieChart  = findViewById(R.id.piechartno)
        val listPie3= ArrayList<PieEntry>()
        val listColors3 = ArrayList<Int>()

        listPie3.add(PieEntry(no2val, ""))
        listColors3.add(couleurno2)
        listPie3.add(PieEntry(100F-no2val, ""))
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
        pieChart.animateY(2000, Easing.EaseInOutBack)



                ///PieChart 4///
        pieChart  = findViewById(R.id.piechartpm25)
        val listPie5 = ArrayList<PieEntry>()
        val listColors5 = ArrayList<Int>()

        listPie5.add(PieEntry(pm25val, ""))
        listColors5.add(couleurpm25)
        listPie5.add(PieEntry(100F-pm25val, ""))
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
        pieChart.animateY(2000, Easing.EaseInOutBack)



        ///PieChart 5///
        pieChart  = findViewById(R.id.piechartpm10)
        val listPie4 = ArrayList<PieEntry>()
        val listColors4 = ArrayList<Int>()

        listPie4.add(PieEntry(pm10val, ""))
        listColors4.add(couleurpm10)
        listPie4.add(PieEntry(100F-pm10val, ""))
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
        pieChart.animateY(2000, Easing.EaseInOutBack)

}

    override fun onBackPressed() {
        piechartco.postDelayed(Runnable { piechartco.setVisibility(View.GONE) }, 200)
        piechartno.postDelayed(Runnable { piechartno.setVisibility(View.GONE) }, 200)
        piechartso.postDelayed(Runnable { piechartso.setVisibility(View.GONE) }, 200)
        piechartpm25.postDelayed(Runnable { piechartpm25.setVisibility(View.GONE) }, 200)
        piechartpm10.postDelayed(Runnable { piechartpm10.setVisibility(View.GONE) }, 200)

        super.onBackPressed()
    }
}
