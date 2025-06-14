package com.una.arshopping.repository

import android.content.Context
import android.util.Log
import com.una.arshopping.helpers.DELETE_THEME
import com.una.arshopping.helpers.INSERT_THEME
import com.una.arshopping.helpers.LocalDataBaseHelper
import com.una.arshopping.helpers.SELECT_ALL_THEME
import com.una.arshopping.helpers.UPDATE_THEME

/**
 * the default theme is 0 = non exist
 */
fun gelAllTheme(context: Context): Int {
    Log.d("DB_SELECT_THEME", "Fetching all theme...")
    var theme = 0
    val db = LocalDataBaseHelper(context).readableDatabase
    val cursor = db.rawQuery(SELECT_ALL_THEME, null)
    Log.d("DB_SELECT_THEME", "Query executed: $SELECT_ALL_THEME")

    if (cursor.moveToFirst()) {
        theme = cursor.getInt(cursor.getColumnIndexOrThrow("theme"))
        Log.d("DB_SELECT_THEME", "Theme found: $theme")
        Log.d("DB_SELECT_THEME", "Theme: $theme")
    } else {
        Log.d("DB_SELECT_THEME", "No Theme found.")
    }

    cursor.close()
    db.close()
    Log.d("DB_SELECT_THEME", "Cursor and database closed")
    return theme
}

fun insertTheme(context: Context, theme: Int) {
    Log.d("DB_INSERT_THEME", "Attempting to insert theme: $theme")
    val db = LocalDataBaseHelper(context).writableDatabase
    try {
        val stmt = db.compileStatement(INSERT_THEME)
        Log.d("DB_INSERT_THEME", "Prepared statement: $INSERT_THEME")
        stmt.bindLong(1, theme.toLong())
        stmt.executeInsert()
        Log.d("DB_INSERT_THEME", "Theme inserted successfully: $theme")
    } catch (e: Exception) {
        Log.e("DB_INSERT_THEME", "Error inserting theme", e)
    } finally {
        db.close()
        Log.d("DB_INSERT_THEME", "Database closed")
    }
}

fun updateTheme(context: Context, theme: Int) {
    Log.d("DB_UPDATE_THEME", "Attempting to update theme: $theme")
    val db = LocalDataBaseHelper(context).writableDatabase

    try {
        val stmt = db.compileStatement(UPDATE_THEME)
        Log.d("DB_UPDATE_THEME", "Prepared statement: $UPDATE_THEME")
        stmt.bindLong(1, theme.toLong())
        stmt.bindLong(2, 1)
        stmt.executeUpdateDelete()
        Log.d("DB_UPDATE_THEME", "Theme updated successfully: $theme")
    } catch (e: Exception) {
        Log.e("DB_UPDATE_THEME", "Error updating theme", e)
    } finally {
        db.close()
        Log.d("DB_UPDATE_THEME", "Database closed")
    }

}

fun deleteTheme(context: Context) {
    Log.d("DB_DELETE_THEME", "Attempting to delete theme")
    val db = LocalDataBaseHelper(context).writableDatabase

    try {
        val stmt = db.compileStatement(DELETE_THEME)
        Log.d("DB_DELETE", "Prepared statement: $DELETE_THEME")
        stmt.executeInsert()
        Log.d("DB_DELETE", "Theme deleted successfully")
    } catch (e: Exception) {
        Log.e("DB_DELETE", "Error deleting theme", e)
    } finally {
        db.close()
        Log.d("DB_DELETE", "Database closed")
    }
}