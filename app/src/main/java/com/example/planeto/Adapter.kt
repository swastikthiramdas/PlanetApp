package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet:List<planetData>):RecyclerView.Adapter<Adapter.viewholder>()  {

    class viewholder(itemview: View): RecyclerView.ViewHolder(itemview) {

        var tittle = itemview.Tittle
        var distance = itemview.distance
        var gravity = itemview.gravity
        var galaxy = itemview.galaxy
        var planetimg = itemview.planetimg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var planetimg1 : Int? = null

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,planetdetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planteimg",planetimg1)
            holder.itemView.context.startActivity(intent)
        }

        holder.tittle.text = planet[position].tittle
        holder.gravity.text = planet[position].gravity+" m/ss"
        holder.distance.text = planet[position].distance+" m/km"
        holder.galaxy.text = planet[position].galaxy

        when(planet[position].tittle?.toLowerCase()){

            "mars"->{
                planetimg1 = R.drawable.ic_mars
            }
            "earth"->{
                planetimg1 = R.drawable.ic_earth
            }
            "jupiter"->{
                planetimg1 = R.drawable.ic_jupiter
            }
            "mercury"->{
                planetimg1 = R.drawable.ic_mercury
            }
            "uranus"->{
                planetimg1 = R.drawable.ic_uranus
            }
            "sun"->{
                planetimg1 = R.drawable.ic_sun
            }
            "saturn"->{
                planetimg1 = R.drawable.ic_saturn
            }
            "venus"->{
                planetimg1 = R.drawable.ic_venus
            }
            "neptune"->{
                planetimg1 = R.drawable.ic_neptune
            }
            "moon"->{
                planetimg1 = R.drawable.ic_moon
            }
        }
        holder.planetimg.setImageResource(planetimg1!!)


    }

    override fun getItemCount(): Int {
       return planet.size
    }
}