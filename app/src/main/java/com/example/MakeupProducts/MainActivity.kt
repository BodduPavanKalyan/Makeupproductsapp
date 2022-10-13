package com.example.MakeupProducts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MakeupProducts.Adapter.GridAdapter
import com.example.MakeupProducts.databinding.ActivityMainBinding
import com.example.MakeupProducts.model.DataUsed

import com.example.MakeupProducts.viewModel.MakeUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

   val makeUpViewModel : MakeUpViewModel by viewModels()
    private lateinit var List : List<DataUsed>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
  //in viewModel we will observe the list of live data we are passing

        makeUpViewModel.responseData.observe(this,Observer{
            val data1 = it.toString()
            Log.d("tag", " data ???... .... ${it}")
         it.forEach {
             Log.d("tag", "indexof..${it.id} data is ... .... ${it.name}")
         }
            val adapter = GridAdapter(this,it)
            List = it

          //instead of normal layout we are presenting the grid layout here
         val gridLayout = GridLayoutManager(this,2)

            recyclerView.layoutManager = gridLayout
            recyclerView.adapter = adapter

            // when we click on an item it will take us to another view,
            // which have the description about that item

            adapter.setonItemClickListener(object : GridAdapter.onItemClickListener{
                override fun onClicked(position: Int) {
                    Toast.makeText(this@MainActivity,"Clicked On == ${position}",Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity,MainActivity2::class.java)
                    intent.putExtra("image",it[position].image_link)
                    intent.putExtra("decription",it[position].description)
                    startActivity(intent)
                }

            })
     })


    }


}


