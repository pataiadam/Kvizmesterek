<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>


<script src="js/jquery.js" type="text/javascript"></script>


<script type="text/javascript" xml:space="preserve">
	function invoke(form, event, container) {

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

	$(document).ready(function() {

		$("#createRoomBtn").click(function() {
			$("#gameButtons").fadeOut('slow', function() {
				$("#createRoomDiv").show();
			});

		});
	});
</script>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

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
						<td id="joinToRoom" height="600px">
							<div id="replaceWithAjax"></div>
						</td>
						<!-- Játékba lépés, szoba létrehozása
					================================================== -->
						<td id="createGame" height="600px">
							<!-- Gombok
							================================================== -->
							<div id="gameButtons">
								<a class="bigbtn">Csatlakozás</a><br> <br> <br> <br>
								<a id="createRoomBtn" class="bigbtn">Szoba létrehozása</a>
							</div> <!-- Szoba létrehozás ablak
							================================================== -->
							<div id="createRoomDiv" hidden="true">
								<h4>Szoba létrehozása</h4>
								<br> <br>
								<s:form beanclass="kvizmester.action.GameActionBean">
									<s:text name="text" />
									<div>Írja be a szoba nevét. A gomb még nem megy :D</div>
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


<%-- 

								<s:form beanclass="kvizmester.action.GameActionBean">
									<table align="center">
										<tr>
											<td><s:label name="Szoba neve" for="username" /></td>
											<td><s:text id="username" name="username" /></td>
										</tr>
										<tr>
											<td><s:label name="Kis gecinek a neve" for="password" /></td>
											<td><s:password id="password" name="password" /></td>
										</tr>
										<tr>
											<td></td>
											<td><s:submit name="Létrehozás" value="Létrehozás" /></td>
										</tr>
									</table>
									<s:errors />
								</s:form>
								--%>