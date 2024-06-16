package com.artem.mitrofanov.middle.hotelcalifornia

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListAdapterIS(private val context: Activity, private val name: Array<String?>, private val city: Array<String?>, private val pgnNE: Array<String?>, private val imgid: Array<String?>)
    : ArrayAdapter<String>(context, R.layout.main_list_elements, name) {


     private fun convertToImage(naText : String ) : Bitmap {

         val bytes= Base64.decode(naText, Base64.DEFAULT)
         val bitmap= BitmapFactory.decodeByteArray(bytes,0, bytes.size)

         return bitmap
     }


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.main_list_elements, null, true)

        val namesTour = rowView.findViewById(R.id.namesdfv) as TextView
        val imageView = rowView.findViewById(R.id.imageiid) as ImageView
        val CityTour = rowView.findViewById(R.id.namescijdd) as TextView
        val PhoneTour = rowView.findViewById(R.id.namesdpgonee) as TextView

        namesTour.text = name[position]
        CityTour.text =  city[position]
        PhoneTour.text = pgnNE[position]
        imageView.setImageBitmap( convertToImage(imgid[position]!!))

        return rowView
    }
}