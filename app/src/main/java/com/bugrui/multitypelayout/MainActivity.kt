package com.bugrui.multitypelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            multiTypeLayout.showContent()
        }
        btn1.setOnClickListener {
            multiTypeLayout.showEmpty()
        }
        btn2.setOnClickListener {
            multiTypeLayout.showError()
        }
        btn3.setOnClickListener {
            multiTypeLayout.showLoading()
        }
        btn4.setOnClickListener {
            multiTypeLayout.showNoNetwork()
        }

        val newTextView: (t: String) -> TextView = { t: String ->
            TextView(this).apply {
                text = t
                gravity = Gravity.CENTER
            }
        }


        button.setOnClickListener {
            multiTypeLayout.setContentLayout(newTextView("setContentLayout"))
            multiTypeLayout.showContent()
        }
        button1.setOnClickListener {
            multiTypeLayout.setEmptyLayout(newTextView("setEmptyLayout"))
            multiTypeLayout.showEmpty()
        }
        button2.setOnClickListener {
            multiTypeLayout.setErrorLayout(newTextView("setErrorLayout"))
            multiTypeLayout.showError()
        }
        button3.setOnClickListener {
            multiTypeLayout.setLoadingLayout(newTextView("setLoadingLayout"))
            multiTypeLayout.showLoading()
        }
        button4.setOnClickListener {
            multiTypeLayout.setNoNetworkLayout(newTextView("setNoNetworkLayout"))
            multiTypeLayout.showNoNetwork()
        }


        button5.setOnClickListener {
            multiTypeLayout.setContentLayout(R.layout.layout_content)
            multiTypeLayout.showContent()
        }
        button6.setOnClickListener {
            multiTypeLayout.setEmptyLayout(R.layout.layout_empty)
            multiTypeLayout.showEmpty()
        }
        button7.setOnClickListener {
            multiTypeLayout.setErrorLayout(R.layout.layout_error)
            multiTypeLayout.showError()
        }
        button8.setOnClickListener {
            multiTypeLayout.setLoadingLayout(R.layout.layout_loading)
            multiTypeLayout.showLoading()
        }
        button9.setOnClickListener {
            multiTypeLayout.setNoNetworkLayout(R.layout.layout_no_network)
            multiTypeLayout.showNoNetwork()
        }
    }
}