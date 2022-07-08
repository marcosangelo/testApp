package br.com.uol

import br.com.uol.di.CustomerModules
import br.com.uol.di.NetworkModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object AppDelegate {

    @JvmStatic
    fun onCreate(application: TestUolApp) {
        application.apply {
            val modules = mutableListOf(
                NetworkModules.module,
                CustomerModules.module
            )
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                loadKoinModules(modules)
            }
        }
    }
}