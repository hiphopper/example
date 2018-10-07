package com.hannt.core.web.interceptor;

import com.hannt.core.model.AccessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 인증 체크 인터셉터
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private AccessInfo accessInfo;
    @Autowired
    public void setAccessInfo(AccessInfo accessInfo){
        this.accessInfo = accessInfo;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 요청에 인증이 필요한지 체크 후 인증 페이지로 redirect

        if(accessInfo == null || !accessInfo.isAuthenticated()){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
