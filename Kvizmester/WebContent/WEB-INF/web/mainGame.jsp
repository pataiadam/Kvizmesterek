<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

		<script type="text/javascript">
			function invoke(qNumber) {
				params = {};
				params = 'clickedOnQuestion&qNumber=' + qNumber;
				$.post('${kvizmester.action.MainGameActionBean}', params,
						function(xml) {
							$(".questionPanel").html(xml);
						});
			}

			$(document).ready(function() {
				$(".question").click(function() {
					invoke($(this).attr('class').split(' ')[1]);
					$(".questionPanel").css('display', 'block');
				});

				$(".oksa").click(function() {
					$(".questionPanel").css('display', 'none');
				});
			});
		</script>

		<h3>${actionBean.roomName}</h3>
		<div class="gamePlace" style="height: 600px">
			<div class="gameInfo" style="float: left">
				<div class="playerInfo">${actionBean.game.player2}</div>
				<div class="playerInfo">${actionBean.game.player1}</div>
			</div>
			<div class="questions" style="float: right; width: 70%">
				<c:forEach begin="0" end="4" var="i">
					<div class="category cat${i}"
						style="<c:if test="${i%5==0}">clear: both;</c:if>">${actionBean.game.getCategoriesName()[i]}</div>
				</c:forEach>

				<c:forEach begin="0" end="4" var="i">
					<c:forEach begin="0" end="4" var="j">

						<div class="question ${j*5+i}"
							style="<c:if test="${j%5==0}">clear: both;</c:if>">${actionBean.game.getQuestions().get(j*5+i).getLevel()} pont</div>

					</c:forEach>
				</c:forEach>

				<div class=questionPanel
					style="display: none; background-color: black; height: 400px; position: absolute; width: 50%; z-index: 10px; margin: 70px; opacity: 0.7">

				</div>

			</div>


		</div>

	</s:layout-component>
</s:layout-render>