package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class EspecialidadeDAO<TIPO> extends DAOGenerico<Especialidade> implements Serializable {

    public EspecialidadeDAO(){
        super();
        // define a classe persistente
        classePersistente = Especialidade.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "descricao";
    }
 
}
