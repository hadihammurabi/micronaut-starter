package user.service.model;

import java.util.ArrayList;

// stuktur (model) data response user
public class UserResponseModel {
  public String message;
  public ArrayList<UserModel> data;

  public UserResponseModel(String m, ArrayList<UserModel> d) {
    this.message = m;
    this.data = d;
  }

  public UserResponseModel(String m, UserModel d) {
    this.message = m;
    this.data = new ArrayList<>();

    if (d != null) {
      this.data.add(d);
    }
  }
}
