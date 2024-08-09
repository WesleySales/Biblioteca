import java.util.ArrayList;
import java.util.List;

public class Autor {
    private static long geradorID_autor=100;
    private long ID_Autor;
    private String nome;
    protected List<Livro> livrosDoAutor = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nome) {
        this.ID_Autor = geradorID_autor++;
        this.nome = nome;
        this.livrosDoAutor = livrosDoAutor;
    }

    public long getID_Autor() {
        return ID_Autor;
    }



    public void setID_Autor(long ID_Autor) {
        this.ID_Autor = ID_Autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosDoAutor() {
        return livrosDoAutor;
    }

    public void setLivrosDoAutor(List<Livro> livrosDoAutor) {
        this.livrosDoAutor = livrosDoAutor;
    }

    @Override
    public String toString() {
        return
                "\nID Autor: " + ID_Autor +
                "   Nome: " + nome+
                "       Qtd livros: "+livrosDoAutor.size();
    }
}
