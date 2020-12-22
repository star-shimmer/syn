package com.example.syn.ui.clock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.syn.R
import kotlinx.android.synthetic.main.fragment_clock.*

class ClockFragment : Fragment() {

    private lateinit var clockViewModel: ClockViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ClockViewModel::class.java)

        viewModel.seconds.observe(this, Observer {
            val hours = it / 3600
            val minutes = (it%3600) / 60
            val secs = it % 60
            time.text = String.format("%02d:%02d:%02d",hours, minutes,secs)
        })

        btn_start.setOnClickListener {
            viewModel.start()
        }
        btn_stop.setOnClickListener {
            viewModel.stop()
        }
        btn_restart.setOnClickListener {
            viewModel.restart()
        }
    }
}