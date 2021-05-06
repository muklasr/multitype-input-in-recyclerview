package com.muklasr.edittextinrecyclerviewsandbox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muklasr.edittextinrecyclerviewsandbox.databinding.ItemVariableBinding
import com.muklasr.edittextinrecyclerviewsandbox.model.Variable

class VariableAdapter(private val variableList: ArrayList<Variable>) :
    RecyclerView.Adapter<VariableAdapter.VariableViewHolder>() {

    private val TYPE_INPUT_TEXT = "1"
    private val TYPE_INPUT_CHECKBOX = "2"


    inner class VariableViewHolder(private val binding: ItemVariableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(variable: Variable) {
            binding.variable = variable

            when (variable.input_type) {
                TYPE_INPUT_TEXT -> {
                    binding.etValue.setText(variable.value)
                    binding.tvUnit.text = variable.unit
                    binding.checkbox.visibility = View.INVISIBLE
                }
                TYPE_INPUT_CHECKBOX -> {
                    binding.checkbox.isChecked = variable.value == "1"
                    binding.etValue.visibility = View.INVISIBLE
                    binding.tvUnit.visibility = View.INVISIBLE
                }
            }

            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) variable.value = "1"
                else variable.value = "0"
                binding.variable = variable
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariableViewHolder =
        VariableViewHolder(
            ItemVariableBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VariableViewHolder, position: Int) {
        holder.bind(variable = variableList[position])
    }

    override fun getItemCount(): Int = variableList.size
}