package com.company.mobile.android.appname.app.user_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding
import com.company.mobile.android.appname.app.databinding.FragmentUserInfoBinding

class UserInfoFragment: BaseFragment() {

    private lateinit var binding: FragmentUserInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initializeContents(savedInstanceState: Bundle?) {
        super.initializeContents(savedInstanceState)
    }

    override fun initializeState(savedInstanceState: Bundle?) {
        super.initializeState(savedInstanceState)

        //Inicializar observadores
    }

    override fun initializeViews(savedInstanceState: Bundle?) {
        super.initializeViews(savedInstanceState)

        //Inicializar lo asociado a las vistas.
        binding.btNavegar.setOnClickListener {
            findNavController().navigate(R.id.cardsFragment)
        }
    }
}