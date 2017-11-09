<%--
  Created by IntelliJ IDEA.
  User: pendragon
  Date: 16-12-16
  Time: 下午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<html lang="en" class="ie_11_scroll">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="hhhwidth=device-width, initial-scale=1">
    <title>Moha lib</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/templatemo_style.css"/>">
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png"/>">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--contact-->
<section id="templatemo_contact">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <header class="template_header">
                    <h1 class="text-center"><span>...</span> Contact <span>...</span></h1>
                </header>
                <p class="text-center">
                    <i class="fa fa-heart"></i> ${status}<br>
                    <i class="fa fa-map-marker"></i> 1234 Lincoln Way, San Francisco, California<br>
                    <i class="fa fa-envelope"></i> Email: <a href="mailto:cocoadapter@qq.com">cocoadapter@qq.com</a><br>
                </p>
            </div>
        </div>
        <form role="form" action="#" method="post">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-user"></i></div>
                    <input type="text" name="name" class="form-control" id="contact-name" placeholder="Name">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-at"></i></div>
                    <input type="text" name="email" class="form-control" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-envelope-o"></i></div>
                    <textarea name="message" class="form-control" id="contact-message" placeholder="Message"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-6 col-xs-offset-6">
                    <button type="submit" class="form-control">Send</button>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <ul class="nav nav-pills social">
                    <li><a href="#" class="shadow-top-down social-facebook"><i class="fa fa-facebook-official"></i></a></li>
                    <li><a href="#" class="shadow-top-down social-twitter"><i class="fa fa-twitter-square"></i></a></li>
                    <li><a href="#" class="shadow-top-down social-youtube"><i class="fa fa-youtube-square"></i></a></li>
                    <li><a href="#" class="shadow-top-down social-instagram"><i class="fa fa-instagram"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</section>

<%@include file="footer.jsp" %>

<!-- require plugins -->
<script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/jquery.parallax.js"/>"></script>
<!-- template mo config script -->
<script src="<c:url value="/resources/assets/js/templatemo_scripts.js"/>"></script>
</body>
</html>

