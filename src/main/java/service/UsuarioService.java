package service;
import java.util.List;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Inversion;
import model.Usuario;
import model.UsuarioDaoJpa;

@ApplicationScoped
public class UsuarioService {
	
	@Inject
    private UsuarioDaoJpa usuarioDao;
	
	
	@Transactional
    public void guardarInversionToUsuario(String nombreInversion, double monto, int plazo, double tasa, int idUsuario) {
        Usuario usuario = usuarioDao.obtenerUsuario(idUsuario);
        if (usuario != null) {
            Inversion nuevaInversion = new Inversion(nombreInversion, monto, plazo, tasa);
            usuario.agregarInversionUsuario(nuevaInversion);
            usuarioDao.actualizarUsuario(usuario);  // Cascade persiste la inversión automáticamente
        }
    }
	@Transactional
    public void guardarNuevoUsuario(String nombre) {
        Usuario nuevo = new Usuario(nombre);
        usuarioDao.agregarUsuario(nuevo);
    }

    public List<Usuario> listarTodosLosUsuarios() {
        return usuarioDao.obtenerTodos();
    }
	
    public Usuario obtenerUsuarioConInversiones(int id) {
        Usuario u = usuarioDao.obtenerUsuario(id);
        if (u != null) 
            u.getHistorialInversiones().size(); // Forzar carga si es LAZY y la sesión sigue abierta
        
        return u;
    }
	
	
}
