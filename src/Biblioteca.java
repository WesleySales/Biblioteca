import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livrosDaBiblioteca = new ArrayList<>();
    protected List<Autor> autoresCadastrados = new ArrayList<>();
    private List<Usuario> usuariosCadastrados = new ArrayList<>();
    private List<Livro> livrosEmprestados = new ArrayList<>();

    public void cadastrarAutor(Autor autor){
        autoresCadastrados.add(autor);
    }
    public void cadastrarUsuario(String nome, int idade){
        usuariosCadastrados.add(new Usuario(nome,idade));
    }
    public void editarUsuario(String nome, String novoNome, int novaIdade){
        if(!usuariosCadastrados.isEmpty()){
            for(Usuario busca: usuariosCadastrados){
                if (busca.getNome().equalsIgnoreCase(nome)) {
                    busca.setNome(novoNome);
                    busca.setIdade(novaIdade);
                    System.out.println("Cadastro atualizado com sucesso!");
                }
            }
        }
        else {
            throw new RuntimeException("A lista de usuários está vazia");
        }
    }

    public Usuario pesquisarUsuarioPorID(Long ID_Usuario){
        Usuario usuario=null;
        if(!usuariosCadastrados.isEmpty()){
            for(Usuario u: usuariosCadastrados){
                if (u.getUserID()==ID_Usuario){
                    usuario= u;
                }
            }
        }
        return usuario;
    }
    public Livro pesquisarLivroPorID(Long ID_Livro){
        Livro livro=null;
        if(!livrosDaBiblioteca.isEmpty()){
            for(Livro l: livrosDaBiblioteca){
                if (l.getCodSKU()==ID_Livro){
                    livro =l;
                }
            }
        }
        return livro;
    }
    public void emprestarLivro(long ID_Usuario, long ID_Livro){
        pesquisarUsuarioPorID(ID_Usuario).listaDeEmprestimos.add(pesquisarLivroPorID(ID_Livro));
        pesquisarLivroPorID(ID_Livro).setEstoque(pesquisarLivroPorID(ID_Livro).getEstoque()-1);
        livrosEmprestados.add(pesquisarLivroPorID(ID_Livro));
    }
    public void cadastrarLivro(String titulo,long ID_Autor,int estoque){
        Livro livro = new Livro(titulo,ID_Autor,estoque);
        livrosDaBiblioteca.add(livro);
        pesquisarAutorPorID(ID_Autor).livrosDoAutor.add(livro);
        livro.setAutor(pesquisarAutorPorID(ID_Autor));
    }

    public void exibirLivrosPorAutor(long id) {
        if (!autoresCadastrados.isEmpty()) {
            for (Autor a : autoresCadastrados) {
                if (a.getID_Autor() == id) {
                    System.out.println(a.getLivrosDoAutor());
                }
            }
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public Autor pesquisarAutorPorID(long id){
        Autor autorEncontrado=null;
        if(!autoresCadastrados.isEmpty()){
            for(Autor a: autoresCadastrados){
                if (a.getID_Autor()==id){
                    autorEncontrado= a;
                }
            }
        }
        return autorEncontrado;

    }

    public List<Usuario> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public List<Livro> getLivrosDaBiblioteca() {
        return livrosDaBiblioteca;
    }

    public List<Autor> getAutoresCadastrados() {
        return autoresCadastrados;
    }
}
