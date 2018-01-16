package com.example.denizen.kotlinfoodapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.denizen.kotlinfoodapp.R

class NewActivity : AppCompatActivity(){
    private  var TAG : String = this@NewActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        var transaction: android.support.v4.app.FragmentTransaction?
                = supportFragmentManager.beginTransaction().add(R.id.container, NewActivityFragment())
        transaction!!.commit()

    }
}
