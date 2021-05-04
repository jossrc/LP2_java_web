package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {

    public int registrar(UsuarioDTO usuario);

    public UsuarioDTO validar(String usuario, String password);

}
