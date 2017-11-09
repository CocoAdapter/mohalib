<%--
  Created by IntelliJ IDEA.
  User: pendragon
  Date: 16-12-16
  Time: 下午5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<!-- floors -->
<section id="templatemo_features">
    <div class="container-fluid">
        <header class="template_header">
            <h1 class="text-center"><span>...</span> Floors <span>...</span></h1>
            <p class="text-muted"><span></span> Welcome ${username}, your password ${password} <span></span></p>
            <p class="text-muted"><span></span> ${info} <span></span></p>
        </header>

        <div class="col-sm-12">
            <a href="<c:url value="/floor/1" />">
            <div class="col-sm-6 col-lg-3 feature-box">
                <div class="feature-box-inner">
                    <div class="feature-box-icon">
                        <i class="fa fa-music"></i>
                    </div>
                    <p>
                        Floor 1, Information Science Department Lib
                    </p>
                </div>
            </div>
            </a>
            <a href="<c:url value="/floor/2" />">
            <div class="col-sm-6 col-lg-3 feature-box">
                <div class="feature-box-inner">
                    <div class="feature-box-icon">
                        <i class="fa fa-pagelines"></i>
                    </div>
                    <p>
                        Floor 2, Information Science Department Lib
                    </p>
                </div>
            </div>
            </a>
            <a href="<c:url value="/floor/3" />">
            <div class="col-sm-6 col-lg-3 feature-box">
                <div class="feature-box-inner">
                    <div class="feature-box-icon">
                        <i class="fa fa-ship"></i>
                    </div>
                    <p>
                        Floor 3, Information Science Department Lib
                    </p>
                </div>
            </div>
            </a>
            <a href="<c:url value="/floor/4" />">
            <div class="col-sm-6 col-lg-3 feature-box">
                <div class="feature-box-inner">
                    <div class="feature-box-icon">
                        <i class="fa fa-trophy"></i>
                    </div>
                    <p>
                        Floor 4, Information Science Department Lib
                    </p>
                </div>
            </div>
            </a>
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
