package com.example.assignment2_1217545

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomSpinnerAdapter(context: Context, items: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items) {
    init {
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent) as TextView
        view.setTextColor(context.resources.getColor(R.color.accentColor))
        return view
    }

    // Setting the style for the dropdown of the spinner
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false) as TextView
        view.setBackgroundColor(context.resources.getColor(R.color.popupBg))
        view.setTextColor(context.resources.getColor(R.color.accentColor))
        view.text = getItem(position)
        return view
    }
}
