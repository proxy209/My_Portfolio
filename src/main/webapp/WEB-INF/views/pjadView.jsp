<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                        <h1 class="mb-5 text-center"><span><c:if test="${admin eq 'admin'}">관리자</c:if>님 어서오세요.</span></h1>


                                        <!-- <div class="intro-desc text-left">
                                                <div class="line"></div>
                                                <p>Delectus voluptatum distinctio quos eius excepturi sunt pariatur, aut, doloribus officia ea molestias beatae laudantium, quam odio ipsum veritatis est maiores velit quasi blanditiis et natus accusamus itaque.</p>
                                        </div> -->
                                </div>
                        </div>
                </div>
        </div>


        <div class="section sec-3">
       		<form name="boardFrom" method="POST" action="/api/boarSave.do" enctype="multipart/form-data">
       		<input type="hidden" name="userId" value="${admin}">
                <div class="container">
                        <div class="row mb-5 justify-content-between">
                        <input type="file" name="thumb" id="image" accept="image/*" onchange="setThumbnail(event);"/>
                                <div class="col-lg-6 mb-lg-0 mb-4 image_container">
                                        <!-- <img src="resources/images/img_7.jpg" alt="Image" class="img-fluid"> -->
                                        <div id="image_container" style="border: solid 1px black; widht:487px; height: 432px;" class="img-fluid"></div>
                                </div>
                                <div class="col-lg-5">
                                        <input class="boardSub" name="boardSub" placeholder="제목을 입력해주세요." style="width: 100%">
                                       	<p><textarea class="boardCont" placeholder="내용을 입력해주세요." name="boardCont" style="width: 100%; height: 500px; margin-top:10px"></textarea><p>
                                        <p><input name="boardSite" placeholder="링크를 입력해주세요." style="width: 100%"></p>
                                        
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Work year:</span>  <input name="boardWorkYear">
                                </div>                             
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Started:</span> <input name="boardWorkStart">
                                </div>
                                <div class="col-sm-3 border-left">
                                        <span class="text-black-50 d-block">Finished:</span> <input name="boardWorkEnd">
                                </div>
                                <div class="col-sm-3 border-left">
                                	<button class="d-block btn btn-primary" type="submit">저장</button>
                                </div>
                        </div>
                </div>              
        	</form>
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

<script> 
	const setThumbnail = (event) => {
		let reader = new FileReader(); 
		$('#image_container').children().remove();
		
		reader.onload = function(event) {
				let img = document.createElement("img"); 
				img.setAttribute("src", event.target.result); 	
				img.setAttribute('style', 'width: 487px; height: 432px;');
				document.querySelector("div#image_container").appendChild(img); 
		}; 
		
		reader.readAsDataURL(event.target.files[0]); 
	} 
</script>


</html>