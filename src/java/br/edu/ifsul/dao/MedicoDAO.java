package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class MedicoDAO<TIPO> extends DAOGenerico<Medico> implements Serializable {

    public MedicoDAO(){
        super();
        // define a classe persistente
        classePersistente = Medico.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "nome";
    }
 
}
