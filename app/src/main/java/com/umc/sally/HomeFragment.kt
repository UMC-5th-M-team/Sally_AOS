package com.umc.sally

<<<<<<< HEAD
import android.content.Intent
=======
>>>>>>> 0edb57f ([FEAT] 하단바 생성)
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

<<<<<<< HEAD
        val intent = Intent(requireContext(), SearchActivity::class.java)
        val intent2 = Intent(requireContext(), NewBookActivity::class.java)

        binding.inputBackgroundIv.setOnClickListener{startActivity(intent)}
        binding.searchButtonIv.setOnClickListener { startActivity(intent) }

        binding.homeTextboxIv.setOnClickListener { startActivity(intent2) }

        binding.calLeftBtn.setOnClickListener {
            val cal_month = binding.calMonth.toString()
        }

=======
>>>>>>> 0edb57f ([FEAT] 하단바 생성)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}