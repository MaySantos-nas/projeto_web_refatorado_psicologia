package service;

import dao.PsicologoDAO;
import model.Psicologo;
import java.util.List;

public class PsicologoService {
    private PsicologoDAO psicologoDAO = new PsicologoDAO();

    public void cadastrarPsicologo(Psicologo p) {
        if (p == null)
            throw new IllegalArgumentException("Psicólogo não pode ser nulo.");
        if (p.getNome() == null || p.getNome().trim().isEmpty())
            throw new IllegalArgumentException("Nome é obrigatório.");
        if (p.getCrp().trim().isEmpty() || p.getCrp() == null)
            throw new IllegalArgumentException("CRP é obrigatório.");

        psicologoDAO.salvar(p);
    }

    public List<Psicologo> listarPsicologos() {
        return psicologoDAO.listar();
    }
}

