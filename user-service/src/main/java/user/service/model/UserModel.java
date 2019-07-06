package user.service.model;

// stuktur (model) data user
public class UserModel {
  public int id;
  public String email;
  public String name;

  public UserModel(int i, String e, String n) {
    this.id = i;
    this.email = e;
    this.name = n;
  }
}
