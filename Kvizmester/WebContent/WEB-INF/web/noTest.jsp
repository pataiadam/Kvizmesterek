<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$(".noYou").click(function() {
			$(".questionPanel").css('display', 'none');
		});
	});
</script>

<h6 class="noYou">Nem te jössz </h6>
