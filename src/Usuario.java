import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static long geradorID = 1;
    private String nome;
    private int idade;
    private long userID;
    protected List<Livro> listaDeEmprestimos = new ArrayList<>();

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.userID = geradorID++;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return
                "\nNome= " + nome +", Idade= " + idade + ", Matricula= " + userID;
    }
}
