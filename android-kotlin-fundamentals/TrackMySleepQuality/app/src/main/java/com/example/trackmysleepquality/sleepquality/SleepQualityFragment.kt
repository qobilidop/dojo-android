package com.example.trackmysleepquality.sleepquality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trackmysleepquality.R
import com.example.trackmysleepquality.databinding.SleepQualityFragmentBinding

class SleepQualityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepQualityFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.sleep_quality_fragment, container, false
        )

        val application = requireNotNull(this.activity).application

        return binding.root
    }

}