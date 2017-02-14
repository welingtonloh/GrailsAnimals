<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Jogo dos Animais</title>
	</head>
	<body>
		
		<div class="container">
			<div class="content">	
				<div id="question">
					<g:render template="showInitial"></g:render>
					<g:render template="showMove"></g:render>
				</div>
			</div>
		</div>
		<g:render template="deleteAll"></g:render>
	</body>
</html>
