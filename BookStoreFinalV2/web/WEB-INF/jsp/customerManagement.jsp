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
        <title>Customer Management</title>
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
                    <span href="#" class="list-group-item active panel-heading">Customer Management</span>
                    <a href="#" class="list-group-item ">Option New Cus</a>
                    <a href="listCustomerType.htm" class="list-group-item list-group-item-warning">CusType Management</a>
                    <a href="#" class="list-group-item">Add New #</a>
                    <a href="#" class="list-group-item list-group-item-warning">Add New #</a>
                </div>
            </div>
            <!--<a href="adminBack.htm" class="list-group-item list-group-item-danger">Back Home Page</a>-->
            <div class="" style="text-align: center"><a href="adminBack.htm" class="btn btn-default btn-sm">Back Home Page</a></div>
        </div>

        <div class="col-md-10  panel panel-default" style="margin-top: 30px">

            <!--//table-->
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User Name</th>
                        <th>Full Name</th>
                        <th>Gender</th>
                        <th>Birthday</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Customer type</th>
                        <th>Detail</th>
                        <th>Delete</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listAccount}" var="c" >
                        <tr>
                            <td>${c.customerId.id}</td>
                            <td>${c.username}</td>
                            <td>${c.customerId.fullName}</td>
                            <td>${c.customerId.gender}</td>
                            <td>${c.customerId.birthday}</td>
                            <td>${c.customerId.address}</td>
                            <td>${c.customerId.email}</td>
                            <td>${c.customerId.phone}</td>
                            <td>${c.customerId.customerTypeId.type}</td>
                            <td><a href="detailAccCus.htm?user=${c.username}" class="btn btn-info btn-sm">View Info</a></td>
                            <td><a href="deleteAccCus.htm?user=${c.username}" class="btn btn-danger btn-sm" onclick="return alert('Are You Sure?')">Delete</a></td>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
