package com.shusharin.cleanarchitecture.data.di

import com.shusharin.cleanarchitecture.data.api.ApiClient
import com.shusharin.cleanarchitecture.data.api.ServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    // TODO: 02.12.2021 сохранить правильно
    val BASE_URL = "https://api.nytimes.com"
    val API_KEY = "7QCIZ4hf7Gu8OalDqfpk6qAbcZNtYKPr"


    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }


    @Singleton
    @Provides
    fun provideApiClient(serviceApi: ServiceApi): ApiClient {
        return ApiClient(serviceApi)
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            // TODO: 02.12.2021 разобраться с зависимостями
//            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            // TODO: 03.12.2021 добавление в запрос реализовать
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                    .build()
//                return@addInterceptor chain.proceed(request)
//            }
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}