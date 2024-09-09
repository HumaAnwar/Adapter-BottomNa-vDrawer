package com.example.adapterbottomnavdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adapterbottomnavdrawer.databinding.FragmentMeBinding


class MeFragment : Fragment() {
  private lateinit var binding: FragmentMeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

            }
