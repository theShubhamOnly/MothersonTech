package com.example.mothersontech.Utils

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.mothersontech.R

class CommonUtils {

    companion object {

        var progressBar : ProgressDialog? = null

        @RequiresApi(Build.VERSION_CODES.M)
        fun checkIsNetworkAvailable (context : Context )  : Boolean {

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
            return false
        }

        fun showToast (value : String?,context: Context) {
            Toast.makeText(context,value,Toast.LENGTH_LONG).show()
        }

        fun showProgress (context: Context) {
            if (progressBar == null)
                progressBar = ProgressDialog(context)

            if (!progressBar!!.isShowing) {
                progressBar!!.setCancelable(false)
                progressBar!!.setTitle(context.getString(R.string.please_wait))
                progressBar!!.show()
            }
        }

        fun hideProgress () {
            if (progressBar != null && progressBar!!.isShowing) {
                progressBar!!.dismiss()
                progressBar = null
            }

        }



    }
}