package com.example.hoteldemoapp.Activities.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager

import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.View

import java.util.ArrayList

import com.example.hoteldemoapp.R

import android.widget.Toast
import android.os.Handler


class BookingActivty : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    private var mAdapter: BookingActivtyAdapter? = null

    private val modelList = ArrayList<BookingActivtyModel2>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_activty)

        // ButterKnife.bind(this);
        findViews()
        setAdapter()


    }

    private fun findViews() {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
    }


    private fun setAdapter() {


        modelList.add(BookingActivtyModel2("Android", "Hello " + " Android"))
        modelList.add(BookingActivtyModel2("Beta", "Hello " + " Beta"))
        modelList.add(BookingActivtyModel2("Cupcake", "Hello " + " Cupcake"))
        modelList.add(BookingActivtyModel2("Donut", "Hello " + " Donut"))
        modelList.add(BookingActivtyModel2("Eclair", "Hello " + " Eclair"))
        modelList.add(BookingActivtyModel2("Froyo", "Hello " + " Froyo"))
        modelList.add(BookingActivtyModel2("Gingerbread", "Hello " + " Gingerbread"))
        modelList.add(BookingActivtyModel2("Honeycomb", "Hello " + " Honeycomb"))
        modelList.add(BookingActivtyModel2("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"))
        modelList.add(BookingActivtyModel2("Jelly Bean", "Hello " + " Jelly Bean"))
        modelList.add(BookingActivtyModel2("KitKat", "Hello " + " KitKat"))
        modelList.add(BookingActivtyModel2("Lollipop", "Hello " + " Lollipop"))
        modelList.add(BookingActivtyModel2("Marshmallow", "Hello " + " Marshmallow"))
        modelList.add(BookingActivtyModel2("Nougat", "Hello " + " Nougat"))
        modelList.add(BookingActivtyModel2("Android O", "Hello " + " Android O"))


        mAdapter = BookingActivtyAdapter(this@BookingActivty, modelList)

        recyclerView!!.setHasFixedSize(true)

        // use a linear layout manager

        val layoutManager = LinearLayoutManager(this)

        recyclerView!!.layoutManager = layoutManager


        recyclerView!!.adapter = mAdapter


        mAdapter!!.SetOnItemClickListener { view, position, model ->
            //handle item click events here
            Toast.makeText(this@BookingActivty, "Hey " + model.title!!, Toast.LENGTH_SHORT).show()
        }


    }


}
