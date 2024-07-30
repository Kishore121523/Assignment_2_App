package com.example.assignment2_1217545

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ViewDetailsFragment : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var colorTextView: TextView
    private lateinit var genderTextView: TextView

    // Use the fragment_view_details.xml for the UI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView = view.findViewById(R.id.nameTextView)
        ageTextView = view.findViewById(R.id.ageTextView)
        colorTextView = view.findViewById(R.id.colorTextView)
        genderTextView = view.findViewById(R.id.genderTextView)
        loadUserDetails()
    }

    // Get the sent data named "userDetails" and display it
    private fun loadUserDetails() {
        val sharedPref = activity?.getSharedPreferences("userDetails", 0)
        val name = sharedPref?.getString("name", "No Name")
        val age = sharedPref?.getString("age", "No Age")
        val color = sharedPref?.getString("color", "No Color")
        val gender = sharedPref?.getString("gender", "No Gender")

        nameTextView.text = "Name: $name"
        ageTextView.text = "Age: $age"
        colorTextView.text = "Favorite Color: $color"
        genderTextView.text = "Gender: $gender"
    }
}
