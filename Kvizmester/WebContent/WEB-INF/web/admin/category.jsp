<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
		<s:url beanclass="kvizmester.action.CategoryActionBean" var="newCategoryURL" event="newCategory" />
			<s:url beanclass="kvizmester.action.CategoryActionBean" var="deleteURL" event="deleteCategory" />
	
	
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
		if (confirm('Biztosan törölni kívánja a ' + name + ' kategóriát?')) { 
			window.location.assign("${deleteURL}" + "&deleteCategoryId=" + id);
			}
	}
</script>



<div style=" overflow-y: auto; overflow-x: hidden">
<s:messages />
<s:errors />
<table id="usersTable" class="tablesorter">
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				Kategória
			</th>
			<th>
				Kategória módosítása
			</th>
			<th>
				Kategória törlése
			</th>
		</tr>

	</thead>
	<c:forEach var="category" items="${actionBean.categoryList}">
	
		<tr>
		<s:form beanclass="kvizmester.action.CategoryActionBean">
			<td class="dashColumn">
			${category.id}
			</td>
			<td class="dashColumn">
			<s:text  value="${category.nev }" id="newCategoryName" name="newCategoryName" />
			<s:hidden id="modifyCategoryId" name="modifyCategoryId" value="${category.id}" />
			</td>
			<td class="dashColumn">
			<s:submit name="updateCategory" value="Módosítás" />
			</td>
			<td class="dashColumn">
			<a href="javascript:deleteUserById('${category.id}', '${category.nev}')">Törlés</a>
			</td>
		</s:form>
		</tr>
	</c:forEach>
	</table>
	
	<div align="center" style="margin-top: 10px;">
		<a href="${newCategoryURL}"><input type="submit" value="Új kategória"></a>
	</div>
	</div>
	
	</s:layout-component>
	</s:layout-render>