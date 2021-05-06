package com.muklasr.edittextinrecyclerviewsandbox

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.muklasr.edittextinrecyclerviewsandbox.adapter.FoodAdapter
import com.muklasr.edittextinrecyclerviewsandbox.databinding.ActivityMainBinding
import com.muklasr.edittextinrecyclerviewsandbox.model.FoodMenu

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val foodList = ArrayList<FoodMenu>()
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setAdapter()
        setListener()

    }

    private fun setListener() {
        binding.fab.setOnClickListener(this)
        binding.content.btnSubmit.setOnClickListener(this)
    }

    private fun setAdapter() {
        foodAdapter = FoodAdapter(foodList)
        binding.content.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = foodAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(
                    Intent(this, MultitypeInputActivity::class.java)
                )
                true
            }
            else
            -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab -> {
                foodList.add(FoodMenu())
                foodAdapter.notifyItemInserted(foodList.size - 1)
            }
            R.id.btnSubmit -> {
                foodList.forEach {
                    Log.d("HASIL", "Name: ${it.name} - Price: ${it.price}")
                }
            }
        }
    }
}