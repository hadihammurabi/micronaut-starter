package user.service

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    private var connection: Connection? = null

    @Throws(SQLException::class)
    fun getConnection(): Connection? {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    // jdbc:driver:db_host/db_name,
                    // "jdbc:mariadb://localhost/shop",
                    "jdbc:mysql://localhost/shop",

                    // db_username
                    "root",

                    // db_password
                    "root")
        }

        return connection
    }

}
