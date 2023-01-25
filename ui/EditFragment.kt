package com.example.phone_book.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.phone_book.MainActivity
import com.example.phone_book.adapter.PhoneAdapter
import com.example.phone_book.data.model.Contacts
import com.example.phone_book.databinding.FragmentEditBinding


class EditFragment: Fragment() {

    private lateinit var binding:FragmentEditBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val main = activity as MainActivity
        val phoneList = main.contacts
        val phoneAdapter = PhoneAdapter(requireContext(), phoneList)

        binding.editFragmentButton.setOnClickListener{

            val name =binding.editFragmentName.text.toString()
            val number = binding.editFragmentNumber.text.toString()

            if (name != "" && number != ""){
                val position = phoneList.size
                phoneList.add(position, Contacts(name, number))
                binding.editFragmentName.setText("")
                binding.editFragmentNumber.setText("")
                phoneAdapter.notifyItemInserted(position)

                binding.editFragmentButton.setOnClickListener{

                    binding.editFragmentButton.findNavController()
                        .navigate(EditFragmentDirections
                            .actionEditFragmentToDetailFragment2(Contacts(name,number)))


                }

            }


        }

    }
}