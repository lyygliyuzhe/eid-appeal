/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import org.iie.action.baseaction.BaseAction;

/**
 *
 * @author zmc
 */
public class LoginAction extends BaseAction {

    private String username;
    private String password;
    private String message;

    public String login() throws Exception {
        if (username.equals("admin") && password.equals("admin")) {
            this.setSession("username", username);
            //转发主页面
        } else {
            message = "输入的用户名或密码不正确！";
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
