package com.example.phone_book.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phone_book.MainActivity
import com.example.phone_book.adapter.PhoneAdapter
import com.example.phone_book.data.Datasource
import com.example.phone_book.data.model.Contacts
import com.example.phone_book.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val main = activity as MainActivity
        val phoneList = main.contacts
        val phoneAdapter = PhoneAdapter(requireContext(), phoneList)
        //Todo bei Fragmenten(nicht "this" benutzen sondern"requireContext()")
        binding.homeRecyclerview.adapter = phoneAdapter



        binding.homeAddButton.setOnClickListener {

            val name =binding.homeEditNameText.text.toString()
            val number = binding.homeEditNumberText.text.toString()

            if (name != "" && number != ""){
                val position = phoneList.size
                phoneList.add(position, Contacts(name,number))
                phoneAdapter.notifyItemInserted(position)
                binding.homeEditNameText.setText("")
                binding.homeEditNumberText.setText("")





            }



        }


    }
}







