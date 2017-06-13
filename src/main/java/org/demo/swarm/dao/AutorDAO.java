public class AutorDAO {
 
  @PersistenceContext
  private EntityManager manager;
 
  public Autor buscaAutorComId(Long id) {
    return manager.find(Autor.class, id);
  }
 
  public void adiciona(Autor autor) {
    manager.persist(autor);
  }
   
}