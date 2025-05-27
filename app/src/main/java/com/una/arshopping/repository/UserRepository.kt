package com.una.arshopping.repository

import android.content.Context
import android.util.Log
import com.una.arshopping.helpers.*
import com.una.arshopping.model.User

fun insert(context: Context, user: User?) {
    Log.d("DB_INSERT", "Attempting to insert user: $user")

    if (user == null) {
        Log.e("DB_INSERT", "User is null. Aborting operation.")
        return
    }

    val dbHelper = LocalDataBaseHelper(context)
    val db = dbHelper.writableDatabase

    try {
        val stmt = db.compileStatement(INSERT_USER)
        Log.d("DB_INSERT", "Prepared statement: $INSERT_USER")

        stmt.bindLong(1, user.id!!.toLong())
        stmt.bindString(2, user.email)
        stmt.bindString(3, user.username)
        if (user.avatarUrl != null) {
            stmt.bindString(4, user.avatarUrl)
        } else {
            stmt.bindNull(4)
        }
        stmt.bindString(5, user.firstName)
        stmt.bindString(6, user.lastName)

        stmt.executeInsert()
        Log.d("DB_INSERT", "User inserted successfully: $user")
    } catch (e: Exception) {
        Log.e("DB_INSERT", "Error inserting user", e)
    } finally {
        db.close()
        Log.d("DB_INSERT", "Database closed")
    }
}

fun getAllUsers(context: Context): List<User> {
    Log.d("DB_SELECT", "Fetching all users...")

    val users = mutableListOf<User>()
    val db = LocalDataBaseHelper(context).readableDatabase
    val cursor = db.rawQuery(SELECT_ALL_USERS, null)
    Log.d("DB_SELECT", "Query executed: $SELECT_ALL_USERS")

    if (cursor.moveToFirst()) {
        Log.d("DB_SELECT", "Users found:")
        do {
            val user = User(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                email = cursor.getString(cursor.getColumnIndexOrThrow("email")),
                username = cursor.getString(cursor.getColumnIndexOrThrow("username")),
                avatarUrl = cursor.getString(cursor.getColumnIndexOrThrow("avatar_url")),
                firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name")),
                lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"))
            )
            Log.d("DB_SELECT", user.toString())
            users.add(user)
        } while (cursor.moveToNext())
    } else {
        Log.d("DB_SELECT", "No users found.")
    }

    cursor.close()
    db.close()
    Log.d("DB_SELECT", "Cursor and database closed")
    return users
}

fun updateUser(context: Context, user: User) {
    Log.d("DB_UPDATE", "Attempting to update user: $user")

    if (user.id == null) {
        Log.e("DB_UPDATE", "User ID is null. Cannot update.")
        return
    }

    val db = LocalDataBaseHelper(context).writableDatabase
    try {
        val stmt = db.compileStatement(UPDATE_USER)
        Log.d("DB_UPDATE", "Prepared statement: $UPDATE_USER")

        stmt.bindString(1, user.email)
        stmt.bindString(2, user.username)
        if (user.avatarUrl != null)
            stmt.bindString(3, user.avatarUrl)
        else
            stmt.bindNull(3)
        stmt.bindString(4, user.firstName)
        stmt.bindString(5, user.lastName)
        stmt.bindLong(6, user.id.toLong())

        val rowsAffected = stmt.executeUpdateDelete()
        Log.d("DB_UPDATE", "User updated. Rows affected: $rowsAffected")
    } catch (e: Exception) {
        Log.e("DB_UPDATE", "Error updating user", e)
    } finally {
        db.close()
        Log.d("DB_UPDATE", "Database closed")
    }
}

fun deleteUserById(context: Context, userId: Int) {
    Log.d("DB_DELETE", "Attempting to delete user with ID: $userId")

    val db = LocalDataBaseHelper(context).writableDatabase
    try {
        val stmt = db.compileStatement(DELETE_USER)
        Log.d("DB_DELETE", "Prepared statement: $DELETE_USER")
        stmt.bindLong(1, userId.toLong())
        val rowsAffected = stmt.executeUpdateDelete()
        Log.d("DB_DELETE", "User deleted. Rows affected: $rowsAffected")
    } catch (e: Exception) {
        Log.e("DB_DELETE", "Error deleting user", e)
    } finally {
        db.close()
        Log.d("DB_DELETE", "Database closed")
    }
}

fun getUserById(context: Context, userId: Int): User? {
    Log.d("DB_GET_USER", "Fetching user with ID: $userId")

    val db = LocalDataBaseHelper(context).readableDatabase
    val cursor = db.rawQuery("SELECT * FROM $USERS_TABLE WHERE id = ?", arrayOf(userId.toString()))
    Log.d("DB_GET_USER", "Query executed: SELECT * FROM $USERS_TABLE WHERE id = $userId")

    var user: User? = null
    if (cursor.moveToFirst()) {
        user = User(
            id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
            email = cursor.getString(cursor.getColumnIndexOrThrow("email")),
            username = cursor.getString(cursor.getColumnIndexOrThrow("username")),
            avatarUrl = cursor.getString(cursor.getColumnIndexOrThrow("avatar_url")),
            firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name")),
            lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"))
        )
        Log.d("DB_GET_USER", "User found: $user")
    } else {
        Log.d("DB_GET_USER", "No user found with that ID.")
    }

    cursor.close()
    db.close()
    Log.d("DB_GET_USER", "Cursor and database closed")

    return user
}
