package br.com.desafio.domain.repository;

import java.util.List;

import br.com.desafio.domain.entity.Usuario;

public interface UsuarioDao {

	  public void salvarUsuario(Usuario u);
	  public void atualizarUsuario(Usuario u);
	  public List<Usuario> listarUsuarios();
	  public void removerUsuario(Integer id);
	  public Usuario getUsuarioPorId(Integer id);
}
