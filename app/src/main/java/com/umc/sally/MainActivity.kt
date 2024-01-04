package com.umc.sally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.umc.sally.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // NavController 선언
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavController 설정
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // Navigation Graph를 사용해서 Bottom Navigation 설정
        binding.navBottom.setupWithNavController(navController)

        // 아이콘에 색상 입히지 않고 아이콘 이미지 그대로 보여주기
        //binding.navBottom.itemIconTintList = null

        // 최상위 화면을 제외하고는 BottomNavigation Bar 없애기
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.menu_home ||
                destination.id == R.id.menu_shelf ||
                destination.id == R.id.menu_mypage) {
                binding.navBottom.visibility = View.VISIBLE
            } else {
                binding.navBottom.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}