@Entity
public class Autor {
   
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;  
  private String nome;
   
  @Deprecated
  private Autor(){}
   
  public Autor(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }
 
  public Long getId() {
    return id;
  }
 
  public String getNome() {
    return nome;
  }
   
}