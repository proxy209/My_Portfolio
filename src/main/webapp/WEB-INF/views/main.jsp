<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<div class="hero-2 overlay" style="background-image: url('resources/images/img_2.jpg');">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-5 mx-auto">
					<h1 class="mb-5"><span>BLOG</span> & <span class="d-block"> PORTFOLIO</span></h1>
					<!-- <div class="play-vid">
						<a href="https://www.youtube.com/watch?v=mwtbEGNABWU" class="play glightbox">
							<span class="icon-play"></span>
						</a>
					</div> -->

					<div class="intro-desc">
						<<!-- div class="line"></div> -->
						<!-- <p>Delectus voluptatum distinctio quos eius excepturi sunt pariatur, aut, doloribus officia ea molestias beatae laudantium, quam odio ipsum veritatis est maiores velit quasi blanditiis et natus accusamus itaque.</p> -->
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="section sec-1">
		<div class="container">
			<div class="row g-0">
				<div class="col-lg-3">
					<h2 class="heading">What am i?</h2>
					<p>이름 : 양효빈</p>
					<p>나이 : 29세</p>
					<p>학력 : 순천대학교 컴퓨터공학과</p>
					<p>취미 : 운동, 투자, 사진</p>
					</br>
					<p>자기소개</p>
					<p>
					SI로 약 1년 8개월 정도의 경력이 있으며 현재는 서비스업에 도전하는 주니어 개발자입니다.
				    2020년 6월에 웹 개발자로서 첫 시작을하여 출장여비 서비스를 개발하였고, 교육영상 페이지 개발,
				    소공인들을 위한 하이브리드 앱 Api 및 관리자 페이지 개발, DDP(동대문디자인플라자) 사이트 개발,
				    한국고용정보원 웹 사이트 개편 및 유지보수, 레드캡 하이브리드 앱 프론트엔드 1차 개발에 참여했습니다.
				    아직은 많이 부족한 주니어 개발자이지만 잘 부탁드립니다.
					</p>
					<!-- </br> -->
					<!-- <p>SKILS</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp; -Java, Spring</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp; -Mysql, Oracle</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp; -Github, Gitlab, Svn</p> -->
					
					<!-- <p><a href="#" class="more-2">Learn more <span class="icon-arrow_forward"></span></a></p> -->
				</div>
				<div class="col-lg-7 ms-auto">
					<img src="resources/images/IMG_5192.jpg" alt="Image" class="img-fluid img-r" style="width: 500px; height: 630px;">
				</div>			</div>
		</div>
	</div>

	<div class="sec-3 section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<h2 class="heading">Skills</h2>
					<p></p>
				</div>

				<div class="col-lg-6 ms-auto">
					<div class="accordion accordion-flush accordion-1" id="accordionFlushExample">
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingOne">
								<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="true" aria-controls="flush-collapseOne">
									JAVA, SPRING
								</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse show" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="row justify-content-between">
										<div class="col-md-4">
											<img src="resources/images/java.jpg" alt="Image" class="img-fluid">
										</div>
										<div class="col-md-8">
											<p>좋은 소프트웨어를 만들기 위한 첫 걸음은 SOLID 원칙을 항상 생각하고 최대한 지키며 개발하기라고 생각합니다.</p>
										</div>
									</div>
									
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingTwo">
								<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
									jQuery
								</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="row justify-content-between">
										<div class="col-md-4">
											<img src="resources/images/jquery.jpg" alt="Image" class="img-fluid">
										</div>
										<div class="col-md-8">
											<p>경력을 쌓는 동안 가장 많이 사용해온 Javascript 라이브러리 입니다.</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingThree">
								<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
									MYSQL, ORACLE
								</button>
							</h2>
							<div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="row justify-content-between">
										<div class="col-md-4">
											<img src="resources/images/oracle.jpg" alt="Image" class="img-fluid">
										</div>
										<div class="col-md-8">
											<p>아직 부족하지만 CRUD뿐만 아닌, 설계도 잘할 수 있는 개발자가 되겠습니다.</p>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingFour">
								<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseFour" aria-expanded="false" aria-controls="flush-collapseFour">
									GITLAB, SVN
								</button>
							</h2>
							<div id="flush-collapseFour" class="accordion-collapse collapse" aria-labelledby="flush-headingFour" data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<div class="row justify-content-between">
										<div class="col-md-4">
											<img src="resources/images/gitlab.jpg" alt="Image" class="img-fluid">
										</div>
										<div class="col-md-8">
											<p>주로 사용한 형상관리도구입니다.</p>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
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