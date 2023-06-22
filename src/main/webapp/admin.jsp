<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Flight"%>

<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Flight> voo = (ArrayList<Flight>) request.getAttribute("voo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/admin.css">
<title>Admin</title>
</head>
<body>
	<header>
		<div class="logo-container">
			<a href="index.html"><img class="imgLogo"
				src="imagens/newLogo.png"></a>
			<p id="logo">SKY - IFSP</p>
		</div>
	</header>
	<main>
		<div id="painel">
			<div>
				<form id="form-admin" action="inserirVoo">
					<p id="title-cadastro">Cadastrar voo</p>
					<div id="content-aero">
						<input name="aero-origem" type="text" id="origem" class="local"
							placeholder="Origem" list="opcoes" required> 
							<input name="aero-destino" type="text" id="destino" class="local"
							placeholder="Destino" list="opcoes" required>
					</div>
					<datalist id="opcoes">
						<option value="Aeroporto Internacional de Narita">Tokyo</option>
						<option value="Aeroporto de Paris Charles de Gaulle">Paris</option>
						<option value="Aeroporto Internacional Tom Jobim">Rio de Janeiro</option>
					</datalist>
					<div id="content-cadastro-voo">
						<div>
							<label>Data do voo: </label> <input name="dt-hr"
								type="datetime-local" id="data-voo" class="date" required>
						</div>
						<div>
							<input name="preco" type="text" id="preco-voo" class="preco"
								placeholder="PreÃ§o" maxlength="10" required>
						</div>
						<button type="submit" id="btn-cadastrar-voo">cadastrar</button>
					</div>
				</form>
				<form id="form-admin" action="updateVoo">
					<p id="title-editar">Editar voo</p>
					<div id="content-voo">
						<input name="idVoo" type="text" id="id-voo" placeholder="ID Voo" required>
					</div>
					<div id="content-cadastro-voo">
						<div>
							<label>Data do voo: </label> 
							<input name="dt_hr_decolagem" type="datetime-local" id="data-voo" class="date">
						</div>

						<button id="btn-editar-voo">Atualizar</button>
					</div>
				</form>
			</div>
			<div class="container">
				<%
				if (request.getAttribute("voo") != null) {
					for (int i = 0; i < voo.size(); i++) {
				%>
				
				<div class="card">
                        <div class="card-content">
                        	<h3>ID: <%=voo.get(i).getIdVoo()%></h3>
                            <p><span style="font-weight: bold; color: black;">Origem:</span> <%=voo.get(i).getAero_origem()%></p> 
                            
                            <hr>
                            <p><span style="font-weight: bold; color: black;">Destino:</span> <%=voo.get(i).getAero_destino()%></p>
                            <br/> 
                            <p>Data: <%=voo.get(i).getData_hr_decolagem()%></p>
                        </div>
                        <div class="card-preco">
                            <p>R$ <%=voo.get(i).getPrecoPassagem()%></p>
                            <a href="deleteVoo?idVoo=<%=voo.get(i).getIdVoo()%>">Excluir</a>
                        </div>
                    
                 </div>
                  <%
					}
					}
				%>
        
			</div>
		</div>
	</main>
</body>
</html>