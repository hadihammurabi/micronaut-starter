package transaction.service

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    private var connection: Connection? = null

    @Throws(SQLException::class)
    fun getConnection(): Connection? {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost/shop", "root", "root")
        }

        return connection
    }

}
