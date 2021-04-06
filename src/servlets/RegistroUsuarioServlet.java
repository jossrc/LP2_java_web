package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuario;
import model.Usuario;

@WebServlet(name = "regusu", urlPatterns = { "/regusu" })
public class RegistroUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ingresó al Servlet RegistroUsuario");

        String mensajeRegistro = "";
        String url;

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String fechNac = request.getParameter("txtFechNac");

        Usuario usuarioBD = new Usuario(nombre, apellido, usuario, password, fechNac);

        GestionUsuario gestionUsuario = new GestionUsuario();
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

}
