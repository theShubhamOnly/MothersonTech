package com.example.mothersontech

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mothersontech.Adapter.DataListAdapter
import com.example.mothersontech.Utils.CommonUtils
import com.example.mothersontech.ViewModel.DataViewModel
import com.example.mothersontech.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var bindingMain : ActivityMainBinding? = null

    val dataViewModel:DataViewModel by viewModels<DataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain!!.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()

        doRequest ()
    }

    private fun doRequest() {
        try {

            if (CommonUtils.checkIsNetworkAvailable(this)) {
                CommonUtils.showProgress(this)
                dataViewModel.getViewModelInformation()

                if (  bindingMain!!.recyclerViewInformation.adapter != null)
                    bindingMain!!.recyclerViewInformation.adapter = null

                dataViewModel.dataList.observe(this , Observer {
                    bindingMain!!.recyclerViewInformation.adapter = DataListAdapter(it.body()!!)

                    CommonUtils.hideProgress()
                })
            } else {
                CommonUtils.showToast(getString(R.string.no_internet_connection),this)
            }



        } catch (e : Exception) {
            e.stackTrace
        }
    }
}