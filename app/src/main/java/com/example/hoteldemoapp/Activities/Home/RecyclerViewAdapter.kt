package com.example.hoteldemoapp.Activities.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import com.example.hoteldemoapp.R


class RecyclerViewAdapter(private val context: Context, private var modelList: List<AbstractModel>?) :
    SectionedRecyclerViewAdapter<RecyclerView.ViewHolder>() {

    private var mItemClickListener: OnItemClickListener? = null

    override val sectionCount: Int
        get() = modelList!!.size

    fun updateList(modelList: ArrayList<AbstractModel>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

    override fun getItemCount(section: Int): Int {

        return modelList!![section].singleItemArrayList!!.size

    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, section: Int) {

        val sectionName = modelList!![section].title
        val sectionViewHolder = holder as SectionViewHolder
        sectionViewHolder.txtHeader.text = sectionName
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        section: Int,
        relativePosition: Int,
        absolutePosition: Int
    ) {

        val itemsInSection = modelList!![section].singleItemArrayList

        val itemTitle = itemsInSection!![relativePosition].title
        val itemMessage = itemsInSection[relativePosition].message

        val itemViewHolder = holder as ViewHolder

        itemViewHolder.itemTxtTitle.text = itemTitle
        itemViewHolder.itemTxtMessage.text = itemMessage


    }

    override fun onCreateViewHolder(parent: ViewGroup, header: Boolean): RecyclerView.ViewHolder {
        if (header) {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_recycler_section, parent, false)
            return SectionViewHolder(view)
        } else {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_recycler_list, parent, false)
            return ViewHolder(view)
        }

    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, model: AbstractModel)
    }

    // SectionViewHolder Class for Sections
    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        internal val txtHeader: TextView

        init {

            txtHeader = itemView.findViewById<View>(R.id.txt_header) as TextView


        }
    }

    // ItemViewHolder Class for Items in each Section
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val itemTxtTitle: TextView

        internal val imgUser: ImageView

        internal val itemTxtMessage: TextView


        init {
            itemTxtTitle = itemView.findViewById<View>(R.id.item_txt_title) as TextView
            itemTxtMessage = itemView.findViewById<View>(R.id.item_txt_message) as TextView

            imgUser = itemView.findViewById<View>(R.id.img_user) as ImageView


        }
    }


}


