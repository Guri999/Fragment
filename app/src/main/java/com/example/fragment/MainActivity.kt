package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            fragment1Btn.setOnClickListener {
                val dataToSend = "Hello First Fragment! \n From Activity"//액티비티에서 보내는 메세지
                val fragment = FirstFragment.newInstance(dataToSend) // 보낼때는 newInstance해서 데이터 넣고 보냄끝
                setFragment(fragment) // 셋 프래그먼트에 프래그먼트를 파라미터를 줌
            }
            fragment2Btn.setOnClickListener {
                val dataToSend = "Hello Second Fragment! \n From Activity"
                val fragment = SecondFragment.newInstance(dataToSend)
                setFragment(fragment)
            }
        }
    }

    //프래그먼트 전환
    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag) // 프레임 레이아웃에 프래그먼트 뿌리겠다
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}