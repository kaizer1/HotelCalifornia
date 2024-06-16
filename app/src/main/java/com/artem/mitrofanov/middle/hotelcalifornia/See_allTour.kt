package com.artem.mitrofanov.middle.hotelcalifornia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.firestore.FirebaseFirestore

class See_allTour : AppCompatActivity() {


     val arrayList = ArrayList<HashMap<String, String>>()
     val db = FirebaseFirestore.getInstance()
      val nameArra = ArrayList<String>()
      val cityArra = ArrayList<String>()
      val phoneArra = ArrayList<String>()
      val imageArra = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         setContentView(R.layout.all_viewlist)

     val listView = findViewById<ListView>(R.id.list_idl)

         val share = applicationContext.getSharedPreferences("main", Context.MODE_PRIVATE)


        db.collection("Tours").get()
            .addOnSuccessListener { it ->

               // val df = it.documents
               // println(" my size = ${df.size}")

                 for (docus in it){

                      val map: HashMap<String, String> = HashMap()


                   // println( " my id == ${docus.id} " )


                     map["ID"] = docus.id



                     imageArra.add(docus.data["image_tour"].toString())

                     val kdfj = docus.data["hotel"] as HashMap<*, *>

                     for(docus2 in kdfj){

                         //docus2.key == "name"
                         if(docus2.key == "name"){
                             nameArra.add(docus2.value.toString())
                         }


                         if(docus2.key == "city"){
                             cityArra.add(docus2.value.toString())
                         }


                         if(docus2.key == "phone"){
                             phoneArra.add(docus2.value.toString())
                         }
                     }

                  arrayList.add(map)
                 }


                   val arrayImage = arrayOfNulls<String>(imageArra.size)
                    imageArra.toArray(arrayImage)



                 val nameImage = arrayOfNulls<String>(nameArra.size)
                    nameArra.toArray(nameImage)

                 val cityImage = arrayOfNulls<String>(cityArra.size)
                    cityArra.toArray(cityImage)


                 val phoneImage = arrayOfNulls<String>(phoneArra.size)
                    phoneArra.toArray(phoneImage)


                val adap = CustomListAdapterIS(this, nameImage, cityImage, phoneImage, arrayImage!!)
                     listView.adapter = adap
                     listView.divider = null

            }


                  listView.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->

                      println("my variant press = ${position} and name lV = ${arrayList[position]["ID"]}")

                     val dfd = share.edit()
                      dfd.putString("id_cur", arrayList[position]["ID"])
                      dfd.apply()

                      val dfaIntet = Intent(this, TwoFragment::class.java)
                      startActivity(dfaIntet)
                  }



    }
}