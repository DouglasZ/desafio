package br.com.desafio.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.domain.entity.Usuario;
import br.com.desafio.domain.repository.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  	
  private UsuarioDao UsuarioDao;
  
  public void setUsuarioDao(UsuarioDao UsuarioDao) {
    this.UsuarioDao = UsuarioDao;
  }
  
  @Override
  @Transactional
  public void salvarUsuario(Usuario u) {
    this.UsuarioDao.salvarUsuario(u);
  }

  @Override
  @Transactional
  public void atualizarUsuario(Usuario u) {
    this.UsuarioDao.atualizarUsuario(u);
  }

  @Override
  @Transactional
  public List<Usuario> listarUsuarios() {
    return this.UsuarioDao.listarUsuarios();
  }

  @Override
  @Transactional
  public void removerUsuario(Integer id) {
    this.UsuarioDao.removerUsuario(id);
  }

  @Override
  @Transactional
  public Usuario getUsuarioPorId(Integer id) {
    return this.UsuarioDao.getUsuarioPorId(id);
  }


}