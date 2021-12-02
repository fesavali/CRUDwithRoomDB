package com.room.savaliscodes.bookkeeper

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*


@Entity(tableName = "books")
class Book(@PrimaryKey
           val id: String,

           val author: String,

           val book: String,

           val description: String,

           @ColumnInfo(name = "last_updated")
           val lastUpdated: Date?)