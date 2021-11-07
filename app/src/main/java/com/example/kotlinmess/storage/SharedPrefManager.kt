package com.example.kotlinmess.storage

import android.content.Context
import com.example.kotlinmess.model.UserModel

class SharedPrefManager private constructor(private val mCtx:Context){

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getString("name", null) != null
        }

    val user: UserModel
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return UserModel(
                sharedPreferences.getString("name", null)!!,
                sharedPreferences.getString("phone", null)!!,
                sharedPreferences.getString("password", null)!!,
                sharedPreferences.getString("email", null)!!
            )
        }


    fun saveUser(user: UserModel) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("name", user.name)
        editor.putString("phone", user.phone)
        editor.putString("password", user.password)
        editor.putString("email", user.email)

        editor.apply()

    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }
}