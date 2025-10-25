package service;

import dao.ProntuarioDAO;
import model.Prontuario;
import java.util.List;

public class ProntuarioService {
    private ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

    public void cadastrarProntuario(Prontuario p) {
        if (p == null)
            throw new IllegalArgumentException("Prontuário não pode ser nulo.");
        if (p.getDescricao() == null || p.getDescricao().trim().isEmpty())
            throw new IllegalArgumentException("Descrição do prontuário é obrigatória.");

        prontuarioDAO.salvar(p);
    }

    public List<Prontuario> listarProntuarios() {
        return prontuarioDAO.listar();
    }
}

