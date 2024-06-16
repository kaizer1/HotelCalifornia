package com.artem.mitrofanov.middle.hotelcalifornia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ButTourFinal : AppCompatActivity() {

        val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.buy_active)


          val editName = findViewById<EditText>(R.id.buy_a_name)
          val editSuName = findViewById<EditText>(R.id.buy_a_surname)
          val editPhone = findViewById<EditText>(R.id.buy_a_phone)
          val editDateBrds = findViewById<EditText>(R.id.buy_a_date)
          val editPassport = findViewById<EditText>(R.id.buy_a_passport)



        val buttonBuy = findViewById<Button>(R.id.buy_zayavka).setOnClickListener {


             val hotelA = hashMapOf(
                "Name"   to  editName.text.toString(),
                "Surname"  to  editSuName.text.toString(),
                "Phone" to editPhone.text.toString(),
                "BirdsDate" to editDateBrds.text.toString(),
                 "Passport" to editPassport.text.toString()

            )


            db.collection("Clients")
                .add(hotelA)
                .addOnSuccessListener {
                    Toast.makeText(this, " You zayvka succefull saved. Your email send mail", Toast.LENGTH_SHORT).show()


                    editName.text.clear()
                    editSuName.text.clear()
                    editPhone.text.clear()
                    editDateBrds.text.clear()
                    editPassport.text.clear()



                }
                .addOnFailureListener {
                                    Toast.makeText(this, " failure to save yout zayavka ! ", Toast.LENGTH_SHORT).show()
                }

        }



    }


}