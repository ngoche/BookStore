<%-- 
    Document   : bookDetail
    Created on : Jun 2, 2018, 7:56:47 PM
    Author     : DuongNguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acc Customer Detail</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container" style="margin-top: 10px">
            <div class="alert alert-success alert-dismissible fade in ">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${Status}</strong>
            </div>
        </div>
    <center><h1>ACC CUSTOMER DETAIL </h1></center>    
    <div class="col-md-2"></div>
    <div class=" col-md-10 panel panel-default" style="margin-top: 30px">
        <table class="table">
            <thead>
            <center><h3><b>Customer Info</b></h3></center>
            </thead>
            <tr>
                <td><b>Id :</b></td>
                <td>${detailCus.id}</td>
            </tr>
            <tr>
                <td><b>Full Name :</b></td>
                <td>${detailCus.fullName}</td>
            </tr>
            <tr>
                <td><b>Gender :</b></td>
                <c:set var = "gender" scope = "session" value = "${detailCus.gender}"/>
                <c:if test = "${gender == false}">
                    <td> <c:out value = "Female"/></td>
                </c:if>
                <c:if test = "${gender == true}">
                    <td> <c:out value = "Male"/></td>
                </c:if>

            </tr>
            <tr>
                <td><b>Birthday :</b></td>
                <td>${detailCus.birthday}</td>
            </tr>
            <tr>
                <td><b>Address :</b></td>
                <td>${detailCus.address}</td>
            </tr>
            <tr>
                <td><b>Type :</b></td>
                <td>${detailCus.customerTypeId.type}</td>
            </tr>
            <tr>
                <td><b>UserName :</b></td>
                <td>${detailAcc.username}</td>
            </tr>
            <tr>
                <td><b>PassWord :</b></td>
                <td>${detailAcc.password}</td>
            </tr>
        </table>
    </div>
    <div class="col-md-2"></div>
    <div class=" col-md-10 panel panel-default" style="margin-top: 30px">

        <table class="table">
            <thead>
            <center><h3><b>Account Info</b></h3></center>
            </thead>
            <tr>
                <td><b>UserName :</b></td>
                <td>${detailAcc.username}</td>
            </tr>
            <tr>
                <td><b>PassWord :</b></td>
                <td>${detailAcc.password}</td>
            </tr>
        </table>
    </div>

    <a href="listAccCus.htm" class="btn btn-primary btn-sm" style="margin-left: 400px">Back</a>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
