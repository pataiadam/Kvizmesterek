<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<h3>${actionBean.roomName}</h3>
		<div class="gamePlace" style="height: 600px">
			<div class="gameInfo" style="float: left">
				<div class="playerInfo">${actionBean.game.player2}</div>
				<div class="playerInfo">${actionBean.game.player1}</div>
			</div>
			<div class="questions" style="float: right; width: 70%">
				<c:forEach begin="0" end="4" var="i">
					<div class="category"
						style="<c:if test="${i%5==0}">clear: both;</c:if>">Kategória ${i}</div>
				</c:forEach>
				<c:forEach begin="0" end="24" var="i">
					<div class="question"
						style="<c:if test="${i%5==0}">clear: both;</c:if>">Q ${i}</div>
				</c:forEach>
			</div>
		</div>

	</s:layout-component>
</s:layout-render>