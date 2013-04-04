<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.LoginActionBean"  >
			
			
			<table align="center">
				<tr>
					<td>
						<s:label name="label.username" for="username" />
					</td>
					<td>
						<s:text id="username" name="username" />
					</td>
				</tr>
				<tr>
					<td>
						<s:label name="label.password" for="password"/>
					</td>
					<td>
						<s:password id="password" name="password" />
						
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<s:submit name="Belépés" value="Belépés" />
						<a href=""> Regisztráció </a>
					</td>
				</tr>
			</table>
			<s:errors />
		</s:form>
	</s:layout-component>
</s:layout-render>
