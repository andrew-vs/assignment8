package edu.temple.superbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Ensure browser page isn't added twice
        if (supportFragmentManager.findFragmentById(R.id.page_viewer) !is PageViewerFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.page_viewer, PageViewerFragment())
                .commit()
    }
}