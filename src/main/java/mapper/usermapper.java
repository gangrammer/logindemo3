package mapper;

import pojo.User;

import java.util.List;

public interface usermapper {
    User login(User user);

    void register(User user);

  List<User>selectAllUser();
}
