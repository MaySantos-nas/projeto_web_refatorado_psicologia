package dao;

import model.Internaçao;
import java.util.ArrayList;
import java.util.List;

public class InternaçaoDAO {
    private static List<Internaçao> internacoes = new ArrayList<>();

    public void salvar(Internaçao internacao) {
        internacoes.add(internacao);
    }

    public void atualizar(Internaçao internacaoAtualizada) {
        for (int i = 0; i < internacoes.size(); i++) {
            if (internacoes.get(i).getId() == internacaoAtualizada.getId()) {
                internacoes.set(i, internacaoAtualizada);
                return;
            }
        }
    }

    public void deletar(int id) {
        internacoes.removeIf(i -> i.getId() == id);
    }

    public Internaçao buscarPorId(int id) {
        for (Internaçao i : internacoes) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public List<Internaçao> listar() {
        return new ArrayList<>(internacoes);
    }
}
