<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/home.jsp"%>

<s:url beanclass="kvizmester.action.AdvertisingActionBean" var="advertisingURL" />
	
<script type="text/javascript">
	window.location = '${advertisingURL}';
</script>

<s:errors />
						<s:messages />