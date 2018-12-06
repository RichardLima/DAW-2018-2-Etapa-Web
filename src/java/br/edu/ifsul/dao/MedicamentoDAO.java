package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medicamento;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class MedicamentoDAO<TIPO> extends DAOGenerico<Medicamento> implements Serializable {

    public MedicamentoDAO(){
        super();
        // define a classe persistente
        classePersistente = Medicamento.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "nome";
    }
 
}
