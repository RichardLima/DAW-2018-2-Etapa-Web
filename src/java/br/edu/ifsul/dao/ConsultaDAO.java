package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Consulta;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class ConsultaDAO<TIPO> extends DAOGenerico<Consulta> implements Serializable {

    public ConsultaDAO(){
        super();
        // define a classe persistente
        classePersistente = Consulta.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "id";
        maximoObjetos = 5;
    }
 
}
