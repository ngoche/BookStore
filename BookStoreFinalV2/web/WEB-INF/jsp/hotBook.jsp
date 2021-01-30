<%-- 
    Document   : index
    Created on : May 27, 2018, 10:26:08 AM
    Author     : Acer
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <div class="container">
                <div class="content">
                    <!--HOT BOOK HOT BOOK HOT BOOK HOT BOOK-->
                    <!--HOT BOOK HOT BOOK HOT BOOK HOT BOOK-->
                    <!--HOT BOOK HOT BOOK HOT BOOK HOT BOOK-->
                    <div class="content-top">
                        <h3 class="future"><a href="#">HOT BOOKS</a></h3>
                        <div class="content-top-in">
                        <c:forEach items="${getBookByHot}" var="stt">
                            <div class="col-md-3 md-col" style="margin-top: 30px">
                                <div class="col-md">
                                    <a href="detailBook.htm?isbn=${stt.isbn}"><img  src="${stt.pictureThumb}" alt="" /></a>	
                                    <div class="top-content">
                                        <h5><a href="detailBook.htm?isbn=${stt.isbn}">${stt.bookName}</a></h5>
                                        <div class="white">
                                            <a href="addBookToCart.htm?isbn=${stt.isbn}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                            <p class="dollar"><span class="in-dollar">$</span><fmt:formatNumber value="${stt.price}" /></span></p>
                                            <div class="clearfix"></div>
                                        </div>

                                    </div>							
                                </div>
                            </div>
                            <!--c:set var = "STT" scope = "session" value = "$ {stt.isbn}"/>
                            <!--c:if test = "$ {STT == '5'}">
                                <div class="clearfix" style="margin-bottom: 50px"></div>
                            <!--/c:if-->
                        </c:forEach>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="tFooter.jsp"></jsp:include>
    </body>
</html>        
