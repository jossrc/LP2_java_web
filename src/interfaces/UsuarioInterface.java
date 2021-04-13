package interfaces;

import model.Usuario;

public interface UsuarioInterface {

    public int registrar(Usuario usuario);

    public Usuario validar(String usuario, String password);

}
