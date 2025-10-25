package dao;

import model.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private static List<Consulta> consultas = new ArrayList<>();

    public void salvar(Consulta consulta) {
        consultas.add(consulta);
    }

    public void atualizar(Consulta consultaAtualizada) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId() == consultaAtualizada.getId()) {
                consultas.set(i, consultaAtualizada);
                return;
            }
        }
    }

    public void deletar(int id) {
        consultas.removeIf(c -> c.getId() == id);
    }

    public Consulta buscarPorId(int id) {
        for (Consulta c : consultas) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public List<Consulta> listar() {
        return new ArrayList<>(consultas);
    }
}

