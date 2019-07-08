package user.service.service

import user.service.Database
import user.service.model.UserModel
import java.sql.SQLException
import java.util.*

object UserService {

    @Throws(SQLException::class)
    fun all(): ArrayList<UserModel> {
        val db = Database.getConnection()
        val stmt = db!!.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM users")

        val users = ArrayList<UserModel>()
        while (rs.next()) {
            users.add(UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("name")))
        }

        return users
    }

    @Throws(SQLException::class)
    fun findById(id: Int): UserModel? {
        val db = Database.getConnection()
        val stmt = db!!.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM users WHERE id=$id")

        var user: UserModel? = null
        while (rs.next()) {
            user = UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("name"))
        }

        return user
    }

    @Throws(SQLException::class)
    fun store(email: String, name: String): Int {
        val users = all()
        var id = 1
        for ((id1) in users) {
            id = id1
        }

        val db = Database.getConnection()
        val stmt = db!!.prepareStatement("INSERT INTO users VALUES(?, ?, ?)")
        stmt.setInt(1, ++id)
        stmt.setString(2, email)
        stmt.setString(3, name)
        stmt.execute()

        return id
    }

}
