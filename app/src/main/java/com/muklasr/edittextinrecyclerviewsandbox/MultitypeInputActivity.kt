package com.muklasr.edittextinrecyclerviewsandbox

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.muklasr.edittextinrecyclerviewsandbox.adapter.CategoryAdapter
import com.muklasr.edittextinrecyclerviewsandbox.databinding.ActivityMultitypeInputBinding
import com.muklasr.edittextinrecyclerviewsandbox.model.Category
import com.muklasr.edittextinrecyclerviewsandbox.model.Variable

class MultitypeInputActivity : AppCompatActivity(), View.OnClickListener {

    private val TEXT = "1"
    private val CHECKBOX = "2"

    private val variableList = ArrayList<Variable>()
    private val categoryList = ArrayList<Category>()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var binding: ActivityMultitypeInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multitype_input)

        generateDummyData()
        setAdapter()
        setListener()

    }

    private fun generateDummyData() {
        categoryList.add(Category(id = "1", name = "Category A"))
        categoryList.add(Category(id = "2", name = "Category B"))
        categoryList.add(Category(id = "3", name = "Category C"))
        categoryList.add(Category(id = "4", name = "Category D"))

        variableList.add(Variable(id="1", name="Variable A", input_type = TEXT, value="1", unit="m", categoryId = "1"))
        variableList.add(Variable(id="2", name="Variable B", input_type = TEXT, value="2", unit="cm", categoryId = "1"))
        variableList.add(Variable(id="3", name="Variable C", input_type = TEXT, value="3", unit="kg", categoryId = "1"))
        variableList.add(Variable(id="4", name="Variable D", input_type = TEXT, value="4", unit="mm", categoryId = "1"))
        variableList.add(Variable(id="5", name="Variable E", input_type = TEXT, value="5", unit="l", categoryId = "1"))
        variableList.add(Variable(id="6", name="Variable F", input_type = TEXT, value="6", unit="inch", categoryId = "1"))

        variableList.add(Variable(id="7", name="Variable G", input_type = CHECKBOX, value="0", unit="", categoryId = "2"))
        variableList.add(Variable(id="8", name="Variable H", input_type = CHECKBOX, value="0", unit="", categoryId = "2"))
        variableList.add(Variable(id="9", name="Variable I", input_type = CHECKBOX, value="0", unit="", categoryId = "2"))
        variableList.add(Variable(id="10", name="Variable J", input_type = CHECKBOX, value="0", unit="", categoryId = "2"))

        variableList.add(Variable(id="11", name="Variable K", input_type = CHECKBOX, value="0", unit="", categoryId = "3"))
        variableList.add(Variable(id="12", name="Variable L", input_type = CHECKBOX, value="0", unit="", categoryId = "3"))

        variableList.add(Variable(id="13", name="Variable M", input_type = CHECKBOX, value="0", unit="", categoryId = "4"))
        variableList.add(Variable(id="14", name="Variable N", input_type = CHECKBOX, value="0", unit="", categoryId = "4"))
        variableList.add(Variable(id="15", name="Variable O", input_type = CHECKBOX, value="0", unit="", categoryId = "4"))
        variableList.add(Variable(id="16", name="Variable P", input_type = CHECKBOX, value="0", unit="", categoryId = "4"))
    }

    private fun setListener() {
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setAdapter() {
        categoryAdapter = CategoryAdapter(categoryList, variableList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MultitypeInputActivity)
            adapter = categoryAdapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab -> {
                categoryList.add(Category())
                categoryAdapter.notifyItemInserted(categoryList.size - 1)
            }
            R.id.btnSubmit -> {
                variableList.forEach {
                    Log.d("HASIL", "Name: ${it.name} - Value: ${it.value}")
                }
            }
        }
    }
}