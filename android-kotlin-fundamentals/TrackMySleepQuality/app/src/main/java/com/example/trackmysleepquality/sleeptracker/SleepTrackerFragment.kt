package com.example.trackmysleepquality.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.trackmysleepquality.R
import com.example.trackmysleepquality.database.SleepDatabase
import com.example.trackmysleepquality.databinding.SleepTrackerFragmentBinding
import com.google.android.material.snackbar.Snackbar

class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SleepTrackerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.sleep_tracker_fragment, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory = SleepTrackerViewModelFactory(dataSource, application)
        val sleepTrackerViewModel =
            ViewModelProvider(this, viewModelFactory).get(SleepTrackerViewModel::class.java)

        sleepTrackerViewModel.navigateToSleepQuality.observe(this, Observer { night ->
            night?.let {
                this.findNavController().navigate(
                    SleepTrackerFragmentDirections.actionSleepTrackerFragmentToSleepQualityFragment(
                        night.nightId
                    )
                )
                sleepTrackerViewModel.doneNavigating()
            }
        })

        sleepTrackerViewModel.showSnackbarEvent.observe(this, Observer {
            if (it == true) {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    getString(R.string.cleared_message),
                    Snackbar.LENGTH_SHORT
                ).show()
                sleepTrackerViewModel.doneShowingSnackbar()
            }
        })

        binding.lifecycleOwner = this
        binding.sleepTrackerViewModel = sleepTrackerViewModel

        return binding.root
    }
}