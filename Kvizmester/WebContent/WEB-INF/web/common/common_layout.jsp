<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:url beanclass="kvizmester.action.LoginActionBean" var="loginURL" />
<s:url beanclass="kvizmester.action.LogoutActionBean" var="logoutURL"
	event="logout" />
<s:url beanclass="kvizmester.action.RegisterActionBean"
	var="registerURL" />
<s:url beanclass="kvizmester.action.ModifyRegActionBean" var="modifyURL" />
<s:url beanclass="kvizmester.action.HomeActionBean" var="homeURL" />
<s:url beanclass="kvizmester.action.UsersActionBean" var="usersURL" />
<s:url beanclass="kvizmester.action.DummyForumActionBean" var="ForumURL" />

<s:layout-definition>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta charset="utf-8">
<title>Kvízmester 1.0.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="js/DataTables/media/js/jquery.dataTables.js"></script>

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<link href="css/tables.css" rel="stylesheet">
<link href="css/game/game.css" rel="stylesheet">

</head>

<body>
	<!-- Navbar
		================================================== -->
	<div class="jumbotron masthead">
		<div class="splash">
			<img src="img/background.jpg" alt="Banner" />
		</div>
		<div class="nav-agency">
			<div class="navbar navbar-static-top">
				<!-- navbar-fixed-top -->
				<div class="navbar-inner">
					<div class="container">
						<a class="brand"> <img src="img/logo.png" width="90px"
							alt="Logo"></a>
						<c:if test="${actionBean.role == 'USER'}">
							<a class="logonBox"> ${actionBean.user.username}</a>
						</c:if>
						<div id="main-nav">
							<div class="nav-collapse collapse">


								<c:if test="${actionBean.role == 'VISITOR'}">
									<ul class="nav">
										<li class="active"><a href="${loginURL }">Bejelentkezés</a>
										</li>
										<li><a href="${registerURL }">Regisztráció</a></li>
									</ul>
								</c:if>

								<c:if test="${actionBean.role == 'ADMIN'}">
									<ul class="nav">
										<li><a href="${modifyURL }"> Adatmódosítás </a></li>
										<li><a href="${usersURL }"> Felhasználók </a></li>
										<li><a href="${modifyURL }"> Témakörök </a></li>
										<li><a href="${modifyURL }"> Kérdések </a></li>
										<li><a href="${modifyURL }"> Reklámok </a></li>
										<li><a href="${logoutURL}"> Kijelentkezés </a></li>
									</ul>
								</c:if>

								<c:if test="${actionBean.role == 'USER'}">
									<ul class="nav">
										<li class="active"><a href="${homeURL }">Kezdőlap</a></li>
										<li><a href="${modifyURL }"> Adatmódosítás </a></li>
										<li><a href=""> Statisztika </a></li>
										<li><a href=""> Ranglista </a></li>
										<li><a href="${ForumURL}"> Fórum </a></li>
										<li><a href=""> Verseny </a></li>
										<li><a href="${logoutURL}"> Kijelentkezés </a></li>
									</ul>
								</c:if>






							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main page
		    ================================================== -->
		<s:layout-component name="body">
		</s:layout-component>

	</div>



</body>
<footer>
	<!-- Foot page
			================================================== -->
	<div class="container">
		<div class="marketing">
			<h1>Játékszabályok</h1>
			<p class="marketing-byline">Lorem ipsum blabla...</p>
			<hr class="soften">
			<div class="row-fluid">
				<div class="span4">
					<img src="img/responsive.png" alt="Responsive">
					<h2>
						<span class="firstword">Első</span> szabály
					</h2>
					<p class="features">blabla</p>
				</div>
				<div class="span4">
					<img src="img/think-creative.png" alt="Think Creative">
					<h2>
						<span class="firstword">Második</span> szabály
					</h2>
					<p>blablaaa</p>
				</div>
				<div class="span4">
					<img src="img/core-values.png" alt="Core Values">
					<h2>
						<span class="firstword">Harmadik</span> szabály
					</h2>
					<p>Ighrtzj</p>
				</div>
			</div>
			<hr class="soften">

		</div>
	</div>

	<!-- Le javascript
			    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


	<script type="text/javascript">
		$(document).ready(function() {
			$('ul').children().click(function() {
				$(this).addClass('active');
			});
		});
	</script>
</footer>
	</html>
</s:layout-definition>