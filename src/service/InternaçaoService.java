package service;

import dao.InternaçaoDAO;
import model.Internaçao;
import java.util.List;

public class InternaçaoService {
    private InternaçaoDAO internaçaoDAO = new InternaçaoDAO();

    public void cadastrarInternaçao(Internaçao i) {
        if (i == null)
            throw new IllegalArgumentException("Internação não pode ser nula.");
        if (i.getDataEntrada() == null)
            throw new IllegalArgumentException("Data de entrada é obrigatória.");

        internaçaoDAO.salvar(i);
    }

    public List<Internaçao> listarInternacoes() {
        return internaçaoDAO.listar();
    }
}
