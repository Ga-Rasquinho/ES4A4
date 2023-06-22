<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Flight"%>
<%
ArrayList<Flight> vooBusca = (ArrayList<Flight>) request.getAttribute("listaVoo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./css/consulta.css">
<title>Pagina Inicial</title>
</head>
<body>
	<header>
		<div class="logo-container">
			<a href="index.html"><img class="imgLogo"
				src="imagens/newLogo.png"></a>
			<p id="logo">SKY-IFSP</p>
		</div>
		<div>
			<a href="login.jsp"><img class="imgUser"
				src="imagens/user.png"></a>
		</div>
	</header>
	<main>
		<div id="painel">
			<form action="buscarVoos" method="GET" id="form-consulta">
				<p id="title-consulta">Passagens Aereas</p>
				<div id="content-local">
					<input name="aero-origem" type="text" id="origem" class="local"
						placeholder="Origem" list="opcoes"> <input
						name="aero-destino" type="text" id="destino" class="local"
						placeholder="Destino" list="opcoes">
				</div>
				<datalist id="opcoes">
					<option value="Aeroporto Internacional de Narita">Tokyo</option>
					<option value="Aeroporto de Paris Charles de Gaulle">Paris</option>
					<option value="Aeroporto Internacional Tom Jobim">rio de
						janeiro</option>
				</datalist>
				<div id="content-busca">
					<div>
						<label>Data: </label> <input name="dt-hr"
							type="date" id="date" class="date">
					</div>
					<button type="submit" id="btn-busca">Buscar</button>
				</div>
			</form>
		</div>

		<div class="container">
			<%
			if (request.getAttribute("listaVoo") != null) {
				for (int i = 0; i < vooBusca.size(); i++) {
			%>

			<div class="card">
				<div class="card-content">
					<p>
						<span style="font-weight: bold; color: black;">Origem:</span>
						<%=vooBusca.get(i).getAero_origem()%>
					</p>
					<hr>
					<p>
						<span style="font-weight: bold; color: black;">Destino:</span>
						<%=vooBusca.get(i).getAero_destino()%>
					</p>
					<br />
					<p>
						Data:
						<%=vooBusca.get(i).getData_hr_decolagem()%></p>
				</div>
				<div class="card-preco">
					<p>
						R$
						<%=vooBusca.get(i).getPrecoPassagem()%></p>
				</div>
			</div>
			<%
			}
			}
			%>
		</div>
	</main>
</body>
</html>