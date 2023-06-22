
function validar() {
	let nome = frmContato.nome.value;
	if (nome == "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}

}