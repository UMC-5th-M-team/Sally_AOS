package com.umc.sally

import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umc.sally.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // ViewBinding Setting
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)


        val intent = Intent(requireContext(), SearchActivity::class.java)
        val intent2 = Intent(requireContext(), NewBookActivity::class.java)

        binding.inputBackgroundIv.setOnClickListener{startActivity(intent)}
        binding.searchButtonIv.setOnClickListener { startActivity(intent) }

        binding.homeTextboxIv.setOnClickListener { startActivity(intent2) }

        binding.calLeftBtn.setOnClickListener {
            val cal_month = binding.calMonth.toString()
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}