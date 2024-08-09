public class Livro {
    private static long geradorSKU = 10065;
    private long codSKU;
    private String titulo;
    private Autor autor;
    private int estoque;

    public Livro(String titulo, long ID_Autor, int estoque) {
        this.codSKU = geradorSKU++;
        this.titulo = titulo;
        this.autor = autor;
        this.estoque = estoque;
    }

    public long getCodSKU() {
        return codSKU;
    }

    public void setCodSKU(long codSKU) {
        this.codSKU = codSKU;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return
                "\n\nCódigo: " + codSKU +
                "\nTitulo= " + titulo +
                "\nAutor= " + autor.getNome() +
                "\nEstoque= " + estoque;
    }
}
