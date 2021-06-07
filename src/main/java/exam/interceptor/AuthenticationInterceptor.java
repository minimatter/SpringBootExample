package exam.interceptor;

import com.github.pagehelper.util.StringUtil;
import exam.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request进入拦截器");

        String token = tokenUtil.getToken(request);

        if (StringUtil.isEmpty(token)){
            System.out.println("不存在Token");
            response.sendRedirect("/Login/login");
            return false;
        }


        return true;

        //return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
