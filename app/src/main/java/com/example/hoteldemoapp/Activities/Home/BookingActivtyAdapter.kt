package com.example.hoteldemoapp.Activities.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import android.support.v7.widget.LinearLayoutManager
import com.example.hoteldemoapp.R


/**
 * A custom adapter to use with the RecyclerView widget.
 */
class BookingActivtyAdapter(private val mContext: Context, private var modelList: ArrayList<BookingActivtyModel2>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItemClickListener: OnItemClickListener? = null

    fun updateList(modelList: ArrayList<BookingActivtyModel2>) {
        this.modelList = modelList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.bookigitem_recycler_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //Here you can fill your row view
        if (holder is ViewHolder) {
            val model = getItem(position)
            val genericViewHolder = holder

            genericViewHolder.itemTxtTitle.text = model.title
            genericViewHolder.itemTxtMessage.text = model.message


        }
    }


    override fun getItemCount(): Int {

        return modelList!!.size
    }

    fun SetOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }

    private fun getItem(position: Int): BookingActivtyModel2 {
        return modelList!![position]
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, model: BookingActivtyModel2)
    }

    inner class ViewHolder// @BindView(R.id.img_user)
    // ImageView imgUser;
    // @BindView(R.id.item_txt_title)
    // TextView itemTxtTitle;
    // @BindView(R.id.item_txt_message)
    // TextView itemTxtMessage;
    // @BindView(R.id.radio_list)
    // RadioButton itemTxtMessage;
    // @BindView(R.id.check_list)
    // CheckBox itemCheckList;
        (itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgUser: ImageView
        private val itemTxtTitle: TextView
        private val itemTxtMessage: TextView


        init {

            // ButterKnife.bind(this, itemView);

            this.imgUser = itemView.findViewById<View>(R.id.img_user) as ImageView
            this.itemTxtTitle = itemView.findViewById<View>(R.id.item_txt_title) as TextView
            this.itemTxtMessage = itemView.findViewById<View>(R.id.item_txt_message) as TextView


            itemView.setOnClickListener {
                mItemClickListener!!.onItemClick(
                    itemView,
                    adapterPosition,
                    modelList!![adapterPosition]
                )
            }

        }
    }

}

