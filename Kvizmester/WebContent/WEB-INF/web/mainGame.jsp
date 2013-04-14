<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

	${actionBean.roomName}<br>
	A szoba letrehozoja alias egyes jatekos: ${actionBean.game.player2} <br>
	Aki a szobába belépett alias kettes jatekos: ${actionBean.game.player1} <br>
	

	</s:layout-component>
</s:layout-render>