package com.umc.sally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.umc.sally.databinding.FragmentMypageBinding


class MypageFragment : Fragment() {

    // ViewBinding Setting
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // status bar
        val mWindow = requireActivity().window
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        mWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.main_color)

        // 읽은 책 통계
        binding.btnMypageMove1.setOnClickListener {
            binding.relativeMypage1.visibility = View.GONE
            binding.relativeMypage2.visibility = View.VISIBLE
        }

        // 돌아보기
        binding.btnMypageMove2.setOnClickListener {
            binding.relativeMypage1.visibility = View.VISIBLE
            binding.relativeMypage2.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}