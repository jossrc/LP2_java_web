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
      href="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/css/datepicker.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  	/>
    <title>Registro</title>
  </head>
  <body>
    <section id="registro" class="animate__animated animate__fadeIn">
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">
            <h2 class="text-center mb-2 text-primary">Registro de cuenta</h2>
            <form action="user" class="form mb-3 needs-validation" method="post" novalidate>
              <div class="mb-3">
                <label for="txtNombre" class="form-label">Nombre :</label>
                <input
                  type="text"
                  name="txtNombre"
                  class="form-control"
                  id="txtNombre"
                  placeholder="Ingrese su nombre"
                  required
                  maxlength="40"                  
                />
                <div class="invalid-feedback">
                  Se requiere de un nombre válido
                </div>
              </div>
              <div class="mb-3">
                <label for="txtApellido" class="form-label">Apellido :</label>
                <input
                  type="text"
                  class="form-control"
                  name="txtApellido"
                  id="txtApellido"
                  placeholder="Ingrese su apellido"
                  required
                  maxlength="40"
                />
                <div class="invalid-feedback">
                  Se requiere de un apellido válido
                </div>
              </div>
              <div class="mb-3">
                <label for="txtUsuario" class="form-label">Usuario :</label>
                <input
                  type="text"
                  name="txtUsuario"
                  class="form-control"
                  id="txtUsuario"
                  placeholder="Ingrese su usuario"
                  required
                  minlength="4"
                />
                <div class="invalid-feedback">
                  El usuario es obligatorio (+4)
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
                  maxlength="5"
                />
                <div class="invalid-feedback">
                  Se requiere una contraseña válida (max 5)
                </div>
              </div>
              <div class="mb-3">
                <label for="txtFechNac" class="form-label"
                  >Fecha de Nacimiento :</label
                >
                <input
                  type="text"
                  class="form-control"
                  name="txtFechNac"
                  id="txtFechNac"
                  autocomplete="off"
                  placeholder="Año/Mes/Día"
                  required
                />
                <div class="invalid-feedback">
                  La fecha de nacimiento es obligatoria
                </div>
              </div>

              <button type="submit" class="btn btn-primary" name="opcion" value="registro">Registrar</button>
            </form>
            <p>
              Si ya tiene cuenta, pulse
              <a href="login.jsp" class="primary-link">aquí</a>
            </p>
            
            <%
               try {
                     String mensaje = (String) request.getAttribute("mensajeRegistro");
                     if (!mensaje.isEmpty()) {           		
            %>
               <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    ${ mensajeRegistro }
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
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/datepicker-full.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/locales/es.js"></script>
    <script src="js/datepicker.js"></script>
    <script src="js/form-validator.js"></script>
  </body>
</html>
