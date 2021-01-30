<%-- 
    Document   : updateBook
    Created on : Jun 2, 2018, 9:19:13 PM
    Author     : DuongNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <center>
                <h1>ADD NEW CATEGORY</h1>
                <h3 style="color: red; margin-bottom: 50px">${Status}</h3>
                <spring:form action="insertCate.htm" commandName="cate" class="form-horizontal">
                    <spring:hidden path="id" class="form-control"/>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Category Name:</label>
                        <div class="col-sm-4">
                            <spring:input path="name" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">        
                        <div class="col-sm">
                            <button type="reset" class="btn btn-primary" style="">Clear</button>
                            <button type="submit" class="btn btn-primary" style="margin-left: 80px">Submit</button>
                        </div>
                    </div>
                </spring:form>
            </center>
        </div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
