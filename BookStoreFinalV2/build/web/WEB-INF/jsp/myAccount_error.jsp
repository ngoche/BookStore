<%-- 
    Document   : register
    Created on : May 27, 2018, 12:16:38 PM
    Author     : Acer
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
        <style>
            .errColor{
                color:red;
            }
        </style>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!--slider-script-->
        <script src="js/responsiveslides.min.js"></script>
        <script>
            $(function () {
                $("#slider1").responsiveSlides({
                    auto: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });
        </script>
        <!--//slider-script-->
        <script>$(document).ready(function (c) {
                $('.alert-close').on('click', function (c) {
                    $('.message').fadeOut('slow', function (c) {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close1').on('click', function (c) {
                    $('.message1').fadeOut('slow', function (c) {
                        $('.message1').remove();
                    });
                });
            });
        </script>
    </head>
    <body>
        <h3 style="color: red">${registerErr}</h3>
        <!--<h3 style="color: red">{user}</h3>-->


        <jsp:include page="tHeader.jsp"></jsp:include>


        <center>
            <div class="container">
                <table class="table col-md-4">
                    <tr>
                        <td><b><i>Full Name</i></b></td>
                        <td>${log.fullName}</td>
                </tr>
                <tr>
                    <td><b>username:</b></td>
                    <td>${log.username}</td>
                </tr>
                <td><b>gender:</b></td>
                            <c:set var="gender" scope="session" property="${log.gender}"/>
                            <c:if test="${gender == true}" >
                                <td>Male</td>
                            </c:if>
                            <c:if test="${gender == false}" >
                                <td>FeMale</td>
                            </c:if>
                <tr>
                    <td><b>birthday:</b></td>
                    <td><fmt:formatDate value="${log.birthday}"/></td>
                </tr>
                <tr>
                    <td><b>address:</b></td>
                    <td>${log.address}</td>
                </tr>
                <tr>
                    <td><b>email:</b></td>
                    <td>${log.email}</td>
                </tr>
                <tr>
                    <td><b>phone:</b></td>
                    <td>${log.phone}</td>
                </tr>            
            </table>

        </div>
        <div class="text-center">
            <a href="modifyInit.htm?username=${log.username}" class="btn btn-success" >MODIFYING</a>
            <a href="deleteInit.htm?username=${log.username}" onclick="return confirm('Are you sure?')" class="btn btn-success">DELETE</a>
            <a class="btn btn-success" href="welcomeTest.htm">BACK</a>

        </div>
    </center>    


    <jsp:include page="tFooter.jsp"></jsp:include>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>



