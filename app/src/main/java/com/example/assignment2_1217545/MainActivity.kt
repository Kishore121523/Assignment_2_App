package com.example.assignment2_1217545

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the action bar as toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set the three icon dots color
        val overflowIcon = toolbar.overflowIcon
        overflowIcon?.setColorFilter(ContextCompat.getColor(this, R.color.accentColor), PorterDuff.Mode.SRC_ATOP)
    }

    // Menu in the toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // When one of the action is selected (enter details or view details), pass the respective fragment to the handler function
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_enter_details -> {
                showFragment(EnterDetailsFragment())
                true
            }
            R.id.action_view_details -> {
                showFragment(ViewDetailsFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Take the FrameLayout by its ID and dynamically replace the selected actions
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    // The Dialog fragment
    fun showDialog(message: String) {
        val dialogFragment: DialogFragment = MyDialogFragment.newInstance(message)
        dialogFragment.show(supportFragmentManager, "MyDialogFragment")
    }
}
