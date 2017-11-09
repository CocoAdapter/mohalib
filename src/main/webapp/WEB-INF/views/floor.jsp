<%--
  Created by IntelliJ IDEA.
  User: pendragon
  Date: 16-12-16
  Time: 下午8:53
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
<section id="templatemo_element">
    <div class="container">
        <header class="template_header">
            <h1 class="text-center"><span>...</span> ${floor} <span>...</span></h1>
        </header>
        <div class="clearfix"></div>
        <hr>

        <c:forEach items="${roomList}" var="room">
            <div class="col-md-12">
                <h2>${room.name}</h2>
            </div>

            <form method="post" role="form">
                <div>
                    <input type="hidden" name="room" value="${room.id}">
                    <div class="form-group">
                        <c:forEach items="${room.seats}" var="num">
                            <label>${num}<input type="checkbox" name="number" value="${num}">
                            </label>
                        </c:forEach>
                    </div>

                    <div>
                        <div class="form-group">
                            <label for="date">Date</label>
                            <div class="input-group">
                                <div class="input-group-addon"><i class="fa date-picker"></i></div>
                                <input type="date" class="form-control" id="date" name="date"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="startTime">Start Time</label>
                            <div class="input-group">
                                <div class="input-group-addon"><i class="fa fa-list-ul"></i></div>
                                <select class="form-control" id="startTime" name="startTime">
                                    <option value="08:00">08:00</option>
                                    <option value="08:30">08:30</option>
                                    <option value="09:00">09:00</option>
                                    <option value="09:30">09:30</option>
                                    <option value="10:00">10:00</option>
                                    <option value="10:30">10:30</option>
                                    <option value="11:00">11:00</option>
                                    <option value="11:30">11:30</option>
                                    <option value="12:00">12:00</option>
                                    <option value="12:30">12:30</option>
                                    <option value="13:00">13:00</option>
                                    <option value="13:30">13:30</option>
                                    <option value="14:00">14:00</option>
                                    <option value="14:30">14:30</option>
                                    <option value="15:00">15:00</option>
                                    <option value="15:30">15:30</option>
                                    <option value="16:00">16:00</option>
                                    <option value="16:30">16:30</option>
                                    <option value="17:00">17:00</option>
                                    <option value="17:30">17:30</option>
                                    <option value="18:00">18:00</option>
                                    <option value="18:30">18:30</option>
                                    <option value="19:00">19:00</option>
                                    <option value="19:30">19:30</option>
                                    <option value="20:00">20:00</option>
                                    <option value="20:30">20:30</option>
                                    <option value="21:00">21:00</option>
                                    <option value="21:30">21:30</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="endTime">End Time</label>
                            <div class="input-group">
                                <div class="input-group-addon"><i class="fa fa-list-ul"></i></div>
                                <select class="form-control" id="endTime" name="endTime">
                                    <option value="08:30">08:30</option>
                                    <option value="09:00">09:00</option>
                                    <option value="09:30">09:30</option>
                                    <option value="10:00">10:00</option>
                                    <option value="10:30">10:30</option>
                                    <option value="11:00">11:00</option>
                                    <option value="11:30">11:30</option>
                                    <option value="12:00">12:00</option>
                                    <option value="12:30">12:30</option>
                                    <option value="13:00">13:00</option>
                                    <option value="13:30">13:30</option>
                                    <option value="14:00">14:00</option>
                                    <option value="14:30">14:30</option>
                                    <option value="15:00">15:00</option>
                                    <option value="15:30">15:30</option>
                                    <option value="16:00">16:00</option>
                                    <option value="16:30">16:30</option>
                                    <option value="17:00">17:00</option>
                                    <option value="17:30">17:30</option>
                                    <option value="18:00">18:00</option>
                                    <option value="18:30">18:30</option>
                                    <option value="19:00">19:00</option>
                                    <option value="19:30">19:30</option>
                                    <option value="20:00">20:00</option>
                                    <option value="20:30">20:30</option>
                                    <option value="21:00">21:00</option>
                                    <option value="21:30">21:30</option>
                                    <option value="22:00">22:00</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Submit">

            </form>
        </c:forEach>

        <div class="clearfix"></div>
        <hr>
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
