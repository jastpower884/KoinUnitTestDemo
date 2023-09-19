package com.jastzeonic.koinunittestdemo

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class KoinUnitTestDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }

}


val appModule = module {
    factory { ComponentA(get()) }
    factory { ComponentD(get(named("default"))) }
    factory<ComponentInterface> { ComponentB() }
    factory<ComponentInterface>(named("default")) { ComponentB() }
}