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
import com.example.syn.ui.game.GameViewModel
import kotlinx.android.synthetic.main.fragment_clock.*

class ClockFragment : Fragment() {

    private lateinit var clockViewModel: ClockViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        clockViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ClockViewModel::class.java)

        clockViewModel.seconds.observe(viewLifecycleOwner, Observer {
            val hours = it / 3600
            val minutes = (it%3600) / 60
            val secs = it % 60
            time.text = String.format("%02d:%02d:%02d",hours, minutes,secs)
        })

        btn_start.setOnClickListener {
            clockViewModel.start()
        }
        btn_stop.setOnClickListener {
            clockViewModel.stop()
        }
        btn_restart.setOnClickListener {
            clockViewModel.restart()
        }

    }
}