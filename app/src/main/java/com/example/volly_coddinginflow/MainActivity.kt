package com.example.volly_coddinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mQueue:RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  mQueue=Volley.newRequestQueue(this)
        mQueue=VollySinglton.getIntance(this).requestQueue
        buttonParse.setOnClickListener {
            jsonParse()
        }
    }

    private fun jsonParse() {
        val url="https://api.myjson.com/bins/kp9wz"
        val request=JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener{response ->
                var st=""
                val jsonArray=response.getJSONArray("employees")
                 for (i in 0 until jsonArray.length()){
                     val json=jsonArray.getJSONObject(i)
                     val firstName=json.getString("firstname")
                     val age=json.getInt("age")
                     val mail=json.getString("mail")
                     st+="firstName:$firstName || age:${age.toString()} || mail:$mail \n\n"

                 }
                text_view_result.text=st

            },
            Response.ErrorListener { error ->
                error.printStackTrace()
            })
        mQueue.add(request)
    }
}
