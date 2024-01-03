package com.example.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"// 데이터 이름

class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null // 액티비티에서 받을거
    private val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ew", "do")
        //아규먼트가 널이 아닐때 겟스트링, 메인 액티비티에서 보낸 스트링값이 이안에 들어가 있음
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    // 파라그먼트 만들어질때 실행되는것
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
         [1] Activity -> FirstFragment
         파라그먼트의 tv텍스트를 param1(메인 액티비티에서 보낸 데이터)로 변경
         */
        binding.tvFrag1Text.text = param1

        // [2] Fragment -> Fragment
        binding.btnGofrag2.setOnClickListener {

        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) = //메인 액티비티에서 newInstance를 만들어서 파람에 넣었음
            // [1] Activity -> FirstFragment
            FirstFragment().apply {
                arguments = Bundle().apply {// 아규먼트안에 번들
                    putString(ARG_PARAM1, param1) // 위의 아규먼트 파람에 들어온 파라미터를 넣어줌
                }
            }
    }
}