package com.nadikarim.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nadikarim.myintentapp.databinding.ActivityMoveWithDataBinding

class MoveActivityWithData : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTR_AGE = "extra_age"
    }

    private lateinit var binding: ActivityMoveWithDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTR_AGE, 0)
        val text = "Hi, i'm $name, my age is $age"

        binding.tvDataReceived.text = text
    }
}