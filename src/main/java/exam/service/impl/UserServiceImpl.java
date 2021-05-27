package exam.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import exam.bean.User;
import exam.dao.UserDao;
import exam.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUser(Map<String, Object> map) {
        return userDao.selectUser(map).get(0);
    }

    @Override
    public Map<String, Object> loginIn(Map<String, Object> map) {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<User> users = userDao.selectUser(map);
        if (users.size() != 0) {
            if (users.size() > 1) {
                resultMap.put("false", "账号异常!");

            } else if (users.get(0).getUserPassWord().equals(map.get("userPassWord"))) {
                resultMap.put("ture", "登录成功!");

            } else {
                resultMap.put("false", "用户不存在!");            }


        }
        return resultMap;

    }
}
