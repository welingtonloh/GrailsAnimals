<g:formRemote name="frmAddAnimal" url="[controller: 'blend', action: 'save']" update="question" before="if( validateForm( this ) ) { " after="}">
	Qual o animal que você pensou? &nbsp; <input type="text" id="animal" name="animal" value="${now.animal}" />
	<div id="clientSideErrors"></div>
	<br /><br />
	<g:actionSubmit value="Salvar" />
	<g:remoteLink controller="blend" action="restart" update="question">
		<button type="button">Cancelar</button>
	</g:remoteLink>
	<input type="hidden" name="idLast" value="${last.id}">
</g:formRemote>