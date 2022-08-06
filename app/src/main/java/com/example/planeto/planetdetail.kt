package com.example.planeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_planetdetail.*

class planetdetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planetdetail)

        var obj : planetData
        var  planetimge : Int?

        obj = intent.getParcelableExtra("planet")!!
        planetimge = intent.getIntExtra("planteimg",-1)

        planet_img_info.setImageResource(planetimge)
        Tittle_info.text = obj.tittle
        galaxy_info.text = obj.galaxy
        distance_info.text = obj.distance+" m/km"
        gravity_info.text = obj.gravity+" m/ss"
        overview_info.text = obj.overview

        bookyourride.setOnClickListener{
            val intent = Intent(this,BookRide::class.java)
            startActivity(intent)
        }

    }
}