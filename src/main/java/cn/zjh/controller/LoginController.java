package cn.zjh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * 用户登录的入口
     *
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "remember", required = false) String remember,
            Model model) {
        logger.info("登陆用户输入的用户名：" + username + "，密码：" + password);
        System.out.println("登陆用户输入的用户名：" + username + "，密码：" + password);
        String error = null;

        if (username != null && password != null) {
            //初始化
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            if (remember != null){
                if(remember.equals("on")){
                    token.setRememberMe(true);
                }
                /*if (remember.equals("on")) {
                    //说明选择了记住我
                    token.setRememberMe(true);
                } */else {
                    token.setRememberMe(false);
                }
            }else{
                token.setRememberMe(false);
            }

            try {
                //登录，即身份校验，由通过Spring注入的UserRealm会自动校验输入的用户名和密码在数据库中是否有对应的值
                subject.login(token);
                System.out.println("用户是否登录：" + subject.isAuthenticated());
                return "redirect:index.do";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                error = "用户账户不存在，错误信息：" + e.getMessage();
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                error = "用户名或密码错误，错误信息：" + e.getMessage();
            } catch (LockedAccountException e) {
                e.printStackTrace();
                error = "该账号已锁定，错误信息：" + e.getMessage();
            } catch (DisabledAccountException e) {
                e.printStackTrace();
                error = "该账号已禁用，错误信息：" + e.getMessage();
            } catch (ExcessiveAttemptsException e) {
                e.printStackTrace();
                error = "该账号登录失败次数过多，错误信息：" + e.getMessage();
            } catch (Exception e){
                e.printStackTrace();
                error = "未知错误，错误信息：" + e.getMessage();
            }
        } else {
            error = "请输入用户名和密码";
        }
        //登录失败，跳转到login页面
        model.addAttribute("error", error);
        return "login";
    }

    /**
     * 登录成功，跳转到首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
