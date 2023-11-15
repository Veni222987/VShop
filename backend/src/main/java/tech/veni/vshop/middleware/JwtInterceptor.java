package tech.veni.vshop.middleware;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.veni.vshop.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取JWT
        String authorization = request.getHeader(AUTHORIZATION_HEADER);
        if (authorization == null || !authorization.startsWith(TOKEN_PREFIX)) {
            // 未携带JWT或者格式错误
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 获取token
        String token = authorization.replace(TOKEN_PREFIX, "");
        // 验证token
        String uid = JwtUtil.parseJwtToken(token);
        // 将uid放入请求Attributes中
        request.setAttribute("uid", uid);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        return;
    }

    private boolean requiredAuth(Object handler) {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }
        // 方法注解级拦截器
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            return true;
        }
        return false;
    }

}
