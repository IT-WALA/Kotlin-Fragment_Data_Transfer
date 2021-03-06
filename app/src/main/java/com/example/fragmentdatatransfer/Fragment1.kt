package com.example.fragmentdatatransfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        btnGotoSecondFragment.setOnClickListener { gotoSecondFragment() }
        return view
    }

    private fun gotoSecondFragment() {
        val bundle = Bundle()
        bundle.putString("name", "IT wala")
        val fragment2 = Fragment2()
        fragment2.arguments = bundle
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment2, "Fragment2")
        fragmentTransaction.addToBackStack("Fragment2")
        fragmentTransaction.commit()
    }
}