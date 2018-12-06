package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicoDAO1;
import br.edu.ifsul.dao.EspecialidadeDAO1;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author richa
 */
@ManagedBean(name = "controleMedico")
@SessionScoped
public class ControleMedico implements Serializable {

    private MedicoDAO1 dao;
    private Medico objeto;
    private EspecialidadeDAO1 daoEspecialidade;
    
    public ControleMedico(){
        dao = new MedicoDAO1();
        daoEspecialidade = new EspecialidadeDAO1();
    }
    
    public String listar(){
        return "/privado/medico/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Medico();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        if (dao.salvar(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        try {
            objeto = dao.localizar(id);
            return "formulario?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
            return "listar?faces-redirect=true";
        }
    }
    
    public void remover(Integer id){
        objeto = dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public MedicoDAO1 getDao() {
        return dao;
    }

    public void setDao(MedicoDAO1 dao) {
        this.dao = dao;
    }

    public Medico getObjeto() {
        return objeto;
    }

    public void setObjeto(Medico objeto) {
        this.objeto = objeto;
    }

    public EspecialidadeDAO1 getDaoEspecialidade() {
        return daoEspecialidade;
    }

    public void setDaoEspecialidade(EspecialidadeDAO1 daoEspecialidade) {
        this.daoEspecialidade = daoEspecialidade;
    }
}
