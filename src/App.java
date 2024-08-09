public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        //Cadastro dos autores
        Autor autor1 = new Autor("Julio Cesar");
        biblioteca.cadastrarAutor(autor1);
        Autor autor2 = new Autor("Italo Sena");
        biblioteca.cadastrarAutor(autor2);
        Autor autor3 = new Autor("Maria Madalena");
        biblioteca.cadastrarAutor(autor3);

        //Cadastro de livros com titulo, autor e estoque. O codigo do livro é gerado automaticamente.
        biblioteca.cadastrarLivro("Gelo e Fogo",100,3);
        biblioteca.cadastrarLivro("Livro 2",100,2);
        biblioteca.cadastrarLivro("Livro 3",100,2);
        biblioteca.cadastrarLivro("Livro 4",102,5);
        biblioteca.cadastrarLivro("Livro 5",102,3);

        //Cadastro de usuarios com nome e idade. O ID é gerado automaticamente.
        biblioteca.cadastrarUsuario("Joao Silva",18);
        biblioteca.cadastrarUsuario("Vitor Barreto",22);

        //System.out.println(biblioteca.getLivrosDaBiblioteca());

        biblioteca.emprestarLivro(1,10065);
        biblioteca.emprestarLivro(1,10069);
        biblioteca.emprestarLivro(1,10068);
        biblioteca.emprestarLivro(1,10072);

        System.out.println(biblioteca.getLivrosEmprestados());

    }
}
