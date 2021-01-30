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
        <style>
            .bookstore-intro{
                padding: 0 0 200px 0;
                font-size: 20px;
                line-height: 180%;
            }
            .paddingbottom50{
                padding: 0 0 50px 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="tHeader.jsp"></jsp:include>

            <div class="clearfix"> </div>

            <div class="order-page">
                <div class="container">
                    <div class="row">
                        <!-- c?t bên trái -->
                      <div>
                    <center>
                        <h2 class="paddingbottom50">
                            BOOKS..</h2>
                        <image class="paddingbottom50" src="./image/book-quotes.jpg"/>
                    </center>
                          
                    <br/>
                        <div class="bookstore-intro">
                        <i>
                            Books are indispensable to each person.<br> 
                            Be sure to choose books that read and appreciate, pampering precious books about the vast universe, about distant countries and nations. 
                            Scientific books can help readers discover endless universes with their laws, understand how the earth is rounded with its many different countries. 
                            Sociological books help us to understand human life in different parts of the land with economic, historical, cultural, traditions and aspirations. 
                            Books, especially literature books, help us understand the inner life of people through different periods, in different peoples, joys and sorrows, happiness and suffering, their aspirations and struggles. 
                            It also helps readers to identify themselves, to understand who they are in the vast universe, to understand how people are related to each other, to all people in the community and to the community. 
                            This mankind. Books help readers understand what happiness is, where each person's suffering and what to do to live properly and to go to a real life. The book expands the horizons of desire and aspiration.
                        </i>
                       </div>
                        <br/>                        
                </div>
                        </div> <!-- .row -->
                    </div> <!-- col-md-9 -->
                </div>
            </div>
        </div>
        <jsp:include page="tFooter.jsp"></jsp:include>
    </body>
</html>        