package com.flexcode.mpesauiclone.models

data class StatementItem(
    val id: Int,
    val fullName: String,
    val phone: String,
    val amount: String,
    val initials: String,
    val date: String
)