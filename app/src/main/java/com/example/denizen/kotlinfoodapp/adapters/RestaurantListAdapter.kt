package com.example.denizen.kotlinfoodapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.denizen.kotlinfoodapp.R
import com.example.denizen.kotlinfoodapp.model.Business

/**
 * Created by denizen on 1/14/18.
 */

class RestaurantListAdapter(context: Context, dataList: List<Business>) : BaseAdapter() {

    private var sList = dataList
    private val context = context
    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.restaurant_list_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.label_rest_name.text = sList[position].name
        vh.label_rest_rating.text = sList[position].rating.toString()
        vh.label_rest_phone.text = sList[position].display_phone
        Glide.with(context)
                .load(sList[position].image_url)
                .into(vh.image_rest)
        return view
    }
}

class ListRowHolder(row: View?) {
    val label_rest_name: TextView = row?.findViewById(R.id.label_rest_name) as TextView
    val label_rest_rating: TextView = row?.findViewById(R.id.label_rest_rating) as TextView
    val image_rest: ImageView = row?.findViewById(R.id.image_rest) as ImageView
    val label_rest_phone: TextView = row?.findViewById(R.id.label_rest_phone) as TextView

}
