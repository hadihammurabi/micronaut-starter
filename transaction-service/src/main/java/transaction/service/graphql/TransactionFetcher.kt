package transaction.service.graphql

import java.util.ArrayList

import java.sql.SQLException

import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment

import javax.inject.Singleton

import com.google.gson.Gson

import transaction.service.model.TransactionModel
import transaction.service.repository.TransactionRepository

@Singleton
class TransactionFetcher : DataFetcher<ArrayList<TransactionModel>> {

    @Throws(SQLException::class)
    override fun get(env: DataFetchingEnvironment): ArrayList<TransactionModel> {
        var number = 0
        try {
            number = env.getArgument("number")
        } catch (e: NullPointerException) {

        } finally {
            val transactions: ArrayList<TransactionModel>
            if (number == 0) {
                transactions = TransactionRepository.all()
            } else {
                transactions = TransactionRepository.findByNumber(number)
            }

            return transactions
        }
    }
}
