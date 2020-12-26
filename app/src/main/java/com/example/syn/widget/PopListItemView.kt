package com.example.syn.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.syn.R
import com.example.syn.model.AudioBean
import kotlinx.android.synthetic.main.item_pop.view.*

/**
 * ClassName:PopListItemView
 * Description:
 */
class PopListItemView: RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.item_pop,this)
    }

    fun setData(data: AudioBean) {
        //title
        title.text = data.display_name
        //artist
        artist.text = data.artist
    }
}