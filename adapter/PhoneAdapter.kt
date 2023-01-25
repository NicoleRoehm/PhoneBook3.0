package com.example.phone_book.adapter

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_book.R
import com.example.phone_book.data.model.Contacts
import com.example.phone_book.ui.DetailFragment
import com.example.phone_book.ui.DetailFragmentDirections
import com.example.phone_book.ui.HomeFragment
import com.example.phone_book.ui.HomeFragmentDirections



class PhoneAdapter(
    private val context: Context,
    private val dataset: List<Contacts>
) : RecyclerView.Adapter<PhoneAdapter.ViewHolder>() {




    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        // TODO Schreibe hier deinen Code

        val phoneContact = view.findViewById<TextView>(R.id.phone_name)
        val contactNumber = view.findViewById<TextView>(R.id.phone_number)

        val phoneIcon = view.findViewById<ImageView>(R.id.call_image)
        val phoneCard = view.findViewById<CardView>(R.id.phone_card)


    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // das itemLayout wird gebaut
        // TODO Schreibe hier deinen Code
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ViewHolder(adapterLayout)                     //TODO()
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO Schreibe hier deinen Code
        val phone = dataset[position]

        holder.phoneContact.text = phone.name
        holder.contactNumber.text = phone.number


        holder.phoneIcon.setOnClickListener {

            Toast.makeText(
                context,
                "${phone.name} wird angerufen",
                Toast.LENGTH_LONG
            )
                .show()
        }

            holder.phoneCard.setOnClickListener {
                holder.itemView.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(phone))
            }


    }
    /**
         * damit der LayoutManager weiß, wie lang die Liste ist
         */
        override fun getItemCount(): Int {
            return dataset.size       //TODO()
        }
}
