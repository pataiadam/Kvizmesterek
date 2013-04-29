<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
	<s:url beanclass="kvizmester.action.QuestionsActionBean" var="newQuestionURL" event="newQuestion" />
	<s:url beanclass="kvizmester.action.QuestionsActionBean" var="deleteURL" event="deleteQuestion" />
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('#usersTable').dataTable({
			"sScrollY": "500px",
	        "bPaginate": false,
	        "bScrollCollapse": true
			
	    });
 	});     	

	function deleteAdvertising(id, name) {
		if (confirm('Biztosan törölni kívánja a(z) \'' + name + '\' kérdést?')) { 
			window.location.assign("${deleteURL}" + "&deleteQuestionId=" + id);
			}
	}
	
</script>

<div style="height: 600px; overflow-y: auto; overflow-x: auto">
<table id="usersTable" class="tablesorter">
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				Kérdés
			</th>
			<th>
				Válasz
			</th>
			<th>
				Rossz válasz 1
			</th>
			<th>
				Rossz válasz 2
			</th>
			<th>
				Rossz válasz 3
			</th>
			<th>
				Kategória
			</th>
			<th>
				Módosítás
			</th>
			<th>
				Törlés
			</th>
		</tr>

	</thead>
	<c:forEach var="question" items="${actionBean.questionList}">
	
		<tr>
		<s:form beanclass="kvizmester.action.QuestionsActionBean">
			<td class="dashColumn">
			${question.id}
			</td>
			<td class="dashColumn">
			<s:text value="${question.question }" id="question" name="question" />
			<s:hidden id="modifiedQuestionId" name="modifiedQuestionId" value="${question.id}" />
			</td>
			<td class="dashColumn">
			<s:text value="${question.answer }" id="answer" name="answer" />
			</td>
			<td class="dashColumn">
			<s:text value="${question.wrongAnswer1 }" id="wrongAnswer1" name="wrongAnswer1" />
			</td>
			<td class="dashColumn">
			<s:text value="${question.wrongAnswer2 }" id="wrongAnswer2" name="wrongAnswer2" />
			</td>
			<td class="dashColumn">
			<s:text value="${question.wrongAnswer3 }" id="wrongAnswer3" name="wrongAnswer3" />
			</td>
			<td class="dashColumn">
			<s:select name="categoryId">
			<s:option value="{question.id">${question.category}</s:option>
            <s:options-collection collection="${actionBean.categoryList}" label="nev" value="id"/>
            </s:select>
			</td>
			<td class="dashColumn">
			<s:submit name="updateQuestion" value="Módosítás" />
			</td>
			<td class="dashColumn">
				<a href="javascript:deleteAdvertising('${question.id}', '${question.question}')">Törlés</a>
			</td>
		</s:form>
		</tr>
	</c:forEach>
	</table></div>
	<div align="center" style="margin-top: 10px;">
		<a href="${newQuestionURL}"><input type="submit" value="Új kérdés"></a>
	</div>
	
	</s:layout-component>
	</s:layout-render>