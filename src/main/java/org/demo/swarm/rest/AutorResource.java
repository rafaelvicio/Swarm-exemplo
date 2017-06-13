@Path("livros/{livroId:\\d+}/autores")
@Stateless
public class AutorResource {
   
  @Inject
  private LivroDAO livroDao;
   
  @Inject
  private AutorDAO autorDao;
   
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Autor> listaDeAutoresDoLivro(@PathParam("livroId") Long livroId){
     
    return livroDao.buscaLivroComId(livroId).getAutores();
     
  }
   
  @GET
  @Path("{autorId:\\d+}")
  @Produces(MediaType.APPLICATION_JSON)
  public Autor autorDoLivro(@PathParam("autorId") Long autorId){
      
    return autorDao.buscaAutorComId(autorId);
  }
   
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response adicionaAutor(@PathParam("livroId") Long livroId, Autor autor){
     
    Livro livro = livroDao.buscaLivroComId(livroId);
     
    autorDao.adiciona(autor);
     
    livro.adicionaAutor(autor);
     
    livroDao.atualiza(livro);
     
    return Response
        .created(URI.create("/livros/" + livroId + "/autores/" + autor.getId()) )
        .entity(autor)
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
 
}