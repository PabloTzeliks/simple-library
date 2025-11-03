package pablo.tzeliks.model;

import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private Livro livro;
    private LocalDate data_emprestimo;
    private LocalDate data_devolucao;

    public Emprestimo(int id, Livro livro, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.id = id;
        this.livro = livro;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "Livro: " + livro +
                "Data Empréstimo: " + data_emprestimo +
                "Data Devolução: " + data_devolucao;
    }
}