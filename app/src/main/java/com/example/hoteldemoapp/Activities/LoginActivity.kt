package com.example.hoteldemoapp.Activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hoteldemoapp.ByPaSSL
import com.example.hoteldemoapp.DataClass.UserDataClass
import com.example.hoteldemoapp.HashSHA1
import com.example.hoteldemoapp.HomeActivity
import com.example.hoteldemoapp.R
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            ByPaSSL().useInsecureSSL()
            var email = email_txt.text.toString()
            var pass = pass_txt.text.toString()
            pass = HashSHA1.HashUtils.sha1(pass)
            val manager: FuelManager by lazy { FuelManager() }
            //Usamos el metodo request de FUUEL Manager, junto a la lusta de parametros
            manager.request(Method.GET, "https://devavaya.ddns.net/hotel/api.php/records/users_tb?filter=correo,eq,$email&filter=password,eq,$pass").responseString { req, res, result ->
                val (data, error) = result
                //Si no tenemos ningun error, procedemos a hacer la llamada, ya que el servidor respondio con un 200 y tendremos el Token de LLamada
                when (error) {
                    null -> {
                        //Imprimimos el Response en el LogCat solo para asegurar que se hizo bien la peticion
                        Log.d("RESPONSES", data)
                        // creamos una variable llamada gson para la Funcion GSON() para que sea mas accesible
                        var gson = Gson()
                        //Asignamos a la variable Login el metodo gson?.fromJson(data, Login.Response::class.java) y le pasamos el response JSON para su conversion a un objeto que Android puede manejar
                        var UserData = gson?.fromJson(data, UserDataClass::class.java)

                        if (UserData.records.isEmpty()){
                            Log.d("Responses","No hay resultados")

                        }else{
                            Log.d("Responses","Si hay resultados")
                            val myPreferences = "myPrefs"
                            val sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("nombre", UserData.records[0].nombre)
                            editor.putString("apellidos", UserData.records[0].apellidos)
                            editor.putString("movil", UserData.records[0].movil)
                            editor.putString("extension", UserData.records[0].extension)
                            editor.putString("correo", UserData.records[0].correo)
                            editor.putString("password", UserData.records[0].password)
                            editor.putInt("id", UserData.records[0].id)
                            editor.putInt("logged", 1)
                            editor.apply()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()

                        }
                    }
                }
            }

        }
    }
}
