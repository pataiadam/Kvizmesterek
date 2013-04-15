<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

    <s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

		<c:forEach var="bejegyzes" items="${actionBean.bejegyzeslista }">
		<div style="height: 30px; width: 130px ; margin: 15px; background-color: green">	${bejegyzes.bejegyzes  } </div> <br>
		
		</c:forEach>
		  
    </s:layout-component>
    </s:layout-render>