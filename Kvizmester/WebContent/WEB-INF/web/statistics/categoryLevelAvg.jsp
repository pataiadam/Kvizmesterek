<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
		<s:url beanclass="kvizmester.action.CategoryAvgLevelActionBean" var="categoryAVGURL" />
		<s:url beanclass="kvizmester.action.CategoryMaxLevelActionBean" var="categoryMAXURL" />
		<s:url beanclass="kvizmester.action.CategoryMinLevelActionBean" var="categoryMINURL"/>
		<s:url beanclass="kvizmester.action.UserForumCommentsActionBean" var="userForumURL"/>
		<s:url beanclass="kvizmester.action.UserHighScoresActionBean" var="userHighScoresURL"/>
		<s:url beanclass="kvizmester.action.UserHighScoresByCategoryActionBean" var="userHighScoresByCategoryURL"/>
		<s:url beanclass="kvizmester.action.UserWonGamesActionBean" var="userWonURL"/>
	
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#navigation").change(function()
				{
				    document.location.href = $(this).val();
				});
		$('#usersTable').dataTable({
			"aaSorting": [[ 1, "desc" ]],
			"sScrollY": "500px",
	        "bPaginate": false,
	        "bScrollCollapse": true
			
	    });
 	});
	
	
	</script>
	
<select id="navigation">
  <option value="${userHighScoresURL }">Játékos ranglista</option>
  <option value="${userHighScoresByCategoryURL }">Játékosok átlagpontszáma kategóriánként</option>
  <option value="${userWonURL }">Játékosok ranglista nyert meccsek alapján</option>
  <option value="${userForumURL }">Játékosok fórumhozzászólásai</option>
  <option selected="true" value="${categoryAVGURL }">Kategóriák átlagos nehézsége</option>
  <option value="${categoryMAXURL }">Kategóriánkénti maximum nehézség</option>
  <option value="${categoryMINURL }">Kategóriánkénti minimum nehézség</option>
</select>
	
	<table id="usersTable" class="tablesorter">
	<thead>
		<tr>
			<th>
				Kategória
			</th>
			<th>
				Átlagos szint
			</th>
		</tr>

	</thead>
	<c:forEach var="user" items="${actionBean.avgCategoryLevel}">
	
		<tr>
			<td class="dashColumn">
			${user.name}
			</td>
			<td class="dashColumn">
			<fmt:formatNumber type="number" 
            maxIntegerDigits="3" value="${user.level}" />
			</td>
			
		</tr>
	</c:forEach>
	</table>
	
	
	
	</s:layout-component>
	</s:layout-render>