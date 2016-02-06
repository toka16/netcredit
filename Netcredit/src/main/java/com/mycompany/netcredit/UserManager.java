/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netcredit;

//import db.UserRepository;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toka
 */
@RestController
public class UserManager {
    
    private static HashMap<String, UserEntity> users = new HashMap<>();

//    @Autowired
//    private UserRepository userRepo;
    
    @RequestMapping("/user/current")
    public @ResponseBody
    UserEntity getUser(HttpSession session, HttpServletResponse response) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        System.out.println("current user: " + user);
        if (user == null) {
            try {
                response.sendError(404);
            } catch (IOException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public void login(@RequestBody Map<String, String> params, HttpServletResponse responce, HttpSession session) {
//        UserEntity user = userRepo.findByUsername(params.get("username"));
        UserEntity user = users.get(params.get("username"));
//        UserEntity user = new UserEntity();
//        user.setUsername(params.get("username"));
//        user.setPassword(params.get("password"));
//        user.setBirthDate(new Date());
        if (user.getPassword().equals(params.get("password"))) {
            session.setAttribute("user", user);
        } else {
            try {
                responce.sendError(404);
            } catch (IOException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public void register(@RequestBody UserEntity user, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("register");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());

        if (users.containsKey(user.getUsername())){
            response.sendError(409);
            return;
        }
        
        session.setAttribute("user", user);
        users.put(user.getUsername(), user);
//        userRepo.save(user);
    }

    @RequestMapping(value = "/user/current", method = RequestMethod.PUT)
    public String edit(@RequestBody UserEntity user, HttpServletResponse response, HttpSession session) throws IOException {

        UserEntity current = (UserEntity) session.getAttribute("user");
        if (current == null) {
            System.out.println("user is null");
            response.sendError(300);
            return "/";
        }
        if (current.getPassword().equals(user.getPassword())) {
            user.setId(current.getId());
            session.setAttribute("user", user);
            if (!current.getUsername().equals(user.getUsername())){
                users.remove(current.getUsername());
            }
            users.put(user.getUsername(), user);
//            userRepo.save(user);
        } else {
            System.out.println("password doesn't match");
            response.setStatus(406);
        }
        return "";
    }

    @RequestMapping(value = "/user/current/logout", method = RequestMethod.POST)
    public String logout(HttpServletResponse response, HttpSession session) {
        session.removeAttribute("user");
        try {
            response.sendError(300);
            return "/home/home.html";
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
