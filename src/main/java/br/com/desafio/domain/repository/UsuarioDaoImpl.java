package br.com.desafio.domain.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
  private static final Logger logger = LoggerFactory.getLogger(UsuarioDaoImpl.class);

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void salvarUsuario(Usuario u) {
    Session session = this.sessionFactory.getCurrentSession();
    session.persist(u);
    logger.info("Usuario salvo com sucesso");
  }



  @Override
  public void atualizarUsuario(Usuario u) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(u);
    logger.info("Usuario atualizado com sucesso");

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Usuario> listarUsuarios() {
    Session session = this.sessionFactory.getCurrentSession();
    List<Usuario> listarUsuarios = session.createQuery("from Usuario").list();
    logger.info("Lista de Usuarios carregada na memoria");
    return listarUsuarios;
  }
  
  @Override
  public void removerUsuario(Integer id) {
    Session session = this.sessionFactory.getCurrentSession();
    Usuario u = (Usuario) session.load(Usuario.class, new Integer(id));
    if (null != u) {
      session.delete(u);
    }
    logger.info("Usuario removido com sucesso");
  }

  @Override
  public Usuario getUsuarioPorId(Integer id) {
    Session session = this.sessionFactory.getCurrentSession();
    Usuario u = (Usuario) session.get(Usuario.class, new Integer(id));
    logger.info("Usuario carregado na memoria");
    return u;
  }
  
}
