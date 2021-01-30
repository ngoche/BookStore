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
        <link href="css/custom.css" rel="stylesheet" type="text/css"/> 
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Management</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <!--%
            if (session.getAttribute("emp") != null) {

        %-->
        <div class="container" style="margin-top: 10px">
            <div class="alert alert-success alert-dismissible fade in ">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${Status}</strong>
                <strong>${error}</strong>
            </div>
        </div>
        Hello 
        ${emp.username}

        <div class="col-md-2">
            <div class="panel panel-primary" style="margin-top: 45px">
                <!--<div class="panel-heading">Books Manager</div>-->
                <div class="list-group">
                    <span href="#" class="list-group-item active panel-heading">Books Manager</span>
                    <a href="initInsertB.htm" class="list-group-item ">Add New Book</a>
                    <a href="listCate.htm" class="list-group-item list-group-item-warning">Book Category</a>
                    <a href="listAuthor.htm" class="list-group-item">Author Management</a>
                    <a href="listPubisher.htm" class="list-group-item list-group-item-warning">Publisher Management</a>
                </div>
            </div>
            <!--<a href="adminBack.htm" class="list-group-item list-group-item-danger">Back Home Page</a>-->
            <div class="" style="text-align: center"><a href="adminBack.htm" class="btn btn-default btn-sm">Back Home Page</a></div>
        </div>

        <div class="col-md-10" style="margin-top: 30px">
            <spring:form action="searchBookAdmin.htm" commandName="book" class="input-group">
                <spring:input path="bookName" class="form-control"/>
                
                <span class="input-group-btn">
                    <spring:select path="status" class="selectpicker btn btn-default">
                        <spring:option  value="0" >Name</spring:option>
                        <spring:option  value="1" >Category</spring:option>
                        <spring:option  value="2" >Author</spring:option>
                        <spring:option  value="3" >Publisher</spring:option>
                    </spring:select>
                    <input class="btn btn-default" type="submit" value="Search"/>
                </span>
            </spring:form>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-10  panel panel-default" style="margin-top: 30px">

            <!--//table-->
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Category</th>
                        <th>Author</th>
                        <th>Status</th>
                        <th>Publisher</th>
                        <th>Publish Year</th>
                        <th>Detail</th>
                        <th>Delete</th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${listBook}" var="b" >
                        <tr>
                            <td>${b.isbn}</td>
                            <td>${b.bookName}</td>
                            <td><fmt:formatNumber value="${b.price}" /></td>
                            <td><fmt:formatNumber value="${b.discount}" /></td>
                            <td>${b.bookCategoryId.name}</td>
                            <td>${b.authorId.name}</td>
                            <c:set var = "status" scope = "session" value = "${b.status}"/>
                            <c:if test = "${status == 0}">
                                <td> <c:out value = "Cũ"/></td>
                            </c:if>
                            <c:if test = "${status == 1}">
                                <td> <c:out value = "Mới"/></td>
                            </c:if>
                            <c:if test = "${status == 2}">
                                <td> <c:out value = "Hot"/></td>
                            </c:if>
                            <c:if test = "${status == 3}">
                                <td> <c:out value = "Bán chạy"/></td>
                            </c:if>
                            <td>${b.publisherId.name}</td>
                            <td>${b.publishYear}</td>
                            <td><a href="detailB.htm?isbn=${b.isbn}" class="btn btn-info btn-sm">View Info</a></td>
                            <td><a href="deleteB.htm?isbn=${b.isbn}" class="btn btn-danger btn-sm" onclick="return alert('Are You Sure?')">Delete</a></td>


                        </tr>

                    </c:forEach>

                </tbody>
            </table>
            <div>
                <mytag:PaginationTaglib max="8" steps="8" offset="${offset}" count="${count}" 
                                        uri="listB.htm" next="&raquo;" previous="&laquo;"/>
            </div>

        </div>
        <!--% } else { %>
        <h2>Phải Đăng Nhập Để Có Thể Thực Hiện Nghiệp Vụ</h2>
        <--% }%-->


    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
