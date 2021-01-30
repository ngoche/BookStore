<%-- 
    Document   : index
    Created on : May 27, 2018, 10:26:08 AM
    Author     : Acer
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
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
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo1").flexisel({
                    visibleItems: 4,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
        </script>
        <!-- Best Selling  script-->
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo2").flexisel({
                    visibleItems: 4,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
        </script>
        <script type="text/javascript" src="js/jquery.flexisel.js"></script>
    </head>
    <body>
        <jsp:include page="tHeader.jsp"></jsp:include>

            <div class="container">
                <div class="account">
                    <h2 class="account-in">Register</h2>
                    <h3 style="color: red">${registerErr}</h3>
                <spring:form action="doneRegisterT.htm"  commandName="cinfo" method="post">
                    <spring:hidden path="customerTypeId"/>
                    <table>
                        <tr>
                            <spring:input path="fullName" placeholder="Full Name:" />
                            <spring:errors path="fullName" cssClass="errColor"/>
                        </tr>
                        <tr>
                            <spring:input path="username" placeholder="User Name:"/>
                            <spring:errors path="username" cssClass="errColor"/>
                        </tr>
                        <tr>
                            <spring:password path="password" placeholder="Password:"/>
                            <spring:errors path="password" cssClass="errColor"/>
                        </tr>
                        <tr>
                            <spring:textarea path="address" placeholder="Address:"/>
                            <spring:errors path="address" cssClass="errColor"/>
                            </td>
                        <tr>
                            <spring:input path="email" placeholder="Email:"/>
                            <spring:errors path="email" cssClass="errColor"/>
                        </tr>               
                    </table>
                    <br/>
                    <br/>
                    <spring:input path="phone" type="number" size="85" placeholder="Phone"/>
                    <spring:errors path="phone" cssClass="errColor"/>
                    <br/>
                    Birthday:              
                    <spring:input path="birthday" type="date" height="100" size="85"  placeholder="Birthday:"/>
                    <spring:errors path="birthday" cssClass="errColor"/>
                    <br/>
                    <br/>
                    Gender:         
                    <spring:radiobutton path="gender" value="true"/>Male
                    <spring:radiobutton path="gender" value="false"/>Female
                    <spring:errors path="gender" cssClass="errColor"/>
                    <br/>
                    <input type="submit" value="Register"/>
                    <input type="reset" value="Clear"/>
                </spring:form>
            </div>
        </div>
        <jsp:include page="tFooter.jsp"></jsp:include>
    </body>
</html>
