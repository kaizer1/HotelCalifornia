package com.artem.mitrofanov.middle.hotelcalifornia.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.artem.mitrofanov.middle.hotelcalifornia.R
import com.artem.mitrofanov.middle.hotelcalifornia.databinding.FragmentTwoBinding
import com.google.firebase.firestore.FirebaseFirestore

class FragmentTwo : Fragment() {


     private var _binding : FragmentTwoBinding? = null
     private val binding get() = _binding!!
      val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         super.onCreateView(inflater, container, savedInstanceState)


        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        val root: View = binding.root


                val share = requireContext().getSharedPreferences("main", Context.MODE_PRIVATE)

        val myId = share.getString("id_cur", "")
        // println(" my id == ${myId}")


           val nameHotels = root.findViewById<TextView>(R.id.name_asdjot)
           val cityHitel = root.findViewById<TextView>(R.id.city_djsfdf)
           val addresJotl = root.findViewById<TextView>(R.id.addresskdf)
           val phonesdfskdl  = root.findViewById<TextView>(R.id.phoetiddd)


        db.collection("Tours").document(myId.toString())
            .get()
            .addOnSuccessListener {it ->

             // imageArra.add(docus.data["image_tour"].toString())

                     val kdfj = it.data?.get("hotel") as HashMap<*, *>

                     for(docus2 in kdfj){

                         if(docus2.key == "name"){
                             nameHotels.text = docus2.value.toString()
                         }

                         if(docus2.key == "city"){
                             cityHitel.text = docus2.value.toString()
                         }


                           if(docus2.key == "address"){
                             addresJotl.text = docus2.value.toString()
                         }

                         if(docus2.key == "phone"){
                             phonesdfskdl.text = docus2.value.toString()
                         }
                     }
            }

        return root
    }
}