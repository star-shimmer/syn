package com.example.syn.ui.msg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.syn.R

class MsgFragment : Fragment() {

    private lateinit var msgViewModel: MsgViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        msgViewModel =
                ViewModelProviders.of(this).get(MsgViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_msg, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        msgViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}