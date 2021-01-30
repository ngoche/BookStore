<%-- 
    Document   : header
    Created on : May 27, 2018, 10:27:51 AM
    Author     : Acer
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>
        <div class="header">
            <div class="header-bottom">
                <div class="container">
                    <div class="h_menu4">
                        <ul class="nav">
                            <li class="active"><a href="welcomeTest.htm">Home</a></li>
                            <li ><a href="allBook.htm" >Author</a>
                                <ul class="drop">
                                    <c:forEach items="${listAuthorT}" var="author">
                                        <li><a href="getListBookByAuthor.htm?authorId=${author.id}">${author.name}</a></li>
                                    </c:forEach>
                                    <!--<div class="clearfix"> </div>-->
                                </ul>
                            </li> 						
                            <li ><a href="allBook.htm" >Book Category</a>
                                <ul class="drop">
                                    <c:forEach items="${listCateT}" var="category">
                                        <li><a href="getListBookByCate.htm?categoryId=${category.id}">${category.name}</a></li>
                                    </c:forEach>
                                    <div class="clearfix"> </div>
                                </ul>
                            </li> 						
                            <li ><a href="allBook.htm" >Publisher</a>
                                <ul class="drop">
                                    <c:forEach items="${listPublisherT}" var="publisher">
                                        <li><a href="getListBookPublisher.htm?publisherId=${publisher.id}">${publisher.name}</a></li>
                                     </c:forEach>
                                    <!--<div class="clearfix"> </div>-->
                                </ul>
                            </li> 
                        </ul>
                        <div class="clearfix"> </div>
                        <script type="text/javascript" src="js/nav.js"></script>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!--<div class="clearfix"> </div>-->
            </div>
        </div>
    </body>
</html>
