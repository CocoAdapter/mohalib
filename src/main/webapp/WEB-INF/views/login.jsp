<%--
  Created by IntelliJ IDEA.
  User: pendragon
  Date: 16-9-20
  Time: 下午8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>

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

<!-- Home -->
<section id="templatemo_home">
    <div class="container">
        <div class="templatemo_home_inner_wapper">
            <h1 class="text-center"><i class="fa fa-heart"></i> Moha Library</h1>
        </div>
        <div class="templatemo_home_inner_wapper">
            <h2 class="text-center">@CocoAdapter, <a rel="nofollow" href="http://www.cocoadapter.cc"
                                                 target="_parent">see</a></h2>
        </div>

        <div class="templatemo_home_inner_wapper">
            <form  method="post">
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><i class="fa fa-user"></i></div>
                        <input type="text" name="username" class="form-control" placeholder="学号"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                        <input type="password" name="password" class="form-control" placeholder="密码"/>
                    </div>
                </div>

                <div class="templatemo_home_inner_wapper btn_wapper">
                    <div class="col-sm-12">
                        <input type="submit" value="登陆" class="form-control">
                    </div>
                </div>

                <div class="templatemo_home_inner_wapper">
                    <h4 class="text-center">${error}</h4>
                </div>
            </form>
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
