<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
	<s:url beanclass="kvizmester.action.AdvertisingActionBean" var="newAdvertisingURL" event="newAdvertising" />
	<s:url beanclass="kvizmester.action.AdvertisingActionBean" var="deleteURL" event="deleteAdvertising" />
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('#usersTable').dataTable({
			"aaSorting": [[ 0, "asc" ]],
			"sScrollY": "500px",
	        "bPaginate": false,
	        "bScrollCollapse": true
			
	    });
 	});       	

	function deleteAdvertising(id, name) {
		if (confirm('Biztosan törölni kívánja a(z) ' + name + ' hirdetést?')) { 
			window.location.assign("${deleteURL}" + "&deleteAdvertisingId=" + id);
			}
	}
	
</script>

<div style="overflow-y: auto; overflow-x: hidden">
<s:messages />
<s:errors />
<table id="usersTable" class="tablesorter">
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				URL
			</th>
			<th>
				Kezdet
			</th>
			<th>
				Vége
			</th>
			<th>
				Módosítás
			</th>
			<th>
				Törlés
			</th>
		</tr>

	</thead>
	<c:forEach var="advert" items="${actionBean.advertisingList}">
	
		<tr>
		<s:form beanclass="kvizmester.action.AdvertisingActionBean">
			<td class="dashColumn">
			${advert.id}
			</td>
			<td class="dashColumn">
			<s:text value="${advert.url }" id="url" name="url" />
			<s:hidden id="modifyAdvertisingId" name="modifyAdvertisingId" value="${advert.id}" />
			</td>
			<td class="dashColumn">
			<s:text value="${advert.beginning }" id="beginning" name="beginning" />
			
			</td>
			<td class="dashColumn">
			<s:text value="${advert.end }" id="end" name="end" />
			</td>
			<td class="dashColumn">
			<s:submit name="updateAdvertising" value="Módosítás" />
            <td class="dashColumn">
			<a href="javascript:deleteAdvertising('${advert.id}', '${advert.url}')">Törlés</a>
			</td>
			</s:form>
		</tr>
	</c:forEach>
	</table>
	<div align="center" style="margin-top: 10px;">
		<a href="${newAdvertisingURL}"><input type="submit" value="Új hirdetés"></a>
	</div>
	</div>
	</s:layout-component>
	</s:layout-render>