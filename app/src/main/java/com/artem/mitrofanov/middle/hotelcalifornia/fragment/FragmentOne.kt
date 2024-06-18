package com.artem.mitrofanov.middle.hotelcalifornia.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.artem.mitrofanov.middle.hotelcalifornia.R
import com.artem.mitrofanov.middle.hotelcalifornia.databinding.FragmentOneBinding
import com.google.firebase.firestore.FirebaseFirestore

class FragmentOne : Fragment() {


    private var _binding : FragmentOneBinding? = null
     private val binding get() = _binding!!
        val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentOneBinding.inflate(inflater, container, false)
        val root: View = binding.root

                val share = requireContext().getSharedPreferences("main", Context.MODE_PRIVATE)

        val myId = share.getString("id_cur", "")
         println(" my id == ${myId}")

           val startDateTour = root.findViewById<TextView>(R.id.start_vip)
           val endTourDate = root.findViewById<TextView>(R.id.final_vip)
           val priceTour  = root.findViewById<TextView>(R.id.price_vip)


        db.collection("Tours").document(myId.toString())
            .get()
            .addOnSuccessListener {

                startDateTour.text = it.data!!["start"].toString()
                endTourDate.text = it.data!!["end"].toString()
                priceTour.text = it.data!!["roomPrice"].toString()

            }
         return root
    }
}