package com.example.hoteldemoapp.Activities.Home

import java.util.ArrayList

class AbstractModel {

    var title: String? = null

    var message: String? = null

    var singleItemArrayList: ArrayList<AbstractModel>? = null

    constructor(title: String, message: String) {
        this.title = title
        this.message = message
    }

    constructor(title: String, message: String, singleItemModelArrayList: ArrayList<AbstractModel>) {
        this.title = title
        this.message = message
        this.singleItemArrayList = singleItemModelArrayList
    }


    constructor() {

    }
}
