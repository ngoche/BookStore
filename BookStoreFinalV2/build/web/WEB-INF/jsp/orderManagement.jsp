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
        <title>Order Management</title>
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

        <div class="col-md-12">
            <div class="col-md-10">Hello${emp.username}</br></div>
            <div class="col-md-2"><a href="adminBack.htm" class="btn btn-default btn-sm">Back Home Page</a></div>
        </div>
        <div class="col-md-6 panel panel-default" style="margin-top: 30px">
            <center> <h4>DANH SÁCH ORDER CẦN XÁC NHẬN</h4></center>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Customer</th>
                        <th>Employee</th>
                        <th>Order Date</th>
                        <th>Detail</th>
                        <th>Confirm</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrder}" var="b" >
                        <tr>
                            <c:set var = "employee" scope = "session" value = "${b.employeeId}"/>
                            <c:if test = "${employee == null}">
                                <td>${b.id}</td>
                                <td>${b.customerId.fullName}</td>
                                <td>Chưa xác nhận</td>
                                <td>${b.orderDate}</td>
                                <td><a href="#?id=${b.id}" class="btn btn-info btn-sm">View Info</a></td>
                                <td><a href="confirmOrder.htm?id=${b.id}" class="btn btn-info btn-sm">Confirm</a></td>
                                <td><a href="deleteOrder.htm?id=${b.id}" class="btn btn-danger btn-sm" onclick="return alert('Are You Sure?')">Delete</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-6 panel panel-default" style="margin-top: 30px">
            <center><h4>DANH SÁCH ORDER ĐÃ  ĐƯỢC XÁC NHẬN</h4></center>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Customer</th>
                        <th>Employee</th>
                        <th>Order Date</th>
                        <th>Detail</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrder}" var="b" >
                        <tr>
                            <c:set var = "employee" scope = "session" value = "${b.employeeId}"/>
                            <c:if test = "${employee != null}">
                                <td>${b.id}</td>
                                <td>${b.customerId.fullName}</td>
                                <td>${b.employeeId.fullName}</td>
                                <td>${b.orderDate}</td>
                                <td><a href="#?id=${b.id}" class="btn btn-info btn-sm">View Info</a></td>
                                <td><a href="deleteOrder.htm?id=${b.id}" class="btn btn-danger btn-sm" onclick="return alert('Are You Sure?')">Delete</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
