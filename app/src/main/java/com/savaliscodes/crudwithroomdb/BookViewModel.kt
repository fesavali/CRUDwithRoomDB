package com.savaliscodes.crudwithroomdb

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import com.savaliscodes.crudwithroomdb.BooksDao as BooksDao1

abstract class BookViewModel(application: Application): AndroidViewModel(application) {
    abstract var booksDao: BooksDao1
    init {
        val bookDN = BookRoomDB.getDatabase(application)
        booksDao = bookDN!!.bookDao()
    }
    fun insert(book: BooksDBTable){
        InsertAsyncTask(booksDao).execute(book)
    }

    companion object {
        private class InsertAsyncTask(private val booksDao: com.savaliscodes.crudwithroomdb.BooksDao)
            : AsyncTask<BooksDBTable, Void, Void>() {
            override fun doInBackground(vararg books: BooksDBTable?): Void? {
                books[0]?.let { booksDao.insert(it) }
                return null
            }
        }
    }
}