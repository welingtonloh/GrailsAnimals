<g:if test="${blend}">
	<div id="container">
		<div id="questionArea">
			O animal que você pensou ${blend?.now?.feature}?
			<br /><br />
			<g:remoteLink controller="blend" action="nextMove" update="question" id="${blend.id}"  params="[isLast: 'false']"><button type="button">Sim</button></g:remoteLink>
			<g:remoteLink controller="blend" action="nextMove" update="question" id="${blend.id}" params="[isLast: 'true']"><button type="button">Não</button></g:remoteLink>
		</div>
	</div>
</g:if>