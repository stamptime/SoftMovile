<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Softmovil - Login</title>
    <link
      rel="stylesheet"
      href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
      integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/login.css"/>
</head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">
          <form method="GET" action="./SoftmovielServerlet" class="sign-in-form">
            <h2 class="title">Iniciar Sesión</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name='username' class="username" placeholder="Usuario" />
            </div>

            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input
                type="password"
                class="password"
                placeholder="Contraseña"
                name="password"
              />
            </div>
            <input type="submit" name="accion" value="Ingresar" class="btn solid" />

            <p class="social-text">O Ingresa Con Tus Redes Sociales</p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
            </div>
          </form>
        </div>
      </div>
      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>SoftMovil</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit
              ullam deserunt totam vero doloremque quaerat.
            </p>
          </div>
          <img src="img/Lost.svg" class="image" alt="shopping" />
        </div>
      </div> 
    </div>
    <script src="https://kit.fontawesome.com/64d58efce2.js"></script>
  </body>
</html>