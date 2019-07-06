package transaction.service.model;

public class TransactionModel {
  public int number;
  public float total;
  public UserModel user;

  public TransactionModel(int n, float t, UserModel u) {
    this.number = n;
    this.total = t;
    this.user = u;
  }
}
