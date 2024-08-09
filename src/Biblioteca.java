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
        if(pesquisarUsuarioPorID(ID_Usuario).listaDeEmprestimos.size()<3){
            pesquisarUsuarioPorID(ID_Usuario).listaDeEmprestimos.add(pesquisarLivroPorID(ID_Livro));
            pesquisarLivroPorID(ID_Livro).setEstoque(pesquisarLivroPorID(ID_Livro).getEstoque()-1);
            livrosEmprestados.add(pesquisarLivroPorID(ID_Livro));
            System.out.println(String.format("%s realizou o emprestimo do livro %s",pesquisarUsuarioPorID(ID_Usuario).getNome(),pesquisarLivroPorID(ID_Livro).getTitulo()));
        } else {
            System.out.println(String.format("%s bateu o limite de emprestimos simultaneos",pesquisarUsuarioPorID(ID_Usuario).getNome()));
        }
    }

    //Cadastra o livro e cria objetos separadamente conforme estoque,
    //Assim cada livro é gerado com seu proprio código
    //Alem disso o livro é adicionado a lista de livros do autor, dentro do objeto autor
    public void cadastrarLivro(String titulo,long ID_Autor,int estoque){
        for(int i =0;i<estoque;i++){
            Livro livro = new Livro(titulo,ID_Autor,estoque);
            livrosDaBiblioteca.add(livro);
            pesquisarAutorPorID(ID_Autor).livrosDoAutor.add(livro);
            livro.setAutor(pesquisarAutorPorID(ID_Autor));
        }
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

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public List<Autor> getAutoresCadastrados() {
        return autoresCadastrados;
    }
}
