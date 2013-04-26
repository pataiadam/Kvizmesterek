<script type="text/javascript">
	var t = 12;
	var myVar = setInterval(function() {
		if (t >= 1) {
			myTimer();
		} else {
			clearInterval(myVar);
		}
	}, 1000);

	function myTimer() {
		t = t - 1;
		document.getElementById("demo").innerHTML = t;
	}

	$(document).ready(function() {
		$(".oksa").click(function() {
			$(".questionPanel").css('display', 'none');
			clearInterval(myVar);
		});
	});
</script>



${actionBean.question.getQuestion()}
<br>
<br>
A. ${actionBean.question.getAnswer()}
<br>
B. ${actionBean.question.getWrongAnswer1()}
<br>
C. ${actionBean.question.getWrongAnswer2()}
<br>
D. ${actionBean.question.getWrongAnswer3()}
<br>
<div id="demo" class="oksa"
	style="width: 90px; height: 40px; background-color: green; float: right; margin-right: 150px">Ok</div>