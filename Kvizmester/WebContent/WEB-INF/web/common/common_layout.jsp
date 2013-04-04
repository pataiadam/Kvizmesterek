<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:url beanclass="kvizmester.action.LogoutActionBean" var="logoutURL" event="logout"/>

<s:layout-definition>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta charset="utf-8">
			<title>Kvízmester 1.0.</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="description" content="">
			<meta name="author" content="">
			<!-- Le styles -->
			<link href="css/bootstrap.css" rel="stylesheet">
			<link href="css/bootstrap-responsive.css" rel="stylesheet">
			<link href="css/docs.css" rel="stylesheet">
  		</head>
		
		<body>
		<!-- Navbar
		================================================== -->
		<div class="jumbotron masthead">
		  <div class="splash"> <img src="img/background.jpg" alt="Banner" /> </div>
		  <div class="nav-agency">
		    <div class="navbar navbar-static-top"> 
		      <!-- navbar-fixed-top -->
		      <div class="navbar-inner">
		        <div class="container"> <a class="brand"> <img src="img/logo.png" width="90px" alt="Logo"></a>
		          <div id="main-nav">
		            <div class="nav-collapse collapse">
		              <ul class="nav">
		                <li class="active"><a href="">Kezdőlap</a> </li>
		                <li><a href=""> Statisztika </a></li>
		                <li><a href=""> Ranglista </a></li>
		                <li><a href=""> Fórum </a></li>
		                <li><a href=""> Verseny </a></li>
		                <li><a href="${logoutURL}"> Kijelentkezés </a> </li>
		              </ul>
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
			    <h1> Játékszabályok</h1>
			    <p class="marketing-byline"> Lorem ipsum blabla...</p>
			    <hr class="soften">
			    <div class="row-fluid">
			      <div class="span4"> <img src="img/responsive.png" alt="Responsive">
			        <h2> <span class="firstword">Első</span> szabály</h2>
			        <p class="features"> blabla</p>
			      </div>
			      <div class="span4"> <img src="img/think-creative.png" alt="Think Creative">
			        <h2> <span class="firstword">Második</span> szabály</h2>
			        <p> blablaaa</p>
			      </div>
			      <div class="span4"> <img src="img/core-values.png" alt="Core Values">
			        <h2> <span class="firstword">Harmadik</span> szabály</h2>
			        <p> Ighrtzj</p>
			      </div>
			    </div>
			    <hr class="soften">
			   
			  </div>
			</div>
			
			<!-- Le javascript
			    ================================================== --> 
			<!-- Placed at the end of the document so the pages load faster --> 
			<script src="js/jquery.js" type="text/javascript"></script> 
			
			<script type="text/javascript">
			        $(document).ready(function () {
			        	$('ul').children().click(function () {
			        		$(this).addClass('active');
			        		}
			        	);
			        });
			    </script>
		</footer>
	</html>
</s:layout-definition>