package view;

import model.Paciente;
import service.PacienteService;
import service.PsicologoService;
import model.Psicologo;
import model.Consulta;
import service.ConsultaService;
import model.Convênio;
import service.ConvênioService;
import model.Quarto;
import service.QuartoService;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INÍCIO DOS TESTES ===");

        // Paciente (usa PatientService -> PacienteDAO (JDBC) ou em memória)
        try {
            PacienteService ps = new PacienteService();
            Paciente p = new Paciente();
            p.setNome("Maria Teste");
            p.setCpf("11122233344");
            p.setEndereco("Rua A, 10");
            p.setTelefone("11999999999");
            p.setDataNascimento(new Date());
            ps.salvarPaciente(p);
            System.out.println("Paciente cadastrado: " + p.getNome());
            ps.listarPacientes().forEach(x -> System.out.println(" - " + x.getNome()));
        } catch (Exception e) {
            System.err.println("Erro Paciente: " + e.getMessage());
        }

        // Psicologo
        try {
            PsicologoService pys = new PsicologoService();
            Psicologo psy = new Psicologo();
            psy.setNome("Dr. João");
            psy.setCrp("CRP-000");
            pys.cadastrarPsicologo(psy);
            System.out.println("Psicólogo cadastrado: " + psy.getNome());
            pys.listarPsicologos().forEach(x -> System.out.println(" - " + x.getNome()));
        } catch (Exception e) {
            System.err.println("Erro Psicologo: " + e.getMessage());
        }

        // Convenio (em memória)
        try {
            ConvênioService cvs = new ConvênioService();
            Convênio c = new Convênio();
            c.setId(1);
            c.setNome("Plano X");
            cvs.cadastrarConvênio(c);
            System.out.println("Convenio cadastrado: " + c.getNome());
            cvs.listarConvenios().forEach(x -> System.out.println(" - " + x.getNome()));
        } catch (Exception e) {
            System.err.println("Erro Convenio: " + e.getMessage());
        }

        // Quarto (em memória)
        try {
            QuartoService qsv = new QuartoService();
            Quarto q = new Quarto();
            q.setId(1);
            q.setNumero(101); // número como int
            q.setTipo("Simples");
            q.setDisponibilidade(true);
            qsv.cadastrarQuarto(q);
            System.out.println("Quarto cadastrado: " + q.getNumero());
            qsv.listarQuartos().forEach(x -> System.out.println(" - " + x.getNumero()));
        } catch (Exception e) {
            System.err.println("Erro Quarto: " + e.getMessage());
        }

        System.out.println("=== TESTES FINALIZADOS ===");
    }
}
