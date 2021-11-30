package com.savaliscodes.crudwithroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_book)

        val save = findViewById<Button>(R.id.button)
        val author = findViewById<EditText>(R.id.author)
        val title = findViewById<EditText>(R.id.book_title)
    }
}