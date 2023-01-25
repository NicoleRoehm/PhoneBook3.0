package com.example.phone_book.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.phone_book.data.model.Contacts
import com.example.phone_book.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Todo Code

        val phone = requireArguments().getParcelable<Contacts>("contact",)

        binding.detailContactNameText.text = phone?.name
        binding.detailContactNumberText.text = phone?.number


        binding.detailPhoneImage.setOnClickListener{
            Toast.makeText(
                context,
                "${phone?.name} wird angerufen",
                Toast.LENGTH_LONG
            )
                .show()
        }
        binding.detailPhoneImage.setOnClickListener{

            val number = binding.detailContactNumberText.text.toString()

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.fromParts("tel", number,null)
            val shareIntent = Intent.createChooser(intent,"Telefon")
            startActivity(shareIntent)
        }

        binding.detailEditButton.setOnClickListener{
            binding.detailEditButton.findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToEditFragment())
        }


    }
}