package com.artem.mitrofanov.middle.hotelcalifornia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.artem.mitrofanov.middle.hotelcalifornia.fragment.FragmentOne
import com.artem.mitrofanov.middle.hotelcalifornia.fragment.FragmentTwo

class TwoFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.two_frag)

        val share = applicationContext.getSharedPreferences("main", Context.MODE_PRIVATE)

        val myId = share.getString("id_cur", "")
         println(" my id == ${myId}")


        val butAboutTour = findViewById<Button>(R.id.first_frag1).setOnClickListener {
            supportFragmentManager.commit {
                replace<FragmentOne>(R.id.nav_host_fragment_activity_main)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }


        val butAboutHotel = findViewById<Button>(R.id.first_frag2).setOnClickListener {

             supportFragmentManager.commit {
            replace<FragmentTwo>(R.id.nav_host_fragment_activity_main )
                setReorderingAllowed(true)
            addToBackStack(null)
        }

        }




        val buyButton = findViewById<Button>(R.id.buy_id).setOnClickListener {


            val dqwke = Intent(this, ButTourFinal::class.java)
            startActivity(dqwke)

        }
    }


}