<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import = "model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
    
</head>
<body>
    <header>
        <div class="logo-container">
          <a href="index.html"><img class="imgLogo" src="imagens/newLogo.png"></a>
          <p id="logo">SKY-IFSP</p>
        </div>        
    </header>
    <main>
        <div id="painel">
            <div id="login-registro">
                <div id="btn-esc">
                    <button id="btn-esc-log" class="btn-esc" onclick="changeLogin()">Logar</button>
                    <button id="btn-esc-reg" class="btn" onclick="changeRegistro()">Registrar</button>
                </div>
                
                <form id="form-log" action="login" method="POST" class="log">
                    <p id="title-log">Login</p>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/userLog.png" alt="avatar genérico de usuário"/>
                        <input type="email" id="log-email" name="email" placeholder="E-mail" required/>
                    </div>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/senha.png" alt="icone de cadeado trancado"/>
                        <input type="password" id="log-senha" name="senha" placeholder="Senha" required/>
                        <img id="show-hide-senha-log" class="img-form" src="imagens/hide-senha.png" alt="icone de olho fechado" onclick="changeIconSenha('show-hide-senha-log'), mostrarSenha('log-senha')"/>
                    </div>
                    <button id="btn-log" type="submit">Entrar</button>
                </form>
            <% String mensagem = (String) request.getAttribute("mensagem"); %>
    <% if (mensagem != null) { %>
        <p><%= mensagem %></p>
    <% } %>

                <form id="form-reg" action="RegistrarUsuario" class="reg hide"  method="GET">
                    <p id="title-reg">Cadastro</p>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/userLog.png" alt="ícone de avatar genérico de usuário"/>
                        <input name="nome" type="text" id="reg-nome" placeholder="Nome" maxlength="40" pattern="[a-zA-Z-\s]{1,40}" title="Somente letras no mínimo 1 caractere e no máximo 40"required/>
                    </div>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/CPF.png" alt="icone de um documento de identificação"/>
                        <input name="cpf" type="text" id="reg-cpf" placeholder="CPF" maxlength="11" pattern="[0-9]{11}" title="11 algarismos de 0-9" required/>
                    </div>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/email.png" alt="icone de arroba"/>
                        <input name="email" type="email" id="reg-email" name="email" placeholder="E-mail" required/>
                    </div>
                    <div class="content">
                        <span class="flag"></span>
                        <img class="img-form" src="imagens/senha.png" alt="icone de cadeado trancado"/>
                        <input type="password" id="reg-senha" name="senha" placeholder="Senha" maxlength="8" required/>
                        <img id="show-hide-senha-reg" class="img-form" src="imagens/hide-senha.png" alt="icone de olho fechado" onclick="changeIconSenha('show-hide-senha-reg'), mostrarSenha('reg-senha')"/>
                    </div>
                    <button id="btn-reg" value="Registrar"  type="submit">Registrar </button>
                </form>
            </div>
        </div>  
        <script src="js/login.js"></script>  
</body>
</html>