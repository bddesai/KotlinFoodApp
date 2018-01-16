package com.example.denizen.kotlinfoodapp.service

import com.example.denizen.kotlinfoodapp.model.BusinessResponse
import com.example.denizen.kotlinfoodapp.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by denizen on 1/15/18.
 */


interface ApiClient {
    // List of API endpoints
    @Headers("Authorization: Bearer nkynG8v_g-FyTFICuVkHYX0SNDPuKhiZ_1SgzcBMS09ZdxuNNuleH7Ck6QCXn_zzjvNunF_RlKvbbOWlEgIHQdRRNme2Woq3nBdHUYBpBkWw8XFeQ0Gyha2kDC9dWnYx")
    @GET("search")
    fun getBusinessesByCoordinates(@Query("term") term: String,
                         @Query("latitude") latitude: String,
                         @Query("longitude") longitude: String): Call<BusinessResponse>

    @Headers("Authorization: Bearer nkynG8v_g-FyTFICuVkHYX0SNDPuKhiZ_1SgzcBMS09ZdxuNNuleH7Ck6QCXn_zzjvNunF_RlKvbbOWlEgIHQdRRNme2Woq3nBdHUYBpBkWw8XFeQ0Gyha2kDC9dWnYx")
    @GET("search")
    fun getBusinessesByLocation(@Query("term") term: String,
                      @Query("location") location: String): Call<BusinessResponse>


    //create Retrofit REST client
    companion object Factory {
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiClient::class.java)
        }
    }
}