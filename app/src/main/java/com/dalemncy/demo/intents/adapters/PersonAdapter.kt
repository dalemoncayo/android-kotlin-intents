package com.dalemncy.demo.intents.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalemncy.demo.intents.ProfileActivity
import com.dalemncy.demo.intents.constants.Constants
import com.dalemncy.demo.intents.databinding.ItemPersonBinding
import com.dalemncy.demo.intents.models.Person

class PersonAdapter(
    private val activity: Activity,
    private val persons: MutableList<Person>
): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(
        private val activity: Activity,
        private val binding: ItemPersonBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            val title = "[${person.id}] ${person.name}"
            binding.name.text = title
            binding.email.text = person.email
            binding.row.setOnClickListener {

                // Declaring Intent.
                val intent = Intent(
                    activity, // Context of the Current Activity.
                    ProfileActivity::class.java // Activity that we want to open.
                )

                // Adding Int type parameter from current Activity to ProfileActivity.
                intent.putExtra(Constants.PARAM_ID, person.id)

                // Adding String type parameter from current Activity to ProfileActivity.
                intent.putExtra(Constants.PARAM_NAME, person.name)
                intent.putExtra(Constants.PARAM_EMAIL, person.email)

                // Open the ProfileActivity.
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonViewHolder(activity, binding)
    }

    override fun getItemCount() = persons.size

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position: Int
    ) {
        holder.bind(persons[position])
    }
}