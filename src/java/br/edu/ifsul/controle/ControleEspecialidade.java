/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EspecialidadeDAO1;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author richa
 */

@ManagedBean(name = "controleEspecialidade")
@SessionScoped
public class ControleEspecialidade implements Serializable{
    
    private EspecialidadeDAO1 dao;
    private Especialidade objeto;
//    private PaisDAO daoPais;

    public ControleEspecialidade(){
        dao = new EspecialidadeDAO1();
//        daoPais = new PaisDAO();
    }
    
    public String listar(){
        return "/privado/especialidade/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Especialidade();
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
    
    public EspecialidadeDAO1 getDao() {
        return dao;
    }

    public void setDao(EspecialidadeDAO1 dao) {
        this.dao = dao;
    }

    public Especialidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Especialidade objeto) {
        this.objeto = objeto;
    }

//    public PaisDAO getDaoPais() {
//        return daoPais;
//    }
//
//    public void setDaoPais(PaisDAO daoPais) {
//        this.daoPais = daoPais;
//    }
    
}
