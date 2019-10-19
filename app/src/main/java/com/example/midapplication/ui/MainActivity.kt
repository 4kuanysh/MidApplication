package com.example.midapplication.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midapplication.R
import com.example.midapplication.data.entities.Result
import com.example.midapplication.ui.adapters.recyclerview.RvAdapter
import com.example.midapplication.data.entities.fact.FactViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    private val rFactViewModel: FactViewModel by viewModel(named("RemoteFactViewModel"))
    private val lFactViewModel: FactViewModel by viewModel(named("LocalFactViewModel"))
    private val rvAdapter by lazy { RvAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        initRecyclerView()

        rFactViewModel.factLiveData.observe(this, Observer {
            when (it) {
                is Result.Success -> {
                    Toast.makeText(this, "From remote", Toast.LENGTH_LONG).show()
                    lFactViewModel.insertFacts(it.data)
                    rvAdapter.setFacts(it.data)
                }
                is Result.Error -> {
                    lFactViewModel.factLiveData.observe(this, Observer { lData->
                        when(lData){
                            is Result.Success -> {
                                Toast.makeText(this, "From local", Toast.LENGTH_LONG).show()
                                rvAdapter.setFacts(lData.data)
                            }
                            is Result.Error -> {
                                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                            }
                        }
                    })
                    lFactViewModel.loadFacts()
                }
            }
        })
        rFactViewModel.loadFacts()
    }

    private fun initRecyclerView() {
        rv_facts.layoutManager = LinearLayoutManager(this)
        rv_facts.adapter = rvAdapter
    }
}
