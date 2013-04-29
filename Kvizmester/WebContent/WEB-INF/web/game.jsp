<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:url beanclass="kvizmester.action.GameActionBean" var="gameURL" />

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<script type="text/javascript">
			
		<%--function invoke(form, event, container) {

		params = {};
		if (event != null)
			params = event + '&' + $(form).serialize();
		$.post(form.action, params, function(xml) {
			$(container).html(xml);
		});
	}

	$(function() {
		$('input[type=text]').keyup(function() {
			invoke($('form')[0], 'ajax', '#replaceWithAjax');
		});
	});
	$(function() {
		$('.roomConnect').click(function() {
			$.post('${gameURL}', 'joinToRoom', function(xml) {
				alert(1);
			});
		});
	});--%>
			$(document).ready(function() {

				$("#createRoomBtn").click(function() {
					$("#gameButtons").fadeOut('slow', function() {
						$("#createRoomDiv").show();
					});

				});
			});
		</script>



		<div class="container gameRoom">
			<table width="100%" border="2">
				<tbody>
					<!-- Fejléc
				================================================== -->
					<tr bgcolor="#4c4c4c">
						<th width="30%">Csatlakozás egy szobához</th>
						<th width="70%">Játék</th>
					</tr>
					<tr background="img/backgroung-game2.jpg" style="opacity: 0.95;">
						<!-- Létrehozott szobák
					================================================== -->
						<td id="joinToRoom" style="vertical-align: top;" height="600px">
							<div>
								<c:forEach items="${actionBean.rooms}" var="room">
									<div class="Room">
										<div class="roomName">${room.roomName}</div>
										<div class="roomPlayerName">${room.playerName} és ${room.createrName}</div>
										<div id="${room.roomName}" class="roomConnect">
											<s:link beanclass="kvizmester.action.MainGameActionBean">
												<s:param name="roomName" value="${room.roomName}" />
												<s:param name="me" value="${actionBean.user.username}" />
												<img src="img/playButton.png" width="20px">
											</s:link>
										</div>
									</div>
								</c:forEach>
							</div>
						</td>
						<!-- Játékba lépés, szoba létrehozása
					================================================== -->
						<td id="createGame" height="600px">
							<!-- Gombok
							================================================== -->
							<div id="gameButtons"><br> <br> <br> <br>
								<a id="createRoomBtn" class="bigbtn">Szoba létrehozása</a>
							</div> <!-- Szoba létrehozás ablak
							================================================== -->
							<div id="createRoomDiv" hidden="true">
								<h4>Szoba létrehozása</h4>
								<br> <br>
								<s:form beanclass="kvizmester.action.GameActionBean">
									<s:text name="text" />
									<div>Írja be a szoba nevét!</div>
									<s:text name="player" />
									<div>Írja be a játékos nevét, akivel játszani szeretne!</div>
									<s:param name="myName" value="${actionBean.user.username}" />
									<s:submit name="submit" />
								</s:form>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</s:layout-component>
</s:layout-render>