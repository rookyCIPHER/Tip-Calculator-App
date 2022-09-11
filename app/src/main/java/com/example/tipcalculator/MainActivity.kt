package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if(cost1!=null){

//        }


        binding.calculate.setOnClickListener {
            val cost1=binding.costOfService.text?.toString()

            if(!cost1.isNullOrEmpty()){
                val cost= cost1.toDouble()

                val tip = Calculate_Tip(cost)
                Toast.makeText(this, "${tip}", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "please enter the price", Toast.LENGTH_SHORT).show()
            }
            }

    }

    private fun Calculate_Tip(cost: Double): Any {
        val percentage = when(binding.ServiceOptions.checkedRadioButtonId){
            R.id.Amazing -> 0.2
            R.id.Good -> 0.15
            else -> 0.10
        }

        return if(binding.roundupSwitch.isChecked){
            val calc_tip_rounded = kotlin.math.ceil(cost*percentage)
            calc_tip_rounded
        } else {
            val calc_tip = cost * percentage
            calc_tip
        }

    }
}

