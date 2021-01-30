<%-- 
    Document   : bookManager
    Created on : Jun 2, 2018, 5:53:52 PM
    Author     : DuongNguyen
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" uri="/WEB-INF/tlds/MyCustomTag" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author Management</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container" style="margin-top: 10px">
            <div class="alert alert-success alert-dismissible fade in ">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${Status}</strong>
            </div>
        </div>
        Hello 
        ${emp.username}
        <div class="col-md-2">
            <div class="panel panel-primary" style="margin-top: 45px">
                <!--<div class="panel-heading">Books Manager</div>-->
                <div class="list-group">
                    <span href="#" class="list-group-item active panel-heading">Author Management </span>
                    <a href="initInsertAuthor.htm" class="list-group-item ">Add New Author</a>
                    <a href="#" class="list-group-item list-group-item-warning">Add New #</a>
                    <a href="#" class="list-group-item">Add New #</a>
                    <a href="#" class="list-group-item list-group-item-warning">Add New #</a>
                </div>
            </div>
            <!--<a href="adminBack.htm" class="list-group-item list-group-item-danger">Back Home Page</a>-->
            <div class="" style="text-align: center"><a href="listB.htm" class="btn btn-default btn-sm">Back Page</a></div>
        </div>

        <div class="col-md-10  panel panel-default" style="margin-top: 30px">

            <!--//table-->
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>BirthDay</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Update</th>
                        <th>Delete</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listAuthor}" var="a" >
                        <tr>
                            <td>${a.id}</td>
                            <td>${a.name}</td>
                            <td>${a.birthday}</td>
                            <c:set var = "email" scope = "session" value = "${a.email}"/>
                            <c:if test = "${email == null || email==''}">
                                <td> <c:out value = "Không tồn tại"/></td>
                            </c:if>
                            <c:if test = "${email != null && email!=''}">
                                <td> <c:out value = "${a.email}"/></td>
                            </c:if>

                            <c:set var = "phone" scope = "session" value = "${a.phone}"/>
                            <c:if test = "${phone == null || phone==''}">
                                <td> <c:out value = "Không tồn tại"/></td>
                            </c:if>
                            <c:if test = "${phone != null && phone!=''}">
                                <td> <c:out value = "${a.phone}"/></td>
                            </c:if>   
                            <td><a href="preUpdateAuthor.htm?id=${a.id}" class="btn btn-info btn-sm">Update</a></td>
                            <td><a href="deleteAuthor.htm?id=${a.id}" class="btn btn-danger btn-sm" onclick="return alert('Are You Sure?')">Delete</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>

    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
