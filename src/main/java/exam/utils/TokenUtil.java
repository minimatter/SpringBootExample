package exam.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import exam.bean.User;


import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;

@Component
public class TokenUtil {


    public String generateToken(User user) {

        Long currentDate = System.currentTimeMillis() + 60 * 60 * 1000;

        String token = "";
        token = JWT.create().withAudience(Integer.toString(user.getId()))
                .withAudience(user.getUserName())
                .withIssuedAt(new Date())
                //过期时间
                .withExpiresAt(new Date(currentDate))
                .sign(Algorithm.HMAC256(user.getUserPassWord()));

        return token;
    }


    public String getToken(HttpServletRequest request){

        if (request.getCookies()!=null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie c: cookies) {
                if (c.getName().equals("token")){
                    return c.getValue();
                }

            }
        }

        return null;
    }
}
