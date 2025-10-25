package dao;

import model.Quarto;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    private static List<Quarto> quartos = new ArrayList<>();

    public void salvar(Quarto quarto) {
        quartos.add(quarto);
    }

    public void atualizar(Quarto quartoAtualizado) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == quartoAtualizado.getId()) {
                quartos.set(i, quartoAtualizado);
                return;
            }
        }
    }

    public void deletar(int id) {
        quartos.removeIf(q -> q.getId() == id);
    }

    public Quarto buscarPorId(int id) {
        for (Quarto q : quartos) {
            if (q.getId() == id)
                return q;
        }
        return null;
    }

    public List<Quarto> listar() {
        return new ArrayList<>(quartos);
    }
}
