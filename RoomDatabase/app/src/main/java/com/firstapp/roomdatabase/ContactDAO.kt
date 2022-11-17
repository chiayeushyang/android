package com.firstapp.roomdatabase

import android.database.Cursor
import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact :Contact)

    @Update
    fun updateContact(Contact :Contact)

    @Delete
    fun deleteContact(Contact: Contact?)

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : Cursor

    @Query("SELECT * FROM Contact WHERE _id = :id")
    fun getOneContact(id : Int) : Contact
}