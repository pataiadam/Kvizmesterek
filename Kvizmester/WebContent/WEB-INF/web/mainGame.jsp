<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/web/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/web/common/common_layout.jsp">
	<s:layout-component name="body">

		<script type="text/javascript">
		var firstPlayer = false;
			function invokes(qNumber) {
				params = {};
				if(firstPlayer==true){
					firstPlayer=false;
				}
				else{
					firstPlayer=true;
				}
				params = 'clickedOnQuestion&qNumber=' + qNumber + '&firstPlayer='+ firstPlayer;
				
				$.post('${kvizmester.action.MainGameActionBean}', params,
						function(xml) {
							$(".questionPanel").html(xml);
						});
			}

			function questionHandler(box) {
				params = {};
				params = 'questionHandler';
				$.post('${kvizmester.action.MainGameActionBean}', params,
						function(askedArray) {
							var askedVar = eval(askedArray);
							for ( var i = 0; i < askedVar.length; i++) {
								element = askedVar[i];
								if (element == 1) {
									var doboz = ".question." + i;
									$(doboz).css('background', 'red');
									$(doboz).addClass("answered");
								}
							}
							
							if(askedVar[askedVar.length-1]==100){
								var doboz = ".playerInfo." + 1;
								$(doboz).css('opacity', '1');
								var doboz = ".playerInfo." + 2;
								$(doboz).css('opacity', '0.5');
							}
							else{
								var doboz = ".playerInfo." + 2;
								$(doboz).css('opacity', '1');
								var doboz = ".playerInfo." + 1;
								$(doboz).css('opacity', '0.5');
							}
						});
			}
			
			
			function pointsHandler() {
				params = {};
				params = 'pointsHandler';
				$.post('${kvizmester.action.MainGameActionBean}', params,
						function(points) {
							var pointsVar = eval(points);
							for ( var i = 0; i < pointsVar.length; i++) {
								element = pointsVar[i];
									var doboz = ".points." + (i+1);
									$(doboz).text(element+" pont");
								
							}
							
				});
			}

			var myVar = setInterval(function() {
				questionHandler(".question");
				pointsHandler();
			}, 2000);

			$(document).ready(function() {
				$(".question").click(function() {
					
					if($(this).attr('class').split(' ')[2]!='answered'){
						invokes($(this).attr('class').split(' ')[1]);
						$(".questionPanel").css('display', 'block');
					}
					//$(this).css('background', 'red');
				});
			});
		</script>

		<h3>${actionBean.roomName}</h3>
		<div class="gamePlace" style="height: 600px">
			<div class="gameInfo" style="float: left">
				<div class="playerInfo 1">${actionBean.game.player2}<br><div class="points 1"> 0 </div> pont</div>
				<div class="playerInfo 2">${actionBean.game.player1}<br><div class="points 2"> 0 </div> pont</div>
			</div>
			<div class="questions" style="float: right; width: 70%">
				<c:forEach begin="0" end="4" var="i">
					<div class="category cat${i}"
						style="<c:if test="${i%5==0}">clear: both;</c:if>">${actionBean.game.getCategoriesName()[i]}</div>
				</c:forEach>

				<c:forEach begin="0" end="4" var="i">
					<c:forEach begin="0" end="4" var="j">

						<div class="question ${j*5+i}"
							style="<c:if test="${j%5==0}">clear: both;</c:if>">${actionBean.game.getQuestions().get(j*5+i).getLevel()}
							pont</div>

					</c:forEach>
				</c:forEach>

				<div class=questionPanel
					style="display: none; background-color: black; height: 400px; position: absolute; width: 50%; z-index: 10px; margin: 70px; opacity: 0.7">

				</div>

			</div>


		</div>

	</s:layout-component>
</s:layout-render>