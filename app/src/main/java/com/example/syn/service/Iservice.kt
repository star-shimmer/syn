package com.example.syn.service

import com.example.syn.model.AudioBean

interface Iservice {
    fun updatePlayState()
    fun isPlaying():Boolean?
    fun getDuration(): Int
    fun getProgress(): Int
    fun seekTo(p1: Int)
    fun updatePlayMode()
    fun  getPlayMode(): Int
    fun playPre()
    fun playNext()
    fun getPlayList(): List<AudioBean>?
    fun playPosition(p2: Int)
    fun playItem()
}