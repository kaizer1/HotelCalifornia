package com.artem.mitrofanov.middle.hotelcalifornia

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.io.ByteArrayOutputStream

class addhotels : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



         // toomType


        setContentView(R.layout.add_hotelsa)

        val dfa = findViewById<Button>(R.id.add_hit).setOnClickListener {





            // tour
            // roomType
            // hotel {}
            //


            val bitmap = BitmapFactory.decodeResource(resources,
                                           R.drawable.ok_three)
            //   val bitmap = MediaStore.Images.Media.getBitmap(R.drawable.hotel223)
              val bitmapResize = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * 0.5).toInt(), (bitmap.getHeight() * 0.5).toInt(), true)
              val stream= ByteArrayOutputStream()
                bitmapResize.compress(Bitmap.CompressFormat.JPEG,70,stream)
                val bytes=stream.toByteArray();
                val ToSendmainSelected= Base64.encodeToString(bytes,Base64.DEFAULT)


            val hotelA = hashMapOf(
                "name"   to  "Президент Отель",
                "city"  to  "Санкт-Петербург",
                "address" to "Приморское ш. 572",
                "phone" to "79219570092"
            )

            val tourVariant = hashMapOf(
                "tourType" to "VIP", // Standart
                "start" to "21.7.2024",
                "end" to "28.7.2024",
                "roomPrice" to "20000",
                "hotelPrice" to "17000",
                "hotel" to hotelA,
                "image_tour" to ToSendmainSelected

            )


            db.collection("Tours").add(tourVariant)
                .addOnSuccessListener {
                    toastLos("Success save all my data")
                    //dialog.dismiss()

                }
                .addOnFailureListener {
                    toastLos(" no save data  ")
                }


        }


    }


    private fun  toastLos(text : String )
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

    }

}