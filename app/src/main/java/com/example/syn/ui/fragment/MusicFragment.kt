package com.example.syn.ui.fragment

import android.content.AsyncQueryHandler
import android.content.ContentResolver
import android.database.Cursor
import android.os.AsyncTask
import android.os.Message
import android.provider.MediaStore
import android.view.View
import com.example.syn.R
import com.example.syn.base.BaseFragment
import com.example.syn.util.CursorUtil
import java.util.logging.Handler


class MusicFragment: BaseFragment() {
//    val handler = object :Handler(){
//        override fun handleMessage(msg:Message?) {
//            msg?.let {
//                val cursor:Cursor = msg.obj as Cursor
//                CursorUtil.logCursor(cursor)
//            }
//        }
//    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.music_fragment, null)
    }

    override fun initData() {
        //加载音乐列表数据
        val resolver = context?.contentResolver

//        //开启线程查询音乐数据
//        Thread(object : Runnable{
//            override fun run(){
//                val cursor = resolver?.query(
//                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
//                    arrayOf(
//                        MediaStore.Audio.Media.DATA,
//                        MediaStore.Audio.Media.SIZE,
//                        MediaStore.Audio.Media.DISPLAY_NAME,
//                        MediaStore.Audio.Media.ARTIST),
//                    null,null,null)
//                val msg = Message.obtain()
//                msg.obj = cursor
//                handler.sendMessage(msg)
//            }
//        }).start()
        //asynctask
//        AudioTask().execute(resolver)
        val handler = object :AsyncQueryHandler(resolver){
            override fun onQueryComplete(token: Int, cookie: Any?, cursor: Cursor?) {
                //查询完成回调
                CursorUtil.logCursor(cursor)
            }
        }

        handler.startQuery(0,null,MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.ARTIST),
                    null,null,null)
    }

    /**
     * 音乐查询异步任务
     */
    class AudioTask: AsyncTask<ContentResolver,Void,Cursor>(){
        /**
         * 后台执行任务 新线程
         */
        override fun doInBackground(vararg params: ContentResolver?): Cursor? {
            val cursor = params[0]?.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.ARTIST),
                    null,null,null)
            return cursor
        }

        /**
         *将后台任务结束回调主线程
         */
//        override fun onPreExecute(result:Cursor?) {
//            super.onPostExecute(result)
//            CursorUtil.logCursor(result)
//        }
         fun onPreExecute(result:Cursor?) {
            super.onPostExecute(result)
            CursorUtil.logCursor(result)
        }

    }

}