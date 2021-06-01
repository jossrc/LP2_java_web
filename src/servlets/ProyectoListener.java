package servlets;

import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ProyectoListener implements HttpSessionListener {

    public ProyectoListener() {

    }

    // Se ejecuta cuando se est� creando una sesion
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("==============================");
        System.out.println("Empezando a escuchar la sesi�n");
        System.out.println("==============================");
        System.out.println("ID Sesi�n          : " + arg0.getSession().getId());
        System.out.println("Fech/Hor acceso    : " + new SimpleDateFormat().format(arg0.getSession().getCreationTime()));
        System.out.println("==============================");

    }

    // Al cerrar o destruir la sesion
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("==============================");
        System.out.println("Dejando de escuchar la sesi�n");
        System.out.println("==============================");
        System.out.println("ID Sesi�n               : " + arg0.getSession().getId());
        System.out.println("Fech/Hor �ltimo acceso  : " + new SimpleDateFormat().format(arg0.getSession().getLastAccessedTime()));
        System.out.println("==============================");
    }

}
