package com.savaliscodes.crudwithroomdb

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BooksDao {
    @Insert
    fun insert(booksDB: BooksDB){

    }
}