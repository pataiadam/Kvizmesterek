<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.AdvertisingActionBean">
			
			
			<table align="center">
				<tr>
					<td colspan="2"><h2>Új hirdetés</h2></td>
				</tr>
				<tr>
					<td align="right">
						URL
					</td>
					
					<td>
						<s:text id="url" name="url" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Kezdő dátum (év.hónap.nap)
					</td>
					
					<td>
						<s:text id="beginning" name="beginning" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Vég dátum (év.hónap.nap)
					</td>
					
					<td>
						<s:text id="end" name="end" />
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