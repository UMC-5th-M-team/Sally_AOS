package com.umc.sally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.sally.databinding.FragmentMypageBinding
import com.umc.sally.mypageRecycler.MypageReviewAdapter
import com.umc.sally.mypageRecycler.MypageReviewItem


class MypageFragment : Fragment() {

    // ViewBinding Setting
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    // 리뷰 리스트 recyclerview adapter
    private var mypageReviewItems: MutableList<MypageReviewItem>? = null
    private lateinit var mypageReviewAdapter: MypageReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recyclerview 세팅
        initRecycler()

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

        addMypageReviewItem(MypageReviewItem("포스트 윤석열", "곽영훈", "정치와 신념", "유니버스 에디션의 표지는 각도에 따라 다르게 보이는 렌티큘러 효과를 사용해 부의 피라미드로 향하는 역행자 세계관을 구현했다. 본문에는 자청이 『역행자』를 다시 읽으며 필기한 비하인드 스토리, 새로 추가된 정보들뿐 아니라 독자들에게 꼭 강조하고픈 문장에 그은 밑줄까지 그대로 옮겼다. 자청의 생생한 코멘터리를 그대로 옮긴 유니버스 에디션을 통해 독자들은 역행자 세계관에 한층 더 가까워질 수 있을 것이다.",
            "", "2024년 01월 13일 18:20", "p.120 ~ p.180"))
        addMypageReviewItem(MypageReviewItem("포스트 윤석열", "곽영훈", "정치와 신념", "유니버스 에디션의 표지는 각도에 따라 다르게 보이는 렌티큘러 효과를 사용해 부의 피라미드로 향하는 역행자 세계관을 구현했다. 본문에는 자청이 『역행자』를 다시 읽으며 필기한 비하인드 스토리, 새로 추가된 정보들뿐 아니라 독자들에게 꼭 강조하고픈 문장에 그은 밑줄까지 그대로 옮겼다. 자청의 생생한 코멘터리를 그대로 옮긴 유니버스 에디션을 통해 독자들은 역행자 세계관에 한층 더 가까워질 수 있을 것이다.",
            "", "2024년 01월 13일 18:20", "p.120 ~ p.180"))
    }

    // recyclerview 세팅
    private fun initRecycler() {
        mypageReviewItems = mutableListOf<MypageReviewItem>()

        // 링크 리스트 recyclerview 세팅
        mypageReviewAdapter = MypageReviewAdapter(
            requireContext()
        )
        binding.recyclerviewMypageReview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewMypageReview.adapter = mypageReviewAdapter
        binding.recyclerviewMypageReview.isNestedScrollingEnabled = false // 스크롤을 매끄럽게 해줌
        mypageReviewAdapter.items = mypageReviewItems!!
    }

    private fun addMypageReviewItem(mypageReviewItem: MypageReviewItem) {
        mypageReviewItems!!.apply {
            add(mypageReviewItem)
        }

        mypageReviewAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}