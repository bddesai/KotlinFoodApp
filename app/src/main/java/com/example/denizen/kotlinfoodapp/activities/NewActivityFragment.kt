package com.example.denizen.kotlinfoodapp.activities


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denizen.kotlinfoodapp.R


/**
 * A simple [Fragment] subclass.
 */
class NewActivityFragment : Fragment() {
    private  var TAG : String = this@NewActivityFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View =  inflater!!.inflate(R.layout.fragment_new_activity, container, false)

        return view
    }
}