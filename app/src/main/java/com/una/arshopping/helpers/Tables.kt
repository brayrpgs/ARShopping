package com.una.arshopping.helpers

/**
 * static variables
 */
const val USERS_TABLE = "users"
const val CREATE_USERS_TABLE = "CREATE TABLE $USERS_TABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, username TEXT  UNIQUE, avatar_url TEXT, first_name TEXT , last_name TEXT );"
const val DATABASE_NAME = "project.db"
const val DATABASE_VERSION = 1

/***
 * query's and
 */
const val SELECT_ALL_USERS = "SELECT * FROM $USERS_TABLE"
const val INSERT_USER = "INSERT INTO $USERS_TABLE (id, email, username, avatar_url, first_name, last_name) VALUES (?, ?, ?, ?, ?, ?)"
const val UPDATE_USER = "UPDATE $USERS_TABLE SET email = ?, username = ?, avatar_url = ?, first_name = ?, last_name = ? WHERE id = ?"
const val DELETE_USER = "DELETE FROM $USERS_TABLE WHERE id = ?"

