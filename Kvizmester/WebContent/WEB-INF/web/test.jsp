<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>
<script type="text/javascript">
	var t = 120;
	var myVar = setInterval(function() {
		if (t >= 1) {
			myTimer();
		} else {
			clearInterval(myVar);
			$(".questionPanel").css('display', 'none');
		}
	}, 1000);

	function myTimer() {
		t = t - 1;
		document.getElementById("demo").innerHTML = t;
	}

	$(document).ready(function() {
		$(".oksa").click(function() {
			clearInterval(myVar);
			$(".questionPanel").css('display', 'none');
		});
	});
</script>



<h6>${actionBean.question.getQuestion()}</h6>
<br>
<div id="demo" class="oksa"
	style="width: 90px; height: 40px; background-color: green; margin: 0 auto;"></div>
<br>
<div class="answers" style="width: 200px; margin: 0 auto;">
	<c:forEach begin="0" end="3" var="i">
		<div class="answer"
			style="height: 40px; width: 200px; background-color: yellow; color: black; margin: 20px">${actionBean.answers.get(i)}</div>
	</c:forEach>


</div>