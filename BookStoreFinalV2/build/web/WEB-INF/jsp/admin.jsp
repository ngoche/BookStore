<%-- 
    Document   : admin
    Created on : Jun 2, 2018, 4:15:55 PM
    Author     : DuongNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet"  href="css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css">
        <title>Quản lý thư viện</title>


    </head>
    <body>

    <!-- HEADER -->
    <div class="header" >

        <div class="col-md-12">
            <div class="col-md-10">
                <div class="nav-text">
                    <i class="fa fa-book" aria-hidden="true"></i>
                    <h1>BookStore</h1>
                </div>
                Hello ${emp.username}
            </div>
            <div class="col-md-2"><a href="logOut.htm" class="btn btn-danger btn-sm" style="margin-top: 2em">LogOut</a></div>
        </div>

    </div>

    <div class="container" >
        <br/>
        <div class="" style="margin-top: 10em">
            <a href="listB.htm" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Book Management</a>
            <a href="listAccCus.htm" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Customer Management</a>
            <a href="listOder.htm" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Order Management</a>
        </div>
    </div>

</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
