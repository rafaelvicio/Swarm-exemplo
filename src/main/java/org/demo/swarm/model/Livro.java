package org.demo.swarm.model;

@Entity
public class Livro {
   
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String descricao;
   
  @ManyToMany
  private List<Autor> autores;
   
  @Deprecated
  private Livro(){}
     
  public Livro(Long id, String titulo, String descricao, List<Autor> autores) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.autores = autores;
  }
   
   
  public Long getId() {
    return id;
  }
   
  public String getTitulo() {
    return titulo;
  }
   
  public String getDescricao() {
    return descricao;
  }
 
  public List<Autor> getAutores() {
    return autores;
  }
 
 
  public void adicionaAutor(Autor autor) {
    this.autores.add(autor);
  }
   
}