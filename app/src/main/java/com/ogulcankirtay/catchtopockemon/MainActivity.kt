package com.ogulcankirtay.catchtopockemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ogulcankirtay.catchtopockemon.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var imageArray= ArrayList<View>()
    var scor=0
    var runnable=Runnable{}
    var handler=Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //add imageview
        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)

        hideImages()

        object : CountDownTimer(15000,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text="Time: "+p0/1000
            }

            override fun onFinish() {
                binding.timeText.text="Time: 0"
                handler.removeCallbacks(runnable)
                for(i in imageArray){
                    i.visibility=View.INVISIBLE
                }
                var alert=AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Game Over")
                alert.setMessage("Restar The Game?")
                alert.setPositiveButton("Yes"){dialog,which->
                    var intent=intent
                    finish()
                    startActivity(intent)


                }
                alert.setNegativeButton("No"){dialog,which->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }
        }.start()
    }

    fun touch(view: View) {
        scor+=1
        binding.scorText.text="Scor: "+scor
    }
    fun hideImages(){
      runnable=  object : Runnable{
          override fun run() {
              for(i in imageArray){
                  i.visibility=View.INVISIBLE
              }
              var random=Random()
              var ri=random.nextInt(15)
              imageArray[ri].visibility=View.VISIBLE
              handler.postDelayed(runnable,700)
          }

      }
        handler.post(runnable)

    }

}