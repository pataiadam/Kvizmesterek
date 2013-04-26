<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

    <s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	<s:form beanclass="kvizmester.action.DummyForumActionBean">
	
	
	<table width="800px" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="19px" background="img/forum/tetz.png"> </td>  
  </tr>
  <tr>  
    <td background="img/forum/kozepe_zold.png">
		<table width="800px" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		<td align="right" verticalalign="top" width="110px">
		${actionBean.user.username}
		</td>
		<td width="600px">
		<s:text   id="comment" name="comment" maxlength="4" size="4" />
		</td>
		<td align="left" width="90px">
		<s:submit name="Comment" value="Comment" />
		</td>
		</tr>
		</table>
	</td>
  </tr>
  <tr>  
    <td height="15px" background="img/forum/alja_zold.png"></td> 
  </tr>
	</table>
	
	
	
	<table width="800px" align="center" border="0" cellspacing="10" cellpadding="0">
  
  <c:forEach var="bejegyzes" items="${actionBean.bejegyzeslista }">
  <tr>
    
    <td width="800px">
    
   <table width="800px" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> <td height="19px" background="img/forum/tetk.png" ></td>  
  </tr>   <tr>  
  <td background="img/forum/kozepe_kek.png" position:abxolute>
   
   
   
   <table width="800px" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		
		<td width="710px">
			${bejegyzes.bejegyzes}
		</td>
		<td align="left" width="90px">
		<s:submit name="Comment" value="Comment" />
		</td>
		</tr>
		</table>
   
   
   
   
    
    
  </td>  </tr>   <tr>   <td height="15px" background="img/forum/aljak.png"></td> 
  </tr> </table>

    </td>
  </tr>
  <tr>
    <td height="5px"></td> 
  </tr>
  
  
    
</c:forEach>  
</table>

	</s:form>	  
    </s:layout-component>
    </s:layout-render>