package com.artem.mitrofanov.middle.hotelcalifornia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artem.mitrofanov.middle.hotelcalifornia.databinding.FragmentOneBinding

class FragmentOne : Fragment() {


    private var _binding : FragmentOneBinding? = null
     private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentOneBinding.inflate(inflater, container, false)
        val root: View = binding.root


         return root
    }
}