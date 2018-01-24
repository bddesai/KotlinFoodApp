package com.example.denizen.kotlinfoodapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.denizen.kotlinfoodapp.R
import com.example.denizen.kotlinfoodapp.adapters.RestaurantListAdapter
import com.example.denizen.kotlinfoodapp.model.BusinessResponse
import com.example.denizen.kotlinfoodapp.service.ApiClient
import com.example.denizen.kotlinfoodapp.util.Constants
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  var TAG : String = this@MainActivity::class.java.simpleName
    lateinit var  restaurantList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val text_cuisine = findViewById<EditText>(R.id.text_cuisine)
        val text_location = findViewById<EditText>(R.id.text_location)

        restaurantList = findViewById(R.id.restaurantListView)

        val button = findViewById<Button>(R.id.btnGetBusinesses)
        button.setOnClickListener{
            fetchBusinesses(text_cuisine.text.toString(),
                    text_location.text.toString()
                    )}
    }

    fun fetchBusinesses(cuisine: String, location: String) {

        if(Constants.isReallyNull(cuisine) || Constants.isReallyNull(location)){
            alert(getString(R.string.empty_fields_error), "Fields are empty"){ yesButton {} }.show()
            return
        }

        val apiService: ApiClient = ApiClient.create()
        var call: Call<BusinessResponse> = apiService.getBusinessesByLocation(cuisine,location)

        call.enqueue(object : Callback<BusinessResponse> {
            override fun onResponse(call: Call<BusinessResponse>, response: Response<BusinessResponse>) {
                val businessList = response.body()!!.businesses
                restaurantList.adapter = RestaurantListAdapter(this@MainActivity, businessList)
            }

            override fun onFailure(call: Call<BusinessResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
                toast(R.string.service_error_message)
            }
        })

    }

    fun fetchBusinesses(cuisine: String, latitude: String, longitude: String) {

        if(Constants.isReallyNull(cuisine) || Constants.isReallyNull(latitude) || Constants.isReallyNull(longitude)){
            alert(getString(R.string.fetch_location_error), ""){ yesButton {} }.show()
            return
        }

        val apiService: ApiClient = ApiClient.create()
        var call: Call<BusinessResponse> = apiService.getBusinessesByCoordinates(cuisine, latitude, longitude)

        call.enqueue(object : Callback<BusinessResponse> {
            override fun onResponse(call: Call<BusinessResponse>, response: Response<BusinessResponse>) {
                val businessList = response.body()!!.businesses
                restaurantList.adapter = RestaurantListAdapter(this@MainActivity, businessList)
            }

            override fun onFailure(call: Call<BusinessResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
                toast(R.string.service_error_message)
            }
        })

    }

}
