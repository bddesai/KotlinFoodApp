package com.example.denizen.kotlinfoodapp.util

/**
 * Created by denizen on 1/15/18.
 */


class Constants{
    companion object {
        val BASE_URL = "https://api.yelp.com/v3/businesses/"
        val AUTH_HEADER = "Bearer nkynG8v_g-FyTFICuVkHYX0SNDPuKhiZ_1SgzcBMS09ZdxuNNuleH7Ck6QCXn_zzjvNunF_RlKvbbOWlEgIHQdRRNme2Woq3nBdHUYBpBkWw8XFeQ0Gyha2kDC9dWnYx"

        fun isReallyNull(string: String): Boolean{
            if(string.isNullOrEmpty() || string.isNullOrBlank()){
                return true
            }
            return false
        }
    }
}