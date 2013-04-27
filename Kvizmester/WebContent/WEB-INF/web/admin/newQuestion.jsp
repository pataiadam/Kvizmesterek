<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
		<s:form beanclass="kvizmester.action.QuestionsActionBean">
			
			
			<table align="center">
				<tr>
					<td colspan="2"><h2>Új kérdés</h2></td>
				</tr>
				<tr>
					<td align="right">
						Kategória
					</td>
					
					<td>
						<s:select name="categoryId">
                                <s:options-collection collection="${actionBean.categoryList}" label="nev" value="id"/>
                      </s:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						Kérdés
					</td>
					
					<td>
						<s:text id="question" name="question" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Helyes válasz
					</td>
					
					<td>
						<s:text id="answer" name="answer" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Rossz válasz 1
					</td>
					
					<td>
						<s:text id="wrongAnswer1" name="wrongAnswer1" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Rossz válasz 2
					</td>
					
					<td>
						<s:text id="wrongAnswer2" name="wrongAnswer2" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Rossz válasz 3
					</td>
					
					<td>
						<s:text id="wrongAnswer3" name="wrongAnswer3" />
					</td>
				</tr>
				<tr>
					<td align="right">
						Szint
					</td>
					
					<td>
						<s:text id="level" name="level" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit name="uploadQuestion" value="Rögzítés" />

						<s:errors />
						<s:messages />
					</td>
				</tr>
			</table>		
		</s:form>
	</s:layout-component>
</s:layout-render>