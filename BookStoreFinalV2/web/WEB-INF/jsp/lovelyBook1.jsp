<%-- 
    Document   : index
    Created on : May 27, 2018, 10:26:08 AM
    Author     : Acer
--%>
<%-- 
    Document   : index
    Created on : May 27, 2018, 10:26:08 AM
    Author     : Acer
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--< %@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Infomation</title>
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
        <jsp:include page="tHeader.jsp"></jsp:include>

        <div class="container">
            <div class="row">
                <!-- cột bên trái -->
                <div class="col-md-3 main-left">
                    <div class="panel panel-primary ">
                        <div class="panel-heading">
                            <h3 class="panel-title">Danh mục sản phẩm</h3>
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

                <!-- cột bên phải -->
                <div>
                    <center>
                        <h2>
                            BOOK INTRODUCTION</h2>
                    </center>
                    <br/>
                    <h4>
                        <i>
                            Books are indispensable to each person. 
                            Be sure to choose books that read and appreciate, pampering precious books about the vast universe, about distant countries and nations. 
                            Scientific books can help readers discover endless universes with their laws, understand how the earth is rounded with its many different countries. 
                            Sociological books help us to understand human life in different parts of the land with economic, historical, cultural, traditions and aspirations. 
                            Books, especially literature books, help us understand the inner life of people through different periods, in different peoples, joys and sorrows, happiness and suffering, their aspirations and struggles. 
                            It also helps readers to identify themselves, to understand who they are in the vast universe, to understand how people are related to each other, to all people in the community and to the community. 
                            This mankind. Books help readers understand what happiness is, where each person's suffering and what to do to live properly and to go to a real life. The book expands the horizons of desire and aspiration.
                        </i>
                        <br/>                        
                    </h4>
                </div>
            </div> <!-- col-md-9 -->
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h2 class="footer-title">
                        COMPANY NAME
                    </h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit quos quibusdam amet impedit illo repellendus, quidem animi beatae alias numquam rerum ea officiis eum sapiente, unde mollitia placeat ullam maiores!
                    </p>
                </div>
                <div class="col-md-7">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.644396406388!2d105.78423511516516!3d21.046909992533823!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab326aa9bfef%3A0xd60313e072fc5ac4!2zMjM2IEhvw6BuZyBRdeG7kWMgVmnhu4d0LCBD4buVIE5odeG6vyAxLCBU4burIExpw6ptLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1521122098519" style="width: 100%;height:250px;border:0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </footer>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>

