package com.example.apicalling

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class CustomListViewAdapter(val context: Context, val data:List<DataModel>): BaseAdapter() {
    override fun getCount(): Int {

        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return data.size.toLong()
    }

    @SuppressLint("MissingInflatedId")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView= LayoutInflater.from(context).inflate(R.layout.listviewdesign,parent,false)
        val name=rowView.findViewById<TextView>(R.id.name)
        val course=rowView.findViewById<TextView>(R.id.course)
        name.text=data[position].name
        course.text=data[position].course
        val img=rowView.findViewById<CircleImageView>(R.id.image)
        val imgData=data[position]
        Glide.with(context).load(imgData.image).error(R.drawable.ic_launcher_background).into(img);
        return rowView
    }
}