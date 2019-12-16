package com.project.faizan.moviesgithub.internals

import android.util.Log

class Logger {

    companion object {

        private val TAG: String? = Logger::class.java.simpleName

        fun log(msg: String) {

            Log.d(TAG, msg)
        }

        fun log(tag: String, msg: String) {

            Log.d(tag, msg)
        }
    }
}