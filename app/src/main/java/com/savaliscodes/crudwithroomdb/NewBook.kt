package com.savaliscodes.crudwithroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.util.*
import java.util.EnumSet.of

class NewBook : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_book)

        val save = findViewById<Button>(R.id.button)
        val author = findViewById<EditText>(R.id.author)
        val title = findViewById<EditText>(R.id.book_title)
        save.setOnClickListener {
            val new_author = author.text.toString().trim()
            val new_book = title.text.toString().trim()

            if(new_author.isEmpty()){
                author.setError("Author name is Required ")
                author.requestFocus()
                return@setOnClickListener
            }
            if(new_book.isEmpty()){
                title.setError("Book Title is Required")
                title.requestFocus()
                return@setOnClickListener
            }
            val id = UUID.randomUUID().toString()
            val book = BooksDBTable(id,new_author,new_book)
            bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

            bookViewModel.insert(book)

            Toast.makeText(this, "Book Saved Successfully", Toast.LENGTH_SHORT).show()
        }

    }

}