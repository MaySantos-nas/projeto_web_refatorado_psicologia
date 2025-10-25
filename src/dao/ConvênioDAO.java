package dao;

import model.Convênio;
import java.util.ArrayList;
import java.util.List;

public class ConvênioDAO {
    private static List<Convênio> convenios = new ArrayList<>();

    public void salvar(Convênio convenio) {
        convenios.add(convenio);
    }

    public void atualizar(Convênio convenioAtualizado) {
        for (int i = 0; i < convenios.size(); i++) {
            if (convenios.get(i).getId() == convenioAtualizado.getId()) {
                convenios.set(i, convenioAtualizado);
                return;
            }
        }
    }

    public void deletar(int id) {
        convenios.removeIf(c -> c.getId() == id);
    }

    public Convênio buscarPorId(int id) {
        for (Convênio c : convenios) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public List<Convênio> listar() {
        return new ArrayList<>(convenios);
    }
}

