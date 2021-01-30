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
                <h1>ADD NEW BOOK</h1>
                <h3 style="color: red; margin-bottom: 50px">${Status}</h3>
                <spring:form action="insertBook.htm" commandName="book" class="form-horizontal">
                    <spring:hidden path="isbn" class="form-control"/>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Book Name:</label>
                        <div class="col-sm-4">
                            <spring:input path="bookName" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Publish year :</label>
                        <div class="col-sm-4">
                            <spring:input path="publishYear"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Price :</label>
                        <div class="col-sm-4">
                            <spring:input path="price"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Discount :</label>
                        <div class="col-sm-4">
                            <spring:input path="discount"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Language :</label>
                        <div class="col-sm-4">
                            <spring:input path="language"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Total Page :</label>
                        <div class="col-sm-4">
                            <spring:input path="totalPage"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Status :</label>
                        <div class="col-sm-4" class="dropdown">
                            <spring:select path="status" class="btn btn-default dropdown-toggle form-control">
                                <spring:option  value="0" >Cũ</spring:option>
                                <spring:option  value="1" >Mới</spring:option>
                                <spring:option  value="2" >Hot</spring:option>
                                <spring:option  value="3" >Bán Chạy</spring:option>
                            </spring:select>
                        </div>
                    </div>   

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Book Category:</label>
                        <div class="col-sm-4" class="dropdown" >
                            <spring:select path="bookCategoryId" class="btn btn-default dropdown-toggle form-control" multiple="true" >
                                <c:forEach items="${listCategory}" var="cate" >
                                    <spring:option value="${cate.id}">${cate.name}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Publisher :</label>
                        <div class="col-sm-4" class="dropdown">
                            <spring:select path="publisherId" class="btn btn-default dropdown-toggle form-control">
                                <c:forEach items="${listPublisher}" var="pu" >
                                    <spring:option  value="${pu.id}" >${pu.name}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Author :</label>
                        <div class="col-sm-4" class="dropdown">
                            <spring:select path="authorId" class="btn btn-default dropdown-toggle form-control">
                                <c:forEach items="${listAuthor}" var="au" >
                                    <spring:option value="${au.id}">${au.name}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Picture Thumb :</label>
                        <div class="col-sm-4">
                            <spring:input path="pictureThumb"  class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">Description :</label>
                        <div class="col-sm-4">
                            <spring:textarea path="description"  class="form-control"/>
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
