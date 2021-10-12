function btnMenuAnimation(){
    if(btnUsuario.classList.contains('btn-clicked')){
        btnUsuario.classList.remove('btn-clicked');
        btnUsuario.classList.add('btn-unclicked');
    }else if(btnUsuario.classList.contains('btn-unclicked')){
        btnUsuario.classList.remove('btn-unclicked');
        btnUsuario.classList.add('btn-clicked');
    }
    else{
        btnUsuario.classList.add('btn-clicked');
    }
}



let btnUsuario = document.getElementById('btn-usuarios');
let btnAgregar = document.getElementById('btn-agregar');

btnUsuario.addEventListener('click', btnMenuAnimation);
btnAgregar.addEventListener('click',agregarFila);
