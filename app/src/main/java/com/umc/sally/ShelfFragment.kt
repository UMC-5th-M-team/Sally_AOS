package com.umc.sally

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.umc.sally.databinding.FragmentShelfBinding


class ShelfFragment : Fragment() {
    // ViewBinding Setting
    private var _binding: FragmentShelfBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShelfBinding.inflate(layoutInflater)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // status bar
        val mWindow = requireActivity().window
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        mWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.main_color)

        binding.imgBook.setOnClickListener(View.OnClickListener {
            binding.relativeBookShelf.visibility = View.GONE
            binding.relativeSelectBook.visibility = View.VISIBLE
            binding.shelfAll.setBackgroundColor(Color.parseColor("#F2E9E4"));
        })

        binding.imgBackShelf.setOnClickListener(View.OnClickListener {
            binding.relativeBookShelf.visibility = View.VISIBLE
            binding.relativeSelectBook.visibility = View.GONE
            binding.shelfAll.setBackgroundColor(Color.parseColor("#C9ADA7"));
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}