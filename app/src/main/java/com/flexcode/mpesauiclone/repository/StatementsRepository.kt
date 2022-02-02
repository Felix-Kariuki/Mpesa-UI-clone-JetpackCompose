package com.flexcode.mpesauiclone.repository

import android.app.Person
import com.flexcode.mpesauiclone.models.StatementItem

class StatementsRepository {
    fun getAllData(): List<StatementItem> {
        return listOf(

            StatementItem(
                id = 0,
                fullName = "John Doe",
                phone = "254789***123",
                amount = "-KSH 700.00",
                date = "31 Jan, 02:59PM",
                initials = "JD"
            ),
            StatementItem(
                id = 1,
                fullName = "Uncle Bob",
                phone = "254789***123",
                amount = "+KSH 500.00",
                date = "31 Jan, 02:59PM",
                initials = "UB"
            ),
            StatementItem(
                id = 2,
                fullName = "Safaricom  Zuri",
                phone = "254789***123",
                amount = "-KSH 700.00",
                date = "31 Jan, 02:59PM",
                initials = "SZ"
            ),
            StatementItem(
                id = 3,
                fullName = "Albert Einsten",
                phone = "254789***123",
                amount = "+KSH 100.00",
                date = "31 Jan, 02:59PM",
                initials = "AE"
            ),
            StatementItem(
                id = 4,
                fullName = "Nikola Tesla",
                phone = "254789***123",
                amount = "+KSH 70.00",
                date = "31 Jan, 02:59PM",
                initials = "NT"
            ),
        )
    }
}