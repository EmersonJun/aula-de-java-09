

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
    Livro livro = new Livro("mobdick", "jonas", "romance", 7);
    Livro livro2 = new Livro("batman", "joao", "acao", 1);
    Livro livro3 = new Livro("divina comedia", "homi veio", "romance", 0);

    List<Livro> listaLivros = new ArrayList<>();
        listaLivros.add(livro);
        listaLivros.add(livro2);
        listaLivros.add(livro3);

        Biblioteca biblioteca = new Biblioteca("biblioteca central", listaLivros);
        Cliente cliente = new Cliente("carlos");

        List<Livro> livrosParaEmprestar = new ArrayList<>();
        livrosParaEmprestar.add(new Livro("mobdick", "", "", 5) );
        System.out.println("");
        livrosParaEmprestar.add(new Livro("batman", "", "", 1));

        List<Livro> livrosEmprestados = biblioteca.emprestarLivros(livrosParaEmprestar);

        // Adicionando livros emprestados ao cliente
        cliente.setLivros(livrosEmprestados);

        // Exibindo os livros que o cliente pegou emprestado
        System.out.println("Livros emprestados para " + cliente.getNome() + ": " + cliente.getLivros());

        // Exibindo o estoque atualizado da biblioteca
        System.out.println("apos o emprestimo");
        for (Livro livroDisponivel : biblioteca.getLivrosDisponiveis()) {
            System.out.println("Livro: " + livroDisponivel.getNome() + " | Quantidade: " + livroDisponivel.getQuantidade());
        }
        biblioteca.devolverLivros(cliente.getLivros());

        // Zerando a lista de livros do cliente após a devolução
        System.out.println("###########################################################");
        System.out.println("apos a devolucao");
        cliente.setLivros(new ArrayList<>());
        for (Livro livroDisponivel : biblioteca.getLivrosDisponiveis()) {
            System.out.println("Livro: " + livroDisponivel.getNome() + " | Quantidade: " + livroDisponivel.getQuantidade());
        }
    }
}
