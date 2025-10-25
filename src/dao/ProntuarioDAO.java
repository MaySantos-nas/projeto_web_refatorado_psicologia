package dao;

import model.Prontuario;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
    private static List<Prontuario> prontuarios = new ArrayList<>();

    public void salvar(Prontuario prontuario) {
        prontuarios.add(prontuario);
    }

    public void atualizar(Prontuario prontuarioAtualizado) {
        for (int i = 0; i < prontuarios.size(); i++) {
            if (prontuarios.get(i).getId() == prontuarioAtualizado.getId()) {
                prontuarios.set(i, prontuarioAtualizado);
                return;
            }
        }
    }

    public void deletar(int id) {
        prontuarios.removeIf(p -> p.getId() == id);
    }

    public Prontuario buscarPorId(int id) {
        for (Prontuario p : prontuarios) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public List<Prontuario> listar() {
        return new ArrayList<>(prontuarios);
    }
}

