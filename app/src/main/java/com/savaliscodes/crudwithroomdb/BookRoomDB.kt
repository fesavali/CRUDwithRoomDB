package com.savaliscodes.crudwithroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi



@Database(entities = [BooksDBTable::class], version = 1)
abstract class BookRoomDB : RoomDatabase() {

    abstract fun bookDao() : BooksDao


    companion object {
        private var bookRoomInstance: BookRoomDB? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): BookRoomDB?{
            if (bookRoomInstance == null){
                synchronized(BookRoomDB::class.java){
                    if (bookRoomInstance == null){
                        bookRoomInstance = Room.databaseBuilder<BookRoomDB>(
                                            context.applicationContext,
                                            BookRoomDB::class.java,
                                            "book_database")
                                            .build()
                    }
                }
            }
            return bookRoomInstance
        }
    }
}