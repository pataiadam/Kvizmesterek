<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('#usersTable').dataTable({
			"aaSorting": [[ 0, "asc" ]],
			"sScrollY": "500px",
	        "bPaginate": false,
	        "bScrollCollapse": true
			
	    });
 	});       	

	
</script>

<div style="height: 600px; overflow-y: auto; overflow-x: hidden">
<table id="usersTable" class="tablesorter">
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				Felhasználónév
			</th>
			<th>
				E-mail
			</th>
			<th>
				Pontszám
			</th>
			<th>
				Születésnap
			</th>
			<th>
				Jogosultság
			</th>
		</tr>

	</thead>
	<c:forEach var="user" items="${actionBean.users}">
	
		<tr>
			<td class="dashColumn">
			${user.id}
			</td>
			<td class="dashColumn">
			${user.username}
			</td>
			<td class="dashColumn">
			${user.email}
			</td>
			<td class="dashColumn">
			${user.score}
			</td>
			<td class="dashColumn">
			<fmt:formatDate pattern="yyyy.MM.dd" 
            value="${user.birthdate}" />
			</td>
			<td class="dashColumn">
			${user.role}
			</td>
			
		</tr>
	</c:forEach>
	</table>
	</div>
	
	</s:layout-component>
	</s:layout-render>