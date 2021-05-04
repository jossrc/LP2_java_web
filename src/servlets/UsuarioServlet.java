package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioDTO;
import mantenimientos.MySQLUsuarioDAO;

@WebServlet(name = "user", urlPatterns = { "/user" })
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        System.out.println("Opción seleccionada : " + opcion);

        switch (opcion) {
        case "login":
            login(request, response);
            break;
        case "registro":
            registro(request, response);
            break;
        default:
            break;
        }

    }

    private void registro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensajeRegistro = "";
        String url;

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String fechNac = request.getParameter("txtFechNac");

        UsuarioDTO usuarioBD = new UsuarioDTO(nombre, apellido, usuario, password, fechNac);

        MySQLUsuarioDAO gestionUsuario = new MySQLUsuarioDAO();
        int ok = gestionUsuario.registrar(usuarioBD);

        if (ok == 0) {
            mensajeRegistro += "Error al registrar los datos, revisar";
            url = "/registro.jsp";
        } else {
            mensajeRegistro += "Nuevo usuario agregado, inicie sesión";
            url = "/login.jsp";
        }

        request.setAttribute("mensajeRegistro", mensajeRegistro);
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";

        String usuario = request.getParameter("txtUsuario").trim();
        String password = request.getParameter("txtPassword").trim();

        if (usuario.equalsIgnoreCase("admin") && password.equals("12345")) {
            url = "/principal.jsp";
            request.setAttribute("saludo", "Bienvenido " + usuario);
        } else {
            url = "/login.jsp";
            request.setAttribute("mensaje", "Usuario o clave incorrecto");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

}
