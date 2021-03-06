<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.RegisterActionBean">
			
			
			<table align="center">
				<tr>
					<td colspan="2"><h2>Regisztráció</h2></td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.username" for="username" />
					</td>
					
					<td>
						<s:text id="username" name="username" />
					</td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.email" for="email" />
					</td>
					
					<td>
						<s:text id="email" name="email" />
					</td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.password" for="password"/>
					</td>
					<td>
						<s:password id="password" name="password" />
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.passwordAgain" for="password2"/>
					</td>
					<td>
						<s:password id="password2" name="password2"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.birthdate" for="birthdate"/>
					</td>
					<td>
						<s:text id="birthdate" name="birthdate" />
						
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit name="Regisztráció" value="Regisztráció" />

						<s:errors />
						<s:messages />
					</td>
				</tr>
			</table>		
		</s:form>
	</s:layout-component>
</s:layout-render>
