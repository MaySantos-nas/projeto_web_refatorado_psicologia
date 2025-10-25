package service;

import dao.PacienteDAO;
import model.Paciente;
import java.util.List;

public class PacienteService {
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void cadastrarPaciente(Paciente paciente) {
        if (paciente == null)
            throw new IllegalArgumentException("Paciente não pode ser nulo.");
        if (paciente.getNome() == null || paciente.getNome().trim().isEmpty())
            throw new IllegalArgumentException("Nome do paciente é obrigatório.");
        if (paciente.getCpf() == null || paciente.getCpf().trim().isEmpty())
            throw new IllegalArgumentException("CPF é obrigatório.");

        // Checa duplicidade
        if (pacienteDAO.findByCpf(paciente.getCpf()) != null)
            throw new IllegalStateException("Já existe um paciente com este CPF.");

        pacienteDAO.salvar(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDAO.listar();
    }

    public void salvarPaciente(Paciente p) {
        System.out.println("Método salvarPaciente() ainda em desenvolvimento."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

