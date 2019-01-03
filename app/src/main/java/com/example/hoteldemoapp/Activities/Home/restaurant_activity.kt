package com.example.hoteldemoapp.Activities.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import java.util.ArrayList

import com.example.hoteldemoapp.R

import android.widget.Toast


class restaurant_activity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    private var mAdapter: RecyclerViewAdapter? = null

    private val modelList = ArrayList<AbstractModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_activity)

        // ButterKnife.bind(this);
        findViews()
        setAdapter()


    }

    private fun findViews() {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
    }


    private fun setAdapter() {


        val singleItemList = ArrayList<AbstractModel>()

        singleItemList.add(AbstractModel("Android", "Hello " + " Android"))
        singleItemList.add(AbstractModel("Beta", "Hello " + " Beta"))
        singleItemList.add(AbstractModel("Cupcake", "Hello " + " Cupcake"))
        singleItemList.add(AbstractModel("Donut", "Hello " + " Donut"))
        singleItemList.add(AbstractModel("Eclair", "Hello " + " Eclair"))
        singleItemList.add(AbstractModel("Froyo", "Hello " + " Froyo"))
        singleItemList.add(AbstractModel("Gingerbread", "Hello " + " Gingerbread"))
        singleItemList.add(AbstractModel("Honeycomb", "Hello " + " Honeycomb"))
        singleItemList.add(AbstractModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"))
        singleItemList.add(AbstractModel("Jelly Bean", "Hello " + " Jelly Bean"))
        singleItemList.add(AbstractModel("KitKat", "Hello " + " KitKat"))
        singleItemList.add(AbstractModel("Lollipop", "Hello " + " Lollipop"))
        singleItemList.add(AbstractModel("Marshmallow", "Hello " + " Marshmallow"))
        singleItemList.add(AbstractModel("Nougat", "Hello " + " Nougat"))
        singleItemList.add(AbstractModel("Android O", "Hello " + " Android O"))


        modelList.add(AbstractModel("Android", "Hello " + " Android", singleItemList))
        modelList.add(AbstractModel("Beta", "Hello " + " Beta", singleItemList))
        modelList.add(AbstractModel("Cupcake", "Hello " + " Cupcake", singleItemList))
        modelList.add(AbstractModel("Donut", "Hello " + " Donut", singleItemList))
        modelList.add(AbstractModel("Eclair", "Hello " + " Eclair", singleItemList))
        modelList.add(AbstractModel("Froyo", "Hello " + " Froyo", singleItemList))
        modelList.add(AbstractModel("Gingerbread", "Hello " + " Gingerbread", singleItemList))
        modelList.add(AbstractModel("Honeycomb", "Hello " + " Honeycomb", singleItemList))
        modelList.add(AbstractModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich", singleItemList))
        modelList.add(AbstractModel("Jelly Bean", "Hello " + " Jelly Bean", singleItemList))
        modelList.add(AbstractModel("KitKat", "Hello " + " KitKat", singleItemList))
        modelList.add(AbstractModel("Lollipop", "Hello " + " Lollipop", singleItemList))
        modelList.add(AbstractModel("Marshmallow", "Hello " + " Marshmallow", singleItemList))
        modelList.add(AbstractModel("Nougat", "Hello " + " Nougat", singleItemList))
        modelList.add(AbstractModel("Android O", "Hello " + " Android O", singleItemList))


        mAdapter = RecyclerViewAdapter(this@restaurant_activity, modelList)

        recyclerView!!.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager


        recyclerView!!.adapter = mAdapter




    }


}
