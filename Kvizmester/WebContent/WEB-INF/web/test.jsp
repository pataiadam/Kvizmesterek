<script type="text/javascript">
	$(document).ready(function() {
		$(".oksa").click(function() {
			$(".questionPanel").css('display', 'none');
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
<div class="oksa" style="width:90px; height: 40px; background-color: green; float: right; margin-right: 150px">Ok</div>