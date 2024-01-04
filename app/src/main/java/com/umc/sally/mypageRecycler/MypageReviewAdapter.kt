package com.umc.sally.mypageRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.sally.R
import com.umc.sally.databinding.ItemMypageReviewBinding

class MypageReviewAdapter(
    private val context: Context
    ):
    RecyclerView.Adapter<MypageReviewAdapter.MypageReviewViewHolder>() {

    var items = mutableListOf<MypageReviewItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MypageReviewViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_mypage_review, parent, false)

        return MypageReviewViewHolder(ItemMypageReviewBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MypageReviewViewHolder, position: Int) {
        holder.bind(items[position])


    }

    inner class MypageReviewViewHolder(private val binding: ItemMypageReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MypageReviewItem) {
            binding.textBookTitle.text = item.bookTitle
            binding.textBookWriter.text = item.bookWriter
            binding.textDate.text = item.date
            binding.textReviewContent.text = item.reviewContent
            binding.textReviewTitle.text = item.reviewTitle
            binding.textPage.text = item.page
        }
    }
}