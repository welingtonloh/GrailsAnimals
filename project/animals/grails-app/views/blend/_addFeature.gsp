<g:formRemote name="frmAddFeature" url="[controller: 'blend', action: 'update']" update="question" before="if( validateForm( this ) ) { " after="}">
	Um(a) ${blend.now.animal} <input type="text" id="feature" name="feature" value="" /> mas um(a) ${blend.last.animal} não. 
	<div id="clientSideErrors"></div>
	<br /><br />
	<g:actionSubmit value="Salvar" />
	<g:remoteLink controller="blend" action="delete" update="question" id="${blend.id}">
		<button type="button">Cancelar</button>
	</g:remoteLink>
	<input type="hidden" name="id" value="${blend.id}" />
</g:formRemote>