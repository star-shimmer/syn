package com.example.syn.ui.fragment

import android.provider.MediaStore
import android.view.View
import com.example.syn.R
import com.example.syn.base.BaseFragment

class MusicFragment: BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.music_fragment, null)
    }

    override fun initData() {
        //加载音乐列表数据
        val resolver = context?.contentResolver
        val cursor = resolver?.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            arrayOf(
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.ARTIST),
            null,null,null)
        //打印所有数据

    }
}