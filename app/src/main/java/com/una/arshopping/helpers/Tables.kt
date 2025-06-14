package com.una.arshopping.helpers

/**
 * static variables
 */
const val USERS_TABLE = "users"
const val THEME_TABLE = "theme"

/**
 * tables
 */
//user table
const val CREATE_USERS_TABLE =
    "CREATE TABLE $USERS_TABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, username TEXT  UNIQUE, avatar_url TEXT,isActive BOOLEAN);"
//theme table
const val CREATE_THEME_TABLE =
    "CREATE TABLE $THEME_TABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, theme INTEGER NOT NULL);"


/**
 * database name and version
 */
const val DATABASE_NAME = "project.db"
const val DATABASE_VERSION = 1

/***
 * query's user
 */
const val SELECT_ALL_USERS = "SELECT * FROM $USERS_TABLE"
const val INSERT_USER =
    "INSERT INTO $USERS_TABLE (id, email, username, avatar_url, isActive) VALUES (?, ?, ?, ?, ?)"
const val UPDATE_USER =
    "UPDATE $USERS_TABLE SET email = ?, username = ?, avatar_url = ?, isActive = ? WHERE id = ?"
const val DELETE_USER = "DELETE FROM $USERS_TABLE"

/***
 * query's theme
 */
const val SELECT_ALL_THEME = "SELECT * FROM $THEME_TABLE"
const val INSERT_THEME = "INSERT INTO $THEME_TABLE (theme) VALUES (?)"
const val UPDATE_THEME = "UPDATE $THEME_TABLE SET theme = ? WHERE id = ?"
const val DELETE_THEME = "DELETE FROM $THEME_TABLE"


