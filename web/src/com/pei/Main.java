package com.pei;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017/4/22.
 */
//@WebServlet(name = "Main")
public class Main extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        Integer age = request.getParameter("age") != null && !request.getParameter("age").equals("") ? Integer.parseInt(request.getParameter("age")) : null;
        String sex = new String(request.getParameter("sex").getBytes("ISO8859-1"),"UTF-8");
        String telephone = request.getParameter("telephone");
        String address = new String(request.getParameter("address").getBytes("ISO8859-1"),"UTF-8");;
        int iButton=0;
        if(request.getParameter("btn1")!=null){
            iButton=1;
        } else if (request.getParameter("btn2") != null) {
            iButton = 2;
        } else if (request.getParameter("btn3") != null) {
            iButton = 3;
        }else if (request.getParameter("btn4") != null) {
            iButton = 4;
        }else if (request.getParameter("btn5") != null) {
            iButton = 5;
        }
        request.setAttribute("sub","sub");
        User user = new User();
        user.setId (id);
        user.setName (name);
        user.setSex (sex);
        user.setAddress (address);
        user.setAge (age);
        user.setTelephone (telephone);
//        ServletOutputStream out = response.getOutputStream();
//         List<User> list = JDBC.getAll ();
//        out.print (list.get (0).getAddress ());

        if(iButton == 1){
            List<User> list = new ArrayList<User> ();
            list = JDBC.getAll ();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("welco.jsp");
            request.setAttribute("test",list);//存值
            request.setAttribute("count",iButton);//存值
            rd.forward(request,response);//开始跳转
        }else if(iButton == 2){
            List<User> list = JDBC.getOne (id);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("welco.jsp");
            request.setAttribute("test",list);//存值
            request.setAttribute("count",iButton);//存值
            rd.forward(request,response);//开始跳转
        }else if(iButton == 3){
            if(JDBC.update (user)){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                RequestDispatcher rd = request.getRequestDispatcher("welco.jsp");
                request.setAttribute("test",user);//存值
                request.setAttribute("count",iButton);//存值
                rd.forward(request,response);//开始跳转
            }
        }else if(iButton == 4){
            List<User> list = JDBC.getOne (id);
            if(JDBC.Delete (id)){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                RequestDispatcher rd = request.getRequestDispatcher("welco.jsp");
                request.setAttribute("test",list);//存值
                request.setAttribute("count",iButton);//存值
                rd.forward(request,response);//开始跳转
            }
        }else if(iButton == 5){
            if (JDBC.insert (user)){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                RequestDispatcher rd = request.getRequestDispatcher("welco.jsp");
                request.setAttribute("test",user);//存值
                request.setAttribute("count",iButton);//存值
                rd.forward(request,response);//开始跳转
            }
        }else {
            request.getRequestDispatcher("index.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
