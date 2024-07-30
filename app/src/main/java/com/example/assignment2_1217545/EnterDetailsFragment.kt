package com.example.assignment2_1217545

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class EnterDetailsFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var colorSpinner: Spinner
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var submitButton: Button

    // Use the fragment_enter_details.xml for the UI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.nameEditText)
        ageEditText = view.findViewById(R.id.ageEditText)
        colorSpinner = view.findViewById(R.id.colorSpinner)
        genderRadioGroup = view.findViewById(R.id.genderRadioGroup)
        submitButton = view.findViewById(R.id.submitButton)

        val colors = resources.getStringArray(R.array.colors_array).toList()
        val adapter = CustomSpinnerAdapter(requireContext(), colors)
        colorSpinner.adapter = adapter

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val color = colorSpinner.selectedItem.toString()
            val gender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.radioMale -> "Male"
                R.id.radioFemale -> "Female"
                else -> ""
            }

            if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                (activity as MainActivity).showDialog("Enter all details to save")
            } else {
                saveUserDetails(name, age, color, gender)
                (activity as MainActivity).showDialog("Click menu to see details")
            }
        }
    }

    // Send the data entered through the putString
    private fun saveUserDetails(name: String, age: String, color: String, gender: String) {
        val sharedPref = activity?.getSharedPreferences("userDetails", 0)
        with (sharedPref?.edit()) {
            this?.putString("name", name)
            this?.putString("age", age)
            this?.putString("color", color)
            this?.putString("gender", gender)
            this?.apply()
        }
    }
}
