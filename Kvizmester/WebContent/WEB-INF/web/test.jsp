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
	
	function answerTheQuestion(qNum, rName, ans) {
		//alert(ans);
		params = {};
		params = 'answerTheQuestion&qNumber=' + qNum + '&roomName=' + rName + '&ans=' + ans;
		$.post('${kvizmester.action.MainGameActionBean}', params,
				function(results) {
					var resultsVar = eval(results);
					alert(resultsVar);
					var answered = 0;
					params = 'questionHandler';
					$.post('${kvizmester.action.MainGameActionBean}', params,
							function(askedArray) {
								var askedVar = eval(askedArray);
								
								for ( var i = 0; i < askedVar.length; i++) {
									element = askedVar[i];
									if (element == 1) {
										answered++;
									}
								}
								
							});
					
				});
	}

	$(document).ready(function() {
		$(".answer").click(function() {
			clearInterval(myVar);
			//alert($(this).attr('class').split(' ')[1]);
			
			answerTheQuestion($(this).attr('class').split(' ')[1], $(this).attr('class').split(' ')[2], $(this).text());
			$(".questionPanel").css('display', 'none');
		});
	});
</script>



<h6>${actionBean.question.getQuestion()} </h6>
<br>
<div id="demo" 
	style="width: 90px; height: 40px; background-color: green; margin: 0 auto;"></div>
<br>
<div class="answers" style="width: 200px; margin: 0 auto;">
	<c:forEach begin="0" end="3" var="i">
		<div class="answer ${actionBean.qNumber} ${actionBean.roomName}"
			style="height: 40px; width: 200px; background-color: yellow; color: black; margin: 20px">${actionBean.answers.get(i)}</div>
	</c:forEach>


</div>