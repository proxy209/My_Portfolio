<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	pageContext.setAttribute("LF", "\n");
	pageContext.setAttribute("BR", "<br/>");
%>
<!doctype html>
<html lang="utf-8">
<head>
	<!-- Required meta tags -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap5" />

	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&family=Roboto&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="resources/fonts/icomoon/style.css">
	<link rel="stylesheet" href="resources/fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="resources/css/tiny-slider.css">
	<link rel="stylesheet" href="resources/css/aos.css">
	<link rel="stylesheet" href="resources/css/glightbox.min.css">
	<link rel="stylesheet" href="resources/css/style.css">

	<title>YHB &mdash; blog &amp; portfolio</title>
</head>
<body>

        <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                        <div class="site-mobile-menu-close">
                                <span class="icofont-close js-menu-toggle"></span>
                        </div>
                </div>
                <div class="site-mobile-menu-body"></div>
        </div>

       <%@ include file="nav/nav.jsp" %>



        <div class="hero-2 overlay" style="background-image: url('resources/images/img_3.jpg');">
                <div class="container">
                        <div class="row align-items-center">
                                <div class="col-lg-5 mx-auto ">
                                        <h1 class="mb-5 text-center"><span>Project</span></h1>
                                </div>
                        </div>
                </div>
        </div>


        <div class="section sec-3">
                <div class="container">
                        <div class="row mb-5 justify-content-between">
                                <div class="col-lg-6 mb-lg-0 mb-4">
                                        <img src="${boardDetail.filePath}/${boardDetail.fileSaveName}" alt="Image" class="img-fluid">
                                </div>
                                <div class="col-lg-5">
                                        <div class="heading">${boardDetail.boardSub}</div>
                                        <p><c:out value="${fn:replace(boardDetail.boardCont, LF, BR)}" escapeXml="false"/></p>
                                        <p><a href="${boardDetail.boardSite}" target="_blank" class="btn btn-primary">Visit Website</a></p>
                                        
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Work year:</span>  ${boardDetail.boardWorkYear} 
                                </div>
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Started:</span> ${boardDetail.boardWorkStart}
                                </div>
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Finished:</span> ${boardDetail.boardWorkEnd}
                                </div>
                        </div>
                </div>
        </div>


        <div class="section sec-5">
                <div class="container">
                        <div class="row mb-5">
                                <div class="col-lg-6">
                                        <h2 class="heading">Projects</h2>
                                </div>
                        </div>
                        <div class="row g-4">
	                                <c:forEach var="list" items="${boardList}" varStatus="status">
	                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                        <div class="single-portfolio">
	                                                <a href="pjview.do?boardNo=${list.boardNo}">
	                                                        <img src="${list.filePath}/${list.fileSaveName}" alt="Image" class="img-fluid">
	                                                        <div class="contents">
	                                                                <h3>${list.boardSub}</h3>
	                                                        </div>
	                                                </a>
	                                        </div>
	                                </div>  
	                        	</c:forEach>                                 
                        </div>
                </div>
        </div>

		<%@ include file="footer/footer.jsp" %>

        <!-- Preloader -->
        <div id="overlayer"></div>
        <div class="loader">
                <div class="spinner-border" role="status">
                        <span class="visually-hidden">Loading...</span>
                </div>
        </div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/tiny-slider.js"></script>
	<script src="resources/js/aos.js"></script>
	<script src="resources/js/glightbox.min.js"></script>
	<script src="resources/js/navbar.js"></script>
	<script src="resources/js/counter.js"></script>
	<script src="resources/js/custom.js"></script>
</body>
</html>