package service;

import dao.ConsultaDAO;
import model.Consulta;
import java.util.List;

public class ConsultaService {
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public void cadastrarConsulta(Consulta c) {
        if (c == null)
            throw new IllegalArgumentException("Consulta não pode ser nula.");
        if (c.getDataConsulta() == null)
            throw new IllegalArgumentException("Data da consulta é obrigatória.");

        consultaDAO.salvar(c);
    }

    public List<Consulta> listarConsultas() {
        return consultaDAO.listar();
    }
}
