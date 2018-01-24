package com.example.denizen.kotlinfoodapp.service

import com.example.denizen.kotlinfoodapp.model.BusinessResponse
import com.example.denizen.kotlinfoodapp.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by denizen on 1/15/18.
 */


interface ApiClient {
    // List of API endpoints
    @GET("search")
    fun getBusinessesByCoordinates(@Query("term") term: String,
                         @Query("latitude") latitude: String,
                         @Query("longitude") longitude: String): Call<BusinessResponse>

    @GET("search")
    fun getBusinessesByLocation(@Query("term") term: String,
                      @Query("location") location: String): Call<BusinessResponse>


    //create Retrofit REST client
    companion object Factory {
        fun create(): ApiClient {

            // === Build and OkHttp Client  ====
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()

                // Request customization: add auth header
                val requestBuilder = original.newBuilder()
                        .header("Authorization", Constants.AUTH_HEADER)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
            val client = httpClient.build()


            // Generate a Retrofit Request
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiClient::class.java)
        }
    }
}