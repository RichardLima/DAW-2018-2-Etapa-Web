package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Receituario;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class ReceituarioDAO<TIPO> extends DAOGenerico<Receituario> implements Serializable {

    public ReceituarioDAO(){
        super();
        // define a classe persistente
        classePersistente = Receituario.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "id";
    }
 
}
