package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ingreso", urlPatterns = { "/ingreso" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Mundo desde un servlet");
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

        // response.sendRedirect(url);
        request.getRequestDispatcher(url).forward(request, response);

    }

}
