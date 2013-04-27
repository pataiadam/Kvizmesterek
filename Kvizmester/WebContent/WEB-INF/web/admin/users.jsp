<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
	<s:url beanclass="kvizmester.action.UsersActionBean" var="deleteURL" event="deleteUserById" />
	
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('#usersTable').dataTable({
			"aaSorting": [[ 0, "asc" ]],
			"sScrollY": "500px",
	        "bPaginate": false,
	        "bScrollCollapse": true
			
	    });
 	});
	
	function deleteUserById(id, name) {
		if (confirm('Biztosan törölni kívánja ' + name + ' felhasználót?')) { 
			window.location.assign("${deleteURL}" + "&deleteUserId=" + id);
			}
	}
</script>



<div style="height: 600px; overflow-y: hidden; overflow-x: hidden">
<s:messages />
<s:errors />
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
				Regisztrált
			</th>
			<th>
				Jogosultság
			</th>
			<th>
				Felhasználó törlése
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
			<fmt:formatDate pattern="yyyy.MM.dd" 
            value="${user.regDate}" />
			</td>
			<td class="dashColumn">
			${user.role}
			</td>
			<td class="dashColumn">
			<a href="javascript:deleteUserById('${user.id}', '${user.username}')">Törlés</a>
			</td>
			
		</tr>
	</c:forEach>
	</table>
	
	</div>
	
	</s:layout-component>
	</s:layout-render>