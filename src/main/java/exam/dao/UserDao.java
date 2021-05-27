package exam.dao;

import exam.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> selectUser(Map<String,Object> map);
}
