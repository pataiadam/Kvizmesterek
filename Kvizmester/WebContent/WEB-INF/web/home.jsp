<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Agency HTML5 Responsive Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<link href="js/google-code-prettify/prettify.css" rel="stylesheet">
</head>
<body data-spy="scroll" data-target=".bs-docs-sidebar">
<!-- Navbar
    ================================================== -->
<div class="jumbotron masthead">
  <div class="splash"> <img src="img/background.jpg" alt="Banner" /> </div>
  <div class="nav-agency">
    <div class="navbar navbar-static-top"> 
      <!-- navbar-fixed-top -->
      <div class="navbar-inner">
        <div class="container"> <a class="brand"> <img src="img/Logo.png" alt="Logo"></a>
          <div id="main-nav">
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="index.html">Home</a> </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="javascript:"> Work <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="work.html">One Column</a></li>
                    <li><a href="work-two-columns.html">Two Column</a></li>
                    <li><a href="work-three-columns.html">Three Column</a></li>
                    <li><a href="work-details.html">Work Details</a></li>
                  </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="javascript:"> Pricing <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="pricing.html">Four Column</a></li>
                    <li><a href="pricing-three-columns.html">Three Column</a></li>
                  </ul>
                </li>
                <li class="dropdown"><a href="javascript:" class="dropdown-toggle" data-toggle="dropdown"> Pages <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="faq.html">FAQ</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="components.html">Components</a></li>
                  </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="javascript:"> Blog <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="blog.html">Blog Page</a></li>
                    <li><a href="blog-single.html">Single Page</a></li>
                  </ul>
                </li>
                <li><a href="index.html">Purchase</a> </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Main page
    ================================================== -->
  <div class="container show-case-item">
    <h1> Kvízmester<br /> </h1>
    <p> Lorem ipsum blabla szöveg!</p>
    <a class="bigbtn">Játék indítása</a>
    <div class="clearfix"> </div>
  </div>
</div>

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
<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script> 
<script src="js/jquery.js" type="text/javascript"></script> 
<script src="js/google-code-prettify/prettify.js" type="text/javascript"></script> 
<script src="js/bootstrap-transition.js" type="text/javascript"></script> 
<script src="js/bootstrap-alert.js" type="text/javascript"></script> 
<script src="js/bootstrap-modal.js" type="text/javascript"></script> 
<script src="js/bootstrap-dropdown.js" type="text/javascript"></script> 
<script src="js/bootstrap-scrollspy.js" type="text/javascript"></script> 
<script src="js/bootstrap-tab.js" type="text/javascript"></script> 
<script src="js/bootstrap-tooltip.js" type="text/javascript"></script> 
<script src="js/bootstrap-popover.js" type="text/javascript"></script> 
<script src="js/bootstrap-button.js" type="text/javascript"></script> 
<script src="js/bootstrap-collapse.js" type="text/javascript"></script> 
<script src="js/bootstrap-carousel.js" type="text/javascript"></script> 
<script src="js/bootstrap-typeahead.js" type="text/javascript"></script> 
<script src="js/bootstrap-affix.js" type="text/javascript"></script> 
<script src="js/application.js" type="text/javascript"></script> 
<script src="js/superfish.js" type="text/javascript"></script> 
<script src="js/custom.js" type="text/javascript"></script> 
<script type="text/javascript">
        $(document).ready(function () {

            var showCaseItems = $('.show-case-item').hide();

            var splashes = $('.splash').hide();
            //get each image for each slide and set it as a background of the slide
            //            splashes.each(function () {
            //                var img = $(this).find('img');
            //                var imgSrc = img.attr('src');
            //                img.css('visibility', 'hidden');
            //                $(this).css({ 'background-image': 'url(' + imgSrc + ')', 'background-repeat': 'no-repeat' });
            //            });

            splashes.eq(0).show();
            showCaseItems.eq(0).show();

            var prevIndex = -1;
            var nextIndex = 0;
            var currentIndex = 0;

            $('#banner-pagination li a').click(function () {

                nextIndex = parseInt($(this).attr('rel'));

                if (nextIndex != currentIndex) {
                    $('#banner-pagination li a').html('<img src="img/slidedot.png" alt="slide"/>');
                    $(this).html('<img src="img/slidedot-active.png" alt="slide"/>');
                    currentIndex = nextIndex;
                    if (prevIndex < 0) prevIndex = 0;

                    splashes.eq(prevIndex).css({ opacity: 1 }).animate({ opacity: 0 }, 500, function () {
                        $(this).hide();
                    });
                    splashes.eq(nextIndex).show().css({ opacity: 0 }).animate({ opacity: 1 }, 500, function () { });

                    showCaseItems.eq(prevIndex).css({ opacity: 1 }).animate({ opacity: 0 }, 500, function () {
                        $(this).hide();
                        showCaseItems.eq(nextIndex).show().css({ opacity: 0 }).animate({ opacity: 1 }, 200, function () { });
                    });

                    prevIndex = nextIndex;
                }

                return false;
            });
		alert(1);
        });
    </script>
</body>
</html>