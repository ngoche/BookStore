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
                        <div class="col-md-3 main-left">
                        <div class="panel panel-primary ">
                            <div class="panel-heading">
                                <h3 class="panel-title">Menu</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="#" class="list-group-item">Item 1</a>
                                    <a href="#" class="list-group-item">Item 2</a>
                                    <a href="#" class="list-group-item">Item 3</a>
                                </div>
                            </div>
                        </div>
                        <!-- panel-primary -->

                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Tin tức nổi bật</h3>
                            </div>
                            <div class="panel-body">
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="https://files.fashiontv.com/wp-content/uploads/2017/09/ftv-paris-horisontal-big-2048x1152.jpg" alt="Image" width="60">
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading">Media heading</h4>
                                        <p>Text goes here...</p>
                                    </div>
                                </div>
                                <!-- media -->
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="https://files.fashiontv.com/wp-content/uploads/2017/09/ftv-paris-horisontal-big-2048x1152.jpg" alt="Image" width="60">
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading">Media heading</h4>
                                        <p>Text goes here...</p>
                                    </div>
                                </div>
                                <!-- media -->
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="https://files.fashiontv.com/wp-content/uploads/2017/09/ftv-paris-horisontal-big-2048x1152.jpg" alt="Image" width="60">
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading">Media heading</h4>
                                        <p>Text goes here...</p>
                                    </div>
                                </div>
                                <!-- media -->
                            </div>
                        </div>

                    </div> <!-- col-md-3 -->

                    <!-- c?t bên ph?i -->
                    <c:if test="${listBookBuy == null}">
                    <center>
                        <h4 style="color: #f54922"> Your Cart is empty!</h4>
                    </center>
                </c:if>
                <c:if test="${listBookBuy !=null}">
                    <c:if test="${listBookBuy.size() == 0}">
                        <center>
                            <h4 style="color: #f54922"> Your Cart is empty!</h4>
                        </center>
                    </c:if>
                    <c:if test="${listBookBuy.size() > 0}">
                        <form action="updateQuality.htm" method="POST">
                            <div class="col-md-9 main-right">
                                <div class="row">
                                    <center>
                                        <h2>Your Shopping Cart</h2>
                                    </center>
                                    <table class="table table-bordered table-hover tablequality-cart">

                                        <thead>
                                            <tr>
                                                <!--<th>Book ID</th>-->
                                                <th>Image</th>
                                                <th>Name</th>
                                                <th>Author</th>
                                                <th>Quantity</th>
                                                <th>Price</th>
                                                <th>Sub Cost</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <c:forEach items="${listBookBy}" var="b">
                                            <tbody>

                                                <tr>
                                                    <!--<td>$ {b.isbn}</td>-->
                                                    <td>
                                                        <img src="${b.pictureThumb}" alt="" width="50">
                                                    </td>
                                                    <td>${b.bookName}</td>
                                                    <td>${b.authorId.name}</td>
                                                    <td>
                                                        <input name="quantity" size="2" type="number" value="${b.numberOfBook}"/>
                                                    </td>
                                                    <td>${b.price}</td>
                                                    <td><fmt:formatNumber value="${b.totalPrice}" type="currency"/></td>
                                                    <td>
                                                        <a href="deleteBookItem.htm?isbn=${b.isbn}" class="btn btn-danger btn-xs" onclick="return confirm('Are you sure to delete this item?')">Remove</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>    
                                                <th colspan="5" style="text-align: center">Total cost</th>
                                                <th colspan="2"><fmt:formatNumber value="${totalPaid}"/></th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    <!--< /spring:form>-->
                                </div> <!-- .row -->
                                <div class="text-center">

                                    <input  type="submit" value="UpdateCart"class="btn btn-primary"/>
                                    <a href="welcomeTest.htm" class="btn btn-primary">Continue shopping</a>
                                    <a href="CheckOutCart.htm" class="btn btn-success">Order now</a>
                                </div>
                        </form>

                    </c:if>
                </c:if>
                    <!-- col-md-9 -->
                </div>
            </div>
        </div>
        <jsp:include page="tFooter.jsp"></jsp:include>
    </body>
</html>        