package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import dao.DAOFactory;
import mantenimientos.MySQLUsuarioDAO;

@WebServlet(name = "user", urlPatterns = { "/user" })
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
        opcion = (opcion == null) ? "logout" : opcion;

        System.out.println("Opción seleccionada : " + opcion);

        switch (opcion) {
        case "login":
            login(request, response);
            break;
        case "logout":
            logout(request, response);
            break;
        case "registro":
            registro(request, response);
            break;
        default:
            logout(request, response);
            break;
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Cerrando la sesión actual");
        System.out.println("ID Sesión " + request.getSession().getId());

        request.getSession().invalidate();

        response.sendRedirect("login.jsp");

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

        // Trabajando con sesiones
        HttpSession mySession = request.getSession();
        System.out.println("ID Sesión          : " + mySession.getId());
        System.out.println("Fech/Hor creación  : " + new SimpleDateFormat().format(mySession.getCreationTime()));
        System.out.println("Tiemp inactividad  : " + mySession.getMaxInactiveInterval());

        String url = "";

        String usuario = request.getParameter("txtUsuario").trim();
        String password = request.getParameter("txtPassword").trim();

        System.out.println(usuario);
        System.out.println(password);

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UsuarioDTO usuarioDTO = factory.getUsuarioDAO().validar(usuario, password);

        if (usuarioDTO != null) {
            url = "/principal.jsp";
            request.setAttribute("saludo", "Bienvenido " + usuario);
            // request.setAttribute("usuarioEncontrado", usuarioDTO);
            request.getSession().setAttribute("usuarioEncontrado", usuarioDTO);
            // ${usuarioEncontrado.nombre} ->
        } else {
            url = "/login.jsp";
            request.setAttribute("mensaje", "Usuario o clave incorrecto");
        }

        /*
         * if (usuario.equalsIgnoreCase("admin") && password.equals("12345")) { url =
         * "/principal.jsp"; request.setAttribute("saludo", "Bienvenido " + usuario); }
         * else { url = "/login.jsp"; request.setAttribute("mensaje",
         * "Usuario o clave incorrecto"); }
         */

        request.getRequestDispatcher(url).forward(request, response);

    }

}
