<%-- 
    Document   : index
    Created on : May 27, 2018, 10:26:08 AM
    Author     : Acer
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
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

            <div class="clearfix"> </div>

            <div class="order-page">
                <div class="container">
                    <div class="row">
                        <!-- c?t bên trái -->
                        <h2>Order shopping</h2>
                        <h3 style="color: red">${paymentStatus}</h3>
                    <div class="col-md-4 main-left">
                        <spring:form action="CheckOutProcess.htm" method="post" commandName="paymentInfo">  
                            <div class="form-group">


                                <label for="">Full name</label>
                                <spring:input  path="accountName" class="form-control" id=""placeholder="Acount name" />
                            </div>
                            <div class="form-group">
                                <label for="">Password</label>
                                <spring:input  type="password" path="password" class="form-control" id="" placeholder="password"/>
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-success" value="Payment"/>
                            </div>
                        </spring:form>

                    </div> <!-- col-md-3 -->

                    <!-- c?t bên ph?i -->
                    <div class="col-md-8 main-right">
                        <div class="row">

                            <table class="table table-bordered table-hover table-cart">
                                <thead>
                                    <tr>
                                        <th>Book ID</th>
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Author</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Total Cost</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listBookBy}" var="b">
                                        <tr>
                                            <td>${b.isbn}</td>
                                            <td><img src="${b.pictureThumb}" alt="" width="50"/></td>
                                            <td>${b.bookName}</td>
                                            <td>${b.authorId.name}</td>
                                            <td>${b.numberOfBook}</td>
                                            <td>${b.price}</td>
                                            <td><fmt:formatNumber value="${b.totalPrice}" type="currency"/></td>                        
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="4" style="text-align: center">Total cost</th>
                                        <th colspan="2">${totalPaid}</th>
                                    </tr>
                                </tfoot>
                            </table>

                        </div> <!-- .row -->
                    </div> <!-- col-md-9 -->
                </div>
            </div>
        </div>
        <jsp:include page="tFooter.jsp"></jsp:include>
    </body>
</html>        