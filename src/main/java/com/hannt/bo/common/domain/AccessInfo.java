package com.hannt.bo.common.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class AccessInfo {
    private User user;

    public static class User{
        private String id;
        private String name;
    }
}
