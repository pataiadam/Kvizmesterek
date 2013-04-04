<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:url beanclass="kvizmester.action.GameActionBean" var="gameURL"/>


<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<div class="container show-case-item">
		    <h1> Kvízmester<br /> </h1>
		    <p> Lorem ipsum blabla szöveg!</p>
		    <a href="${gameURL}" class="bigbtn" >Játék indítása</a>
		    <div class="clearfix"> </div>
		  </div>
    </s:layout-component>
    </s:layout-render>