package com.example.syn.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.syn.R

class GameFragment : Fragment() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        gameViewModel =
            ViewModelProviders.of(this).get(GameViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_game, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        gameViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}