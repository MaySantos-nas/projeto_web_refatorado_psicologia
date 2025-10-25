package service;

import dao.QuartoDAO;
import model.Quarto;
import java.util.List;

public class QuartoService {
    private QuartoDAO quartoDAO = new QuartoDAO();

    // Método principal que salva o quarto
    public void salvarQuarto(Quarto q) {
        if (q == null) {
            throw new IllegalArgumentException("Quarto não pode ser nulo.");
        }

        
        if (q.getNumero() <= 0) {
    throw new IllegalArgumentException("Número do quarto deve ser maior que zero.");
}

        quartoDAO.salvar(q);
    }

    // Lista todos os quartos
    public List<Quarto> listarQuartos() {
        return quartoDAO.listar();
    }

    // Métodos "em desenvolvimento"
    public void cadastrarQuarto(Quarto quarto) {
        System.out.println("Método cadastrarQuarto() ainda em desenvolvimento.");
    }

    public void atualizarQuarto(Quarto quarto) {
        System.out.println("Método atualizarQuarto() ainda em desenvolvimento.");
    }

    public void deletarQuarto(int id) {
        System.out.println("Método deletarQuarto() ainda em desenvolvimento.");
    }
}


