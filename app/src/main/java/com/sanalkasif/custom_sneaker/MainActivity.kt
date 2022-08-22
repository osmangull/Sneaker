package com.sanalkasif.custom_sneaker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanalkasif.custom_sneaker.databinding.ActivityMainBinding
import com.sanalkasif.customsneaker.Sneaker
import com.sanalkasif.customsneaker.SneakerListener
import com.sanalkasif.customsneaker.SneakerType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.success.setOnClickListener {
            Log.v("sneaker","success")
            Sneaker.Builder()
                .setActivity(this) /* optionally, these -> .setFragment() .setViewGroup() */
                .setType(SneakerType.Success)
                .setTitle("Success")
                .setSneakerDuration(3000)
                .setContent("Your transaction was successful")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        Log.v("buttonClick","buttonClick")
                    }
                })
                .build()
        }
        binding.info.setOnClickListener {
            Log.v("sneaker","info")
            Sneaker.Builder()
                .setActivity(this)
                .setType(SneakerType.Info)
                .setTitle("Info")
                .setSneakerDuration(3000)
                .setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        Log.v("buttonClick","buttonClick")
                    }
                })
                .build()

        }
        binding.infoError.setOnClickListener {
            Log.v("sneaker","infoError")
            Sneaker.Builder()
                .setActivity(this)
                .setType(SneakerType.InfoError)
                .setTitle("InfoError")
                .setSneakerDuration(3000)
                .setContent("It has survived not only five")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        Log.v("buttonClick","buttonClick")
                    }
                })
                .build()
        }
        binding.warning.setOnClickListener {
            Log.v("sneaker","warning")
            Sneaker.Builder()
                .setActivity(this)
                .setType(SneakerType.Warning)
                .setTitle("Warning")
                .setSneakerDuration(3000)
                .setContent("Lorem Ipsum passages")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        Log.v("buttonClick","buttonClick")
                    }
                })
                .build()
        }
        binding.error.setOnClickListener {
            Log.v("sneaker","error")
            Sneaker.Builder()
                .setActivity(this)
                .setType(SneakerType.Error)
                .setTitle("Error")
                .setSneakerDuration(3000)
                .setContent("Your transaction could not be")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        Log.v("buttonClick","buttonClick")
                    }
                })
                .build()
        }



    }
}