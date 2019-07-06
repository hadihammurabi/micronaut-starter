package transaction.service.graphql;

import java.util.ArrayList;

import java.sql.SQLException;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.inject.Singleton;

import com.google.gson.Gson;

import transaction.service.model.TransactionModel;
import transaction.service.repository.TransactionRepository;

@Singleton
public class TransactionFetcher implements DataFetcher<ArrayList<TransactionModel>> {

    @Override
    public ArrayList<TransactionModel> get(DataFetchingEnvironment env) throws SQLException {
      int number = 0;
      try {
        number = env.getArgument("number");
      } catch (NullPointerException e) {
        
      } finally {
        ArrayList<TransactionModel> transactions = new ArrayList<>();
        if (number == 0) {
          transactions = TransactionRepository.all();
        } else {
          transactions = TransactionRepository.findByNumber(number);
        }

        return transactions;
      }
    }
}
