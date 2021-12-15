package com.nadikarim.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.nadikarim.myintentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult ()
    ) {result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvResult.text = "Hasil = $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveActivity.setOnClickListener {
            val intent = Intent(this, MoveActivity::class.java)
            startActivity(intent)
        }

        binding.btnMoveActivityData.setOnClickListener {
            val intent = Intent(this, MoveActivityWithData::class.java)
            intent.putExtra(MoveActivityWithData.EXTRA_NAME, "Dicoding Boy")
            intent.putExtra(MoveActivityWithData.EXTR_AGE, 10)
            startActivity(intent)
        }

        binding.btnMoveActivityObject.setOnClickListener {
            val person = Person(
                "Dicoding Boy",
                10,
                "dicodingboy@dicoding.com",
                "Jakarta"
            )
            val intent = Intent(this, MoveWithObjectActivity::class.java)
            intent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(intent)
        }

        binding.btnDialNumber. setOnClickListener {
            val phoneNumber = "085717847783"
            val dialPhoneNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneNumber)
        }

        binding.btnOpenCalculator.setOnClickListener {
            val openCalculator = Intent()
            openCalculator.action = Intent.ACTION_MAIN
            openCalculator.addCategory(Intent.CATEGORY_APP_CALCULATOR)
            startActivity(openCalculator)
        }

        binding.btnMoveWithResult.setOnClickListener {
            val intent = Intent(this, MoveForResultActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}