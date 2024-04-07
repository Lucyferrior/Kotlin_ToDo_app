package com.sefakose.kotlintodoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sefakose.kotlintodoapp.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {
    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var adapter: ToDoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemList = arrayListOf<Item>(
            Item("Pazara git", "Deneme amaçlı bir item",false)
        )
        adapter = ToDoAdapter(itemList)

        binding.rvTodoList.adapter = adapter
        binding.btnAdd.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val description = binding.edtDescription.text.toString()

            if(title.isBlank() || description.isBlank()) //toString methdoları null döndürmez
            {
                Toast.makeText(context,"Fill all the blanks",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            itemList.add(Item(title,description,false))
            adapter.notifyItemInserted(itemList.size-1)
            binding.edtTitle.text.clear()
            binding.edtDescription.text.clear()
        }
    }
}