package com.example.ksero

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class RetailSettingsFragment : Fragment() {

    lateinit var btnProfile: Button
    lateinit var btnLogout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retail_settings, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnProfile = view.findViewById(R.id.btnProfile)
        btnLogout = view.findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        })

        btnProfile.setOnClickListener(View.OnClickListener {

            val fragment: Fragment = Profile()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.containerView, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        })
    }
}