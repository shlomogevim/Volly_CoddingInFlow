package com.example.volly_coddinginflow

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VollySinglton constructor(context: Context) {

    companion object {
        @Volatile
        var INSTANCE: VollySinglton? = null

        fun getIntance(context: Context)=
            INSTANCE?: synchronized(this){
                INSTANCE?:VollySinglton(context).also {
                    INSTANCE=it
                }
            }
    }
    val requestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req:Request<T>){
        requestQueue.add(req)
    }


    /* lateinit var mInstance:VollySinglton
     val mRequestQueue=Volley.newRequestQueue(context.applicationContext)



     @Synchronized
     fun getInstance(context: Context):VollySinglton{
         if (mInstance==null){
             mInstance= VollySinglton(context)
         }
      return mInstance
     }

     fun getRequestQueue():RequestQueue{
         return mRequestQueue
     }*/

}


/*
* class VolleySingleton
*  private constructor(context:Context) {
  val requestQueue:RequestQueue
  init{
    requestQueue = Volley.newRequestQueue(context.getApplicationContext())
  }
  companion object {
    private val mInstance:VolleySingleton
    @Synchronized fun getInstance(context:Context):VolleySingleton {
      if (mInstance == null)
      {
        mInstance = VolleySingleton(context)
      }
      return mInstance
    }
  }
}*/