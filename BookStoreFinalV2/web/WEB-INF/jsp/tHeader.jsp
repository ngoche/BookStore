
<%-- 
    Document   : tHead
    Created on : Jun 23, 2018, 3:50:58 AM
    Author     : DuongNguyen
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <div class="header">
            <div class="header-top">
                <div class="container">	
                    <div class="header-top-in">			
                        <div class="logo">
                            <a href="welcomeTest.htm"><img src="image/logo1.png" alt=" " ></a>
                        </div>

                        <div class="header-in">
                            <ul class="icon1 sub-icon1">
                                <li ><a href="LovelyBookDone.htm" ><i>AHDBook quotes</i></a></li>
                                    <%
                                        if (session.getAttribute("isLogin") != null) {
                                    %>
                                <li> <a href="myAccountDone.htm">Hello <span style="font-weight: bold">${acc.username}</span></a></li>	
                                <li><a href="logOut.htm">LogOut</a></li>
                                    <%
                                        }
                                    %>

                                <%
                                    if (session.getAttribute("isLogin") == null) {
                                %>
                                <li> <a href="login.htm">Sign in/Sign up</a></li>	
                                    <%
                                        }
                                    %>

                                <li>
                                    <div class="cart">
                                        <a href="viewCart.htm" class="cart-in"> </a>
                                        <c:if test="${listBookBuy !=null}">
                                            <span>${listBookBy==null?0:listBookBy.size()}</span>
                                        </c:if>
                                    </div>
                                    <c:if test="${listBookBuy !=null}">
                                        <ul class="sub-icon1 list">
                                            <h3>Recently added items(${listBookBy==null?0:listBookBy.size()})</h3>
                                            <div class="shopping_cart">
                                                <c:forEach items="${listBookBy}" var="sub">
                                                    <div class="cart_box">
                                                        <div class="message">
                                                            <a href="deleteBookItemSub.htm?isbn=${sub.isbn}"><div class="alert-close"></div> <div class="clearfix"></div></a><div class="clearfix"></div>
                                                            <div class="list_img"><img src="${sub.pictureThumb}" class="img-responsive" alt=""></div>
                                                            <div class="list_desc"><h4><a href="detailBook.htm?isbn=${sub.isbn}">${sub.bookName}</a></h4>${sub.numberOfBook} x<span class="actual">
                                                                    <fmt:formatNumber value="${sub.price}" /> VNĐ</span></div>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </div>
                                                </c:forEach>

                                            </div>
                                            <div class="total">
                                                <div class="total_left">CartSubtotal : </div>
                                                <div class="total_right"><span>${totalPaid} VNĐ</span></div>
                                                <div class="clearfix"> </div>
                                            </div>
                                            <div class="login_buttons">
                                                <div class="check_button"><a href="CheckOutCart.htm">Check out</a></div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </ul>
                                    </c:if>
                                </li>
                            </ul>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"> </div>
            <jsp:include page="tMenu.jsp"></jsp:include>
                <div class="clearfix"></div>

                <div class="header-bottom-in">
                    <div class="container">
                        <div class="header-bottom-on">
                            <p class="wel">
                            <div class="search wel">
                            <spring:form action="search.htm" commandName="book">
                                <spring:input path="bookName"/>
                                <input type="submit" value=""/>
                            </spring:form>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
