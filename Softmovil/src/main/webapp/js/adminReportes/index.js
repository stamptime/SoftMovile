
/* -------------------------------------------------------------------------- */
/*                          DECLARACION DE FUNCIONES                          */
/* -------------------------------------------------------------------------- */

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

function visible (){
    tablas.forEach((x,iter) => {
        if(x.id == this.id){
            x.classList.toggle('hidden');
        }else{
            x.classList.add('hidden');
        }
    })

}


/* ----------------------------- Funcionamiento ----------------------------- */

const formulario = document.forms[0];
const tablas = document.querySelectorAll('.table');
const btns = document.querySelectorAll('.btn');


btns.forEach(x => {
    x.addEventListener('click',visible);
});

formulario.addEventListener('submit',(event) =>{
    event.preventDefault();
})


// for(i in formulario){
//     console.log(i);
// }


let btnUsuario = document.getElementById('btn-usuarios');

btnUsuario.addEventListener('click', btnMenuAnimation);
