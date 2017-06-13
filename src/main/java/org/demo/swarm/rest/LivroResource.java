@Path("livros")
@Stateless
public class LivroResource {
 
  @Inject
  private LivroDAO livroDao;
 
   
  @Path("{id:\\d+}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Livro buscaPorId(@PathParam("id") Long id){
    return livroDao.buscaLivroComId(id);
  }
   
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Livro> listaDeLivros(){
    return livroDao.listaTodos();
  }
   
   
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response adicionaLivro(Livro livro){
     
    livroDao.adicionar(livro);
     
    return Response
          .created(URI.create("/livros/" + livro.getId()))
          .entity(livro)
          .type(MediaType.APPLICATION_JSON)
        .build();
     
  }
   
   
}