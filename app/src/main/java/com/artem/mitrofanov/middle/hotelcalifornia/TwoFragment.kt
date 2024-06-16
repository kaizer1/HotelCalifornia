package com.artem.mitrofanov.middle.hotelcalifornia

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.artem.mitrofanov.middle.hotelcalifornia.fragment.FragmentTwo

class TwoFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.two_frag)

        val share = applicationContext.getSharedPreferences("main", Context.MODE_PRIVATE)

        val myId = share.getString("id_cur", "")
         println(" my id == ${myId}")



        //     FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        val fTransaction = supportFragmentManager.beginTransaction()
            //fTransaction.add(FragmentTwo::class.java, "a")






    }

}