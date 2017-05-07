<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/22
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="com.pei.User" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<%
    int count = (int)request.getAttribute("count");
    if(count == 1){
        List<User> list = (List<User>) request.getAttribute ("test");
        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>名单信息</h1></td></tr>");
        while (it.hasNext ()){
            User a = (User)it.next ();
            out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        }
        out.println ("</table>");
    }else if(count == 2){
        List<User> list = (List<User>) request.getAttribute ("test");
        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>查找信息</h1></td></tr>");
        while (it.hasNext ()){
            User a = (User)it.next ();
            out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        }
        out.println ("</table>");
    }else if (count == 3){
        User a = (User)request.getAttribute ("test");
        out.println ("<table border=\"0\" align=\"center\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>查找信息</h1></td></tr>");
        out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        out.println ("</table>");
    }else {
        List<User> list = (List<User>) request.getAttribute ("test");
        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>删除此人</h1></td></tr>");
        while (it.hasNext ()){
            User a = (User)it.next ();
            out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        }
        out.println ("</table>");
    }

%>


</body>
</html>
