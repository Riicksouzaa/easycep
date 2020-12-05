package com.rsf.easycep.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rsf.easycep.R
import com.rsf.kteasycep.EasyCep
import com.rsf.kteasycep.model.Cep

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        textView = root.findViewById(R.id.text_home)

        val cep = EasyCep().retrieveCep("74933310") { cep -> onResult(cep) }

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    fun onResult(cep: Cep?){
        textView.text = cep?.neighborhood
    }


}