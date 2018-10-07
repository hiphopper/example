package com.hannt.bo.common.domain;

import com.hannt.bo.common.utils.StringUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Lazy
public class AccessInfo {
    private User user;

    public static class User{
        private String id;
        private String name;

        boolean isValid(){
            return StringUtil.isNotEmpty(id) && StringUtil.isNotEmpty(name);
        }
    }

    public boolean isAuthenticated(){
        return user != null && user.isValid();
    }
}
