package com.savaliscodes.crudwithroomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booksDB")
class BooksDB(@PrimaryKey
              val id: String,
              @ColumnInfo(name="author_name")
              val author: String,
              val bookName: String) {
}