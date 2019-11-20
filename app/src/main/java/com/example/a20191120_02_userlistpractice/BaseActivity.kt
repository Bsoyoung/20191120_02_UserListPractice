package com.example.a20191120_02_userlistpractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    var myCotext = this

    abstract fun setupEvents()
    abstract fun setValues()


}