public class LivroDAO {
 
  @PersistenceContext
  private EntityManager manager;
 
  public Livro buscaLivroComId(Long id) {
 
    Livro livro = manager.createQuery("select l from Livro l left join fetch l.autores a where l.id = :id", Livro.class)
        .setParameter("id", id).getSingleResult();
 
    return livro;
  }
 
  public List<Livro> listaTodos() {
    return manager.createQuery("select l from Livro l left join fetch l.autores a", Livro.class).getResultList();
  }
 
  public void adicionar(Livro livro) {
    manager.persist(livro);
  }
 
  public void atualiza(Livro livro) {
    manager.merge(livro);
  }
 
}