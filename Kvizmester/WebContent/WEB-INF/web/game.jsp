<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

		<div class="container gameRoom">
			<table width="100%" border="2" >
				<tbody>
					<tr bgcolor="#4c4c4c">
						<th width="30%">Csatlakozás egy szobához</th>
						<th width="70%">Játék</th>
					</tr>
					<tr background="img/backgroung-game2.jpg" style="opacity:0.95;">
						<td id="joinToRoom" height="600px">
							<div>
							
							</div>
						</td>
						<td id="createGame" height="600px">
							<div>
							 	<a class="bigbtn" >Csatlakozás</a><br><br><br><br>
							 	<a class="bigbtn" >Szoba létrehozása</a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</s:layout-component>
</s:layout-render>