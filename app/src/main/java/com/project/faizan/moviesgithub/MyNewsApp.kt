package com.project.faizan.moviesgithub

import android.app.Application
import com.project.faizan.moviesgithub.data.ConnectivityInterceptor
import com.project.faizan.moviesgithub.data.ConnectivityInterceptorImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MyNewsApp : Application(), KodeinAware {
    //kodien for dependency injection so it should be kodinAware

    override val kodein = Kodein.lazy {
        //androidXModule provide us with instances of context, services and anything that is related to android
        //so that we dont need to reinvent the wheel
        import(androidXModule(this@MyNewsApp))


        //bind connectivity interceptor as well as its underlying implementation
        bind<ConnectivityInterceptor>() with singleton {
            ConnectivityInterceptorImpl(
                instance()
            )
        }

    }
}