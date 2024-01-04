package com.umc.sally

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.umc.sally.databinding.ActivityHomeSearchBinding
import com.umc.sally.databinding.ActivityNewbookBinding

class NewBookActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewbookBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
