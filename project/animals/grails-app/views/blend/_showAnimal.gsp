<g:if test="${move}">
	<div id="container">
		<div id="animalArea">
			O animal que você pensou é ${move.animal}? 
			<br /><br />
			<g:remoteLink controller="blend" action="success" update="question"><button type="button">Sim</button></g:remoteLink>
			<g:remoteLink controller="blend" action="add" update="question" id="${move.id}"><button type="button">Não</button></g:remoteLink>
		</div>
	</div>
</g:if>