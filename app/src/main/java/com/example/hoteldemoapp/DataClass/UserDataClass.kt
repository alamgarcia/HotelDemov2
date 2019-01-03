package com.example.hoteldemoapp.DataClass

data class UserDataClass(
    var records: List<Record> = listOf()
) {
    data class Record(
        var apellidos: String = "",
        var correo: String = "",
        var extension: String = "",
        var id: Int = 0,
        var movil: String = "",
        var nombre: String = "",
        var password: String = ""
    )
}