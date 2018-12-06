package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;

/**
 *
 * @author richard
 * 
 */
public class PacienteDAO<TIPO> extends DAOGenerico<Paciente> implements Serializable {

    public PacienteDAO(){
        super();
        // define a classe persistente
        classePersistente = Paciente.class;
        // define o atributo padrão ao inicializar o DAO
        ordem = "nome";
    }
 
}
