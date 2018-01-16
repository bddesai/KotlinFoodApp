package com.example.denizen.kotlinfoodapp.util

/**
 * Created by denizen on 1/15/18.
 */


class Constants{
    companion object {
        val BASE_URL = "https://api.yelp.com/v3/businesses/"

        fun isReallyNull(string: String): Boolean{
            if(string.isNullOrEmpty() || string.isNullOrBlank()){
                return true
            }
            return false
        }
    }
}