package com.example.myfirstproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

internal class MyGridAdapter (
    private val contex: Context
): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var num: TextView
    private var count: Int = 10

    override fun getCount(): Int {
        return count
    }

    public fun intCount(){
        count += 1
        notifyDataSetChanged()
    }

    public fun setCount(cnt : Int) {
        count = cnt
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (layoutInflater == null){
            layoutInflater = contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null){
            convertView = layoutInflater!!.inflate(R.layout.item_layout, null)
        }
        var txt : TextView = convertView!!.findViewById<TextView>(R.id.idNum)
        if (position % 2 == 0)
            txt.setBackgroundResource(R.color.red)
        else
            txt.setBackgroundResource(R.color.blue)

        txt.setText(position.toString())
        return convertView
    }
}