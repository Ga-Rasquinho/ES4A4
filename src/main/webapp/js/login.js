function changeLogin(){
    let btLog = document.getElementById("btn-esc-log");
    let btReg = document.getElementById("btn-esc-reg");
    let formLog = document.getElementById("form-log");
    let formReg = document.getElementById("form-reg");
    if(btLog.className == "btn"){
        btLog.classList.remove("btn");
        btLog.classList.add("btn-esc");
        btReg.classList.remove("btn-esc");
        btReg.classList.add("btn");
        
        formLog.classList.remove("hide");
        formReg.classList.add("hide");

    }
}


function changeRegistro(){
    let btLog = document.getElementById("btn-esc-log");
    let btReg = document.getElementById("btn-esc-reg");
    let formLog = document.getElementById("form-log");
    let formReg = document.getElementById("form-reg");
    if(btReg.className == "btn"){
        btReg.classList.remove("btn");
        btReg.classList.add("btn-esc");
        btLog.classList.remove("btn-esc");
        btLog.classList.add("btn"); 

        formReg.classList.remove("hide");
        formLog.classList.add("hide");
        
       
    }
}

function changeIconSenha(id){
    let iconSenha = document.getElementById(id);
    let url = iconSenha.getAttribute("src");
    if(url == "imagens/hide-senha.png")
        iconSenha.setAttribute("src", "imagens/show-senha.png")
    else
        iconSenha.setAttribute("src", "imagens/hide-senha.png")
    
}

function mostrarSenha(id){
    let inputSenha = document.getElementById(id);

    if(inputSenha.type == "password")
        inputSenha.type = "text";
    else
        inputSenha.type = "password";
}