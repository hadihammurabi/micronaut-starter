package transaction.service.model

/*public class UserModel {
  public int id;
  public String email;
  public String name;

  public UserModel(int i, String e, String n) {
    this.id = i;
    this.email = e;
    this.name = n;
  }

  public UserModel(int i) {
    this.id = i;
  }
}*/
data class UserModel(val id: Int,val email: String,val name: String)