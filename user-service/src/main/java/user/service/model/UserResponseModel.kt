package user.service.model

import java.util.ArrayList

// stuktur (model) data response user
/*
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
}*/
class UserResponseModel {
    var message: String
    var data: ArrayList<UserModel>

    constructor(m: String, d: ArrayList<UserModel>) {
        this.message = m
        this.data = d
    }

    constructor(m: String, d: UserModel?) {
        this.message = m
        this.data = ArrayList()

        if (d != null) {
            this.data.add(d)
        }
    }
}