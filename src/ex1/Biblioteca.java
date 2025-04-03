package ex1;

import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livrosDisponiveis;
    public Biblioteca(String nome, List<Livro> livrosDisponiveis) {
        this.nome = nome;
        this.livrosDisponiveis = livrosDisponiveis;
    }
    public List<Livro> emprestarLivro(List<Livro> livrosDisponiveis){
        for (Livro livro : livrosDisponiveis) {
            if (livro.getQuantidade() >= 1) {
                return livro.getNome();
            }
        }
        return livrosDisponiveis;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }
    public void setLivrosDisponiveis(List<Livro> livrosDisponiveis) {
        this.livrosDisponiveis = livrosDisponiveis;
    }
    @Override
    public String toString() {
        return "Biblioteca [nome=" + nome + ", livrosDisponiveis=" + livrosDisponiveis + "]";
    }
    
}
