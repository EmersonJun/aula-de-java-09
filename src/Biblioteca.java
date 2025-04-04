

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nome;
    private List<Livro> livrosDisponiveis;
    public Biblioteca(String nome, List<Livro> livrosDisponiveis) {
        this.nome = nome;
        this.livrosDisponiveis = livrosDisponiveis;
    }
    public List<Livro> emprestarLivros(List<Livro> livrosPedidos) {
        List<Livro> livrosEmprestados = new ArrayList<>();
    
        for (Livro solicitado : livrosPedidos) {
            if (solicitado != null) { // Evita NullPointerException
                List<Livro> encontrados = buscarLivro(solicitado.getNome()); // Retorna uma lista
                
                if (!encontrados.isEmpty()) { // Verifica se encontrou algum livro
                    Livro disponivel = encontrados.get(0); // Pega o primeiro encontrado
                    
                    if (disponivel.getQuantidade() > 0) {
                        // Diminui a quantidade disponível do livro na biblioteca
                        disponivel.setQuantidade(disponivel.getQuantidade() - 1);
                        
                        // Adiciona um novo livro na lista de empréstimo
                        livrosEmprestados.add(new Livro(disponivel.getNome(), disponivel.getAutor(), disponivel.getGenero(), 1));
                    }
                }
            }
        }
        return livrosEmprestados;
    }
    
    public void devolverLivros(List<Livro> livrosDevolvidos) {
        for (Livro devolvido : livrosDevolvidos) {
            for (Livro disponivel : livrosDisponiveis) {
                if (disponivel.getNome().equalsIgnoreCase(devolvido.getNome())) {
                    // Aumenta a quantidade do livro devolvido
                    disponivel.setQuantidade(disponivel.getQuantidade() + devolvido.getQuantidade());
                    break;
                }
            }
        }
    }
    public List<Livro> buscarLivro(String nomeLivro) {
    return livrosDisponiveis.stream()
        .filter(livro -> livro.getNome().equalsIgnoreCase(nomeLivro))
        .collect(Collectors.toList()); // Retorna uma lista com todos os livros encontrados
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
