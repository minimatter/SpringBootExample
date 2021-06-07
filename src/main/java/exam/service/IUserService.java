package exam.service;

import exam.bean.User;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface IUserService {
    public User selectUser(Map<String,Object> map);

    public Map<String,Object> loginIn(Map<String,Object> map, HttpServletResponse response);
}
