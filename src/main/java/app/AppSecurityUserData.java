/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package app;

import app.models.User;
import goja.security.shiro.SecurityUserData;
import goja.security.shiro.AppUser;
import goja.security.shiro.LoginUser;
import goja.security.shiro.UserAuth;

import java.util.Collections;

/**
 * <p>
 * .
 * </p>
 *
 * @author sagyf yang
 * @version 1.0 2014-11-01 18:08
 * @since JDK 1.6
 */
public class AppSecurityUserData implements SecurityUserData {
    @Override
    public UserAuth auth(AppUser principal) {
        return new UserAuth(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
    }

    @Override
    public LoginUser<User> user(String loginName) {
        User user = User.dao.findByUsername(loginName);
        if (user == null) {
            return null;
        } else {
            AppUser<User> shiroEmployee = new AppUser<User>(
                    user.getInt("id"),
                    user.getStr("name"),
                    user.getStr("nickname"),
                    0, 0, user);
            return new LoginUser<User>(shiroEmployee, user.getStr("password"), user.getStr("salt"));
        }
    }
}
