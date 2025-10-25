package service;

import dao.ConvênioDAO;
import model.Convênio;
import java.util.List;

public class ConvênioService {
    private ConvênioDAO convênioDAO = new ConvênioDAO();

    public void cadastrarConvênio(Convênio c) {
        if (c == null)
            throw new IllegalArgumentException("Convênio não pode ser nulo.");
        if (c.getNome() == null || c.getNome().trim().isEmpty())
            throw new IllegalArgumentException("Nome do convênio é obrigatório.");

        convênioDAO.salvar(c);
    }

    public List<Convênio> listarConvenios() {
        return convênioDAO.listar();
    }
}

