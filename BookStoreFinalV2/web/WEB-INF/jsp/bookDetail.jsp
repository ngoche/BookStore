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
        <title>Book Detal</title>
    </head>
    <body>
    <center><h1>BOOK DETAIL </h1></center>    
    <div class="col-md-2">

    </div>

    <div class=" col-md-10 panel panel-default" style="margin-top: 30px">
        <table class="table">

            <tr>
                <td><b>Id :</b></td>
                <td>${book.isbn}</td>
            </tr>
            <tr>
                <td><b>Name :</b></td>
                <td>${book.bookName}</td>
            </tr>
            <tr>
                <td><b>Price :</b></td>
                <td><fmt:formatNumber value="${book.price}" /></td>
            </tr>
            <tr>
                <td><b>Discount :</b></td>
                <td><fmt:formatNumber value="${book.discount}" /></td>
            </tr>
            <tr>
                <td><b>Category :</b></td>
                <td>${book.bookCategoryId.name}</td>
            </tr>
            <tr>
                <td><b>Author :</b></td>
                <td>${book.authorId.name}</td>
            </tr>
            <tr>
                <td><b>Publisher :</b></td>
                <td>${book.publisherId.name}</td>
            </tr>
            <tr>
                <td><b>Publish Year :</b></td>
                <td>${book.publishYear}</td>
            </tr>
            <tr>
                <td><b>Language :</b></td>
                <td>${book.language}</td>
            </tr>
            <tr>
                <td><b>Total Page :</b></td>
                <td>${book.totalPage}</td>
            </tr>
            <tr>
                <td><b>Description :</b></td>
                <td>${book.description}</td>
            </tr>
            <tr>
                <td><b>Status :</b></td>
                <c:set var = "status" scope = "session" value = "${book.status}"/>
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
            </tr>
            <tr>
                <td><b>Picture Thumb :</b></td>
                <td>${book.pictureThumb}</td>
            </tr>
        </table>

    </div>
    <a href="listB.htm" class="btn btn-primary btn-sm" style="margin-left: 400px">Back</a>
    <a href="preUpdateB.htm?isbn=${book.isbn}" class="btn btn-primary btn-sm" style="margin-left: 100px" >Update</a>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
