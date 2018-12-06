package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Exame;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class ExameDAO<TIPO> extends DAOGenerico<Exame> implements Serializable {

    public ExameDAO(){
        super();
        // define a classe persistente
        classePersistente = Exame.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "id";
    }
 
}
