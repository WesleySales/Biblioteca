public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor("Julio Cesar");
        biblioteca.cadastrarAutor(autor1);
        Autor autor2 = new Autor("Italo Sena");
        biblioteca.cadastrarAutor(autor2);
        Autor autor3 = new Autor("Maria Madalena");
        biblioteca.cadastrarAutor(autor3);

        biblioteca.cadastrarLivro("Gelo e Fogo",100,20);
        biblioteca.cadastrarLivro("Livro 2",100,2);
        biblioteca.cadastrarLivro("Livro 3",100,20);
        biblioteca.cadastrarLivro("Livro 4",102,20);
        biblioteca.cadastrarLivro("Livro 5",102,3);

        biblioteca.cadastrarUsuario("Joao Silva",18);
        biblioteca.cadastrarUsuario("Vitor Barreto",22);

        System.out.println(biblioteca.getLivrosDaBiblioteca());

        biblioteca.emprestarLivro(2700,10065);
        biblioteca.emprestarLivro(2700,10069);

        System.out.println(biblioteca.getLivrosDaBiblioteca());

    }
}
