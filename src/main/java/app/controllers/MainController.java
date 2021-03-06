/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package app.controllers;

import com.jfinal.core.ActionKey;
import goja.Logger;
import goja.mvc.Controller;
import goja.security.shiro.Securitys;

/**
 * <p>
 * The url main Controller.
 * </p>
 *
 * @author sagyf yang
 * @version 1.0 2014-11-01 15:03
 * @since JDK 1.6
 */
public class MainController extends Controller {

    /**
     * The index route.
     * the url /main
     */
    public void index() {
        Logger.info("haha");
        render("/main.ftl");
    }


    @ActionKey("/")
    public void main(){
        redirect(Securitys.isLogin() ? "/main" : "/login");
    }

}