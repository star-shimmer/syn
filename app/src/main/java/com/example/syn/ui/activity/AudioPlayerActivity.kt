package com.example.syn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.syn.R
import com.example.syn.base.BaseActivity
import com.example.syn.model.AudioBean

class AudioPlayerActivity: BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_audio_player
    }

    override fun initData() {
        val list = intent.getParcelableArrayListExtra<AudioBean>("list")
        val position = intent.getIntExtra("position",-1)
        //播放音乐

    }
}