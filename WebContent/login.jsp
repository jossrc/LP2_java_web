<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  	/>
    <title>Login</title>
  </head>
  <body>
    <section id="login" class="animate__animated animate__fadeIn">
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">
            <h2 class="text-center mb-2 text-primary">Acceso al Sistema</h2>
            <form action="ingreso" class="form mb-3 needs-validation" method="post" novalidate>
              <div class="mb-3">
                <label for="txtUsuario" class="form-label">Usuario :</label>
                <input
                  type="text"
                  name="txtUsuario"
                  class="form-control"
                  id="txtUsuario"
                  placeholder="Ingrese su usuario"
                  required
                />
                <div class="invalid-feedback">
                  Se requiere de un usuario válido
                </div>
              </div>
              <div class="mb-3">
                <label for="txtPassword" class="form-label">Contraseña :</label>
                <input
                  type="password"
                  class="form-control"
                  name="txtPassword"
                  id="txtPassword"
                  placeholder="Ingrese Password"
                  required
                />
                <div class="invalid-feedback">
                  La contraseña es requerida
                </div>
              </div>

              <button type="submit" class="btn btn-primary">Ingresar</button>
            </form>
            <p>
              Para registrar su cuenta, pulse
              <a href="registro.jsp" class="primary-link">aquí</a>
            </p>
            
            <%
               try {
                     String mensaje = (String) request.getAttribute("mensajeRegistro");
                     if (!mensaje.isEmpty()) {           		
            %>
               <div class="alert alert-success alert-dismissible fade show" role="alert">
                    ${ mensajeRegistro }
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
               </div>  
            <%
                        }	
                     }
                catch(Exception e) { }
             %>
			
            <%
               try {
                     String mensaje = (String) request.getAttribute("mensaje");
                     if (!mensaje.isEmpty()) {           		
            %>
               <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    ${ mensaje }
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
               </div>  
            <%
                        }	
                     }
                catch(Exception e) { }
             %>

          </div>
        </div>
      </div>
    </section>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
    <script src="js/form-validator.js"></script>
  </body>
</html>
