<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.ModifyRegActionBean">
			
			
			<table align="center">
				<tr>
					<td colspan="2"><h2>Adatok módosítása</h2></td>
				</tr>
				<tr>
					<td align="right">
						<s:label name="label.email" for="email" />
					</td>
					
					<td>
						<s:text id="email" name="email" value="${actionBean.email }"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						Jelenlegi jelszó
					</td>
					<td>
						<s:password id="oldpassword" name="oldpassword" />
						
					</td>
				</tr>
				<tr>
					<td align="right">
						Új jelszó (nem kötelező)
					</td>
					<td>
						<s:password id="password" name="password" />
						
					</td>
				</tr>
				<tr>
					<td align="right">
						Új jelszó megerősítése
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
						<s:text id="birthdate" name="birthdate" value="${actionBean.birthdate }"/>
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