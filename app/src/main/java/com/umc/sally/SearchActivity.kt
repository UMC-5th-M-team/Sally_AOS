package com.umc.sally

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.umc.sally.databinding.ActivityHomeSearchBinding

class SearchActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeSearchBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        binding.searchBackBtn.setOnClickListener { startActivity(intent) }


    }

}