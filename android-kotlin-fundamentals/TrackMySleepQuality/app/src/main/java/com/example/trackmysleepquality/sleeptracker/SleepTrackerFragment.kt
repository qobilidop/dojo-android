package com.example.trackmysleepquality.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trackmysleepquality.R
import com.example.trackmysleepquality.databinding.SleepTrackerFragmentBinding

class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepTrackerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.sleep_tracker_fragment, container, false
        )

        return binding.root
    }

}