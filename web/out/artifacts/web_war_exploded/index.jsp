<%@ page import="com.pei.User" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/22
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>hello world</title>
  <script src="js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <a class="navbar-brand" href="#">通讯录</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
<div >
  <form method="post" action="main">
    <table border="0" align="center" class="table table-hover">
      <tr><td>
        <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">ID:</label>
          <div class="col-sm-10">
            <input class="form-control" name="id">
          </div>
        </div></td>
      </tr>
      <tr><td>
        <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
          <div class="col-sm-10">
            <input class="form-control" name="name">
          </div>
        </div></td>
      </tr>
      <tr><td>
        <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
          <div class="col-sm-10">
            <input class="form-control" name="age">
          </div>
        </div></td>
      </tr>
      <tr><td>
        <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
          <div class="col-sm-10">
            <input class="form-control" name="sex">
          </div>
        </div></td>
      </tr>
      <tr><td>
        <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
          <div class="col-sm-10">
            <input class="form-control" name="telephone">
          </div>
        </div></td>
      </tr>
      <tr>
        <td>   <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">住址</label>
          <div class="col-sm-10">
            <input class="form-control" name="address">
          </div>
        </div></td>
      </tr>
      <tr>
        <div>
        <td><input type="submit" name="btn1" value="查找所有" class="btn btn-info">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="btn2" value="查找此人" class="btn btn-info">
         &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="btn3" value="更新信息" class="btn btn-info">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="btn4" value="删除此人" class="btn btn-info">
         &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="btn5" value="增加此人" class="btn btn-info"></td>
        </div>
      </tr>
    </table>
  </form>
</div>
</div>
<br>
<br>
<hr>
<br>
<br>
<div class="container">
  <%
    String sub = (String)request.getAttribute ("sub");
    if(sub != null){
      int count = (int)request.getAttribute("count");
      if(count == 1){
        List<User> list = (ArrayList<User>) request.getAttribute ("test");
//        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\" class=\"table table-hover\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>名单信息</h1></td></tr>");
        for(int    i=0;    i<list.size();    i++) {
//          User a = (User)it.next ();
          out.println ("<tr><td>"+ list.get (i).getId ()+"</td><td>"+ list.get (i).getName ()+"</td><td>"+ list.get (i).getSex ()+"</td><td>"+ list.get (i).getAge ()+"</td><td>"+ list.get (i).getTelephone ()+"</td><td>"+ list.get (i).getAddress ()+"</td></tr>");
//          out.println ("<tr><td>"+a[i].getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
          i++;
        }
        out.println ("</table>");
      }else if(count == 2){
        List<User> list = (List<User>) request.getAttribute ("test");
        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\" class=\"table table-hover\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>查找信息</h1></td></tr>");
        while (it.hasNext ()){
          User a = (User)it.next ();
          out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        }
        out.println ("</table>");
      }else if (count == 3){
        User a = (User)request.getAttribute ("test");
        out.println ("<table border=\"0\" align=\"center\" class=\"table table-hover\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>查找信息</h1></td></tr>");
        out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        out.println ("</table>");
      }else if(count == 4){
        List<User> list = (List<User>) request.getAttribute ("test");
        Iterator it = list.iterator ();
        out.println ("<table border=\"0\" align=\"center\" class=\"table table-hover\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>删除此人</h1></td></tr>");
        while (it.hasNext ()){
          User a = (User)it.next ();
          out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        }
        out.println ("</table>");
      }else {
        User a = (User)request.getAttribute ("test");
        out.println ("<table border=\"0\" align=\"center\" class=\"table table-hover\">");
        out.println ("<tr><td colspan=\"6\" align=\"center\"><h1>查找信息</h1></td></tr>");
        out.println ("<tr><td>"+a.getId ()+"</td><td>"+a.getName ()+"</td><td>"+a.getSex ()+"</td><td>"+a.getAge ()+"</td><td>"+a.getTelephone ()+"</td><td>"+a.getAddress ()+"</td></tr>");
        out.println ("</table>");
      }
      return;
    }

  %>
</div>
</body>
</html>
