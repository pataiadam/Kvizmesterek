<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

    <s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">
	
	<s:url beanclass="kvizmester.action.DummyForumActionBean" var="deleteURL" event="deleteComment"/>
	<s:url beanclass="kvizmester.action.DummyForumActionBean" var="addComment" event="addComment"/>
	<s:url beanclass="kvizmester.action.DummyForumActionBean" var="CommentComment" event="CommentComment"/>	


<div class="forum">


<s:form beanclass="kvizmester.action.DummyForumActionBean">


<c:if test="${actionBean.replyId == 0 && actionBean.changeId==0}">

<table align=center  border="0" cellspacing="0" cellpadding="0">
  <tr height=4>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td width=92 height=92 align="left" valign="middle" background=img/forum/green_left.png></td>
    <td  height=92 background="img/forum/center.png">
    <table>
    	<tr>
    		<td  align="left" valign="top">
    		<b> ${actionBean.user.username}:</b>		
   		 	</td>
    	</tr>
    	<tr>
    		<td  align="left">
    		<s:text class="comment"  id="comm" name="comm" maxlength="100" size="4" />	
   		 	</td>
    	</tr>
    </table>
    </td>
    
    <td width=57 height=92 background="img/forum/center.png">
    
    <input type="image" alt="addComment" name="addComment" src="img/forum/comm.png" onmouseover="this.src='img/forum/comm_over.png'" onmouseout="this.src='img/forum/comm.png'" width="56" height="92" />
    
    </td>
    
    
    <td width=16 height=92 background="img/forum/right.png">&nbsp;</td>
  </tr>
    <tr height=4>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>
</c:if>
















<c:forEach var="bejegyzes" items="${actionBean.bejegyzeslista }">


    <c:if test="${bejegyzes.reply_id == 0}">
		<table class=bejegyzes align=center  border="0" cellspacing="0" cellpadding="0">    
    </c:if>
    <c:if test="${bejegyzes.reply_id != 0}">
		<table class=albejegyzes align=center  border="0" cellspacing="0" cellpadding="0">    
    </c:if>


  <tr height=${bejegyzes.rendezes}>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
  	
    <td width=92 height=92 align="left" valign="middle" background=${bejegyzes.kep}>${bejegyzes.pontszam}p</td>
    <td  height=92 background="img/forum/center.png">
    <table>
    	<tr>
    		<td align="left" valign="top">
    		 ${bejegyzes.kiirta}		
   		 	</td>
    	</tr>
    	<tr>
    	
    	
    	<c:if test="${actionBean.changeId!=bejegyzes.id}">
    		<td align="left">
    		${bejegyzes.bejegyzes}   		
   		 	</td>
   		</c:if> 	
   		<c:if test="${actionBean.changeId==bejegyzes.id}">
    		<td align="left">
    		<s:text class="comment1"  id="updateComm" name="updateComm" value="${bejegyzes.bejegyzes}" size="4" />	  		
   		 	</td>
   		</c:if> 	
    	</tr>
    </table>
    </td>
    ${bejegyzes.delete}
    <c:if test="${bejegyzes.reply_id == 0 && actionBean.changeId!=bejegyzes.id}">
        <td width=57 height=92 background="img/forum/center.png">
        <a href=/Kvizmester/DummyForum.action?CommentComment=&replyId=${bejegyzes.id}>
        <img src="img/forum/comm.png" onmouseover="this.src='img/forum/comm_over.png'" onmouseout="this.src='img/forum/comm.png'">
        </a>
        </td>
        
    </c:if>
    <c:if test="${actionBean.changeId==bejegyzes.id}">
         <td width=57 height=92 background="img/forum/center.png">
       	<input type="image" alt="updateComment" name="updateComment" src="img/forum/comm.png" onmouseover="this.src='img/forum/comm_over.png'" onmouseout="this.src='img/forum/comm.png'" width="56" height="92" />
    	</td>
        
    </c:if>
    <td width=16 height=92 background="img/forum/right.png">&nbsp;</td>
  </tr>
</table>















<c:if test="${actionBean.replyId == bejegyzes.id}">
<table align=center  border="0" cellspacing="0" cellpadding="0">
  <tr height=4>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td width=92 height=92 align="left" valign="middle" background=img/forum/green_left.png></td>
    <td  height=92 background="img/forum/center.png">
    <table>
    	<tr>
    		<td  align="left" valign="top">
    		<b> ${actionBean.user.username}:</b>		
   		 	</td>
    	</tr>
    	<tr>
    		<td  align="left">
    		<s:text class="comment1"  id="comm" name="comm" maxlength="100" size="4" />	
   		 	</td>
    	</tr>
    </table>
    </td> 
    
    <td width=57 height=92 background="img/forum/center.png">
    
    <input type="image" alt="addComment" name="addComment" src="img/forum/comm.png" onmouseover="this.src='img/forum/comm_over.png'" onmouseout="this.src='img/forum/comm.png'" width="56" height="92" />
    
    </td>
    
    
    <td width=16 height=92 background="img/forum/right.png">&nbsp;</td>
  </tr>
    <tr height=4>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>
</c:if>


















</c:forEach>  




</div>
</s:form>  
    </s:layout-component>
    </s:layout-render>