package transaction.service.repository

import java.util.ArrayList

import java.sql.SQLException
import java.sql.Statement
import java.sql.ResultSet

import transaction.service.Database

import transaction.service.model.TransactionModel
import transaction.service.model.UserModel

object TransactionRepository {
    @Throws(SQLException::class)
    fun all(): ArrayList<TransactionModel> {
        val stmt = Database.getConnection()!!.createStatement()
        val query = "SELECT t.number as number, t.total as total, u.id as user_id, u.email as email, u.name as name  FROM transactions t JOIN users u ON t.user_id=u.id"
        val rs = stmt.executeQuery(query)

        val transactions = ArrayList<TransactionModel>()
        while (rs.next()) {
            transactions.add(TransactionModel(rs.getInt("number"), rs.getFloat("total"), UserModel(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"))))
        }

        return transactions
    }

    @Throws(SQLException::class)
    fun findByNumber(number: Int): ArrayList<TransactionModel> {
        val stmt = Database.getConnection()!!.createStatement()
        val query = "SELECT t.number as number, t.total as total, u.id as user_id, u.email as email, u.name as name  FROM transactions t JOIN users u ON t.user_id=u.id WHERE t.number=$number"
        val rs = stmt.executeQuery(query)

        val transactions = ArrayList<TransactionModel>()
        while (rs.next()) {
            transactions.add(TransactionModel(rs.getInt("number"), rs.getFloat("total"), UserModel(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"))))
        }

        return transactions
    }
}
