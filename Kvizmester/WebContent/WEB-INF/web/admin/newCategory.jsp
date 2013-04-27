<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.CategoryActionBean">
			
			
			<table align="center">
				<tr>
					<td colspan="2"><h2>Új kategória</h2></td>
				</tr>
				<tr>
					<td align="right">
						Kategória neve
					</td>
					
					<td>
						<s:text id="newCategoryName" name="newCategoryName" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit name="Rögzítés" value="Rögzítés" />

						<s:errors />
						<s:messages />
					</td>
				</tr>
			</table>		
		</s:form>
	</s:layout-component>
</s:layout-render>