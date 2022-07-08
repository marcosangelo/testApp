package br.com.uol.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/newloran2/testApp/main/")
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setLenient()
                            .create()
                    )
                ).build()
        }
    }
}