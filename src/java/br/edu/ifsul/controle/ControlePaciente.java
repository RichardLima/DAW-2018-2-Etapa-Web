/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PacienteDAO1;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author richa
 */

@ManagedBean(name = "controlePaciente")
@SessionScoped
public class ControlePaciente implements Serializable{
    
    private PacienteDAO1 dao;
    private Paciente objeto;
//    private PaisDAO daoPais;

    public ControlePaciente(){
        dao = new PacienteDAO1();
//        daoPais = new PaisDAO();
    }
    
    public String listar(){
        return "/privado/paciente/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Paciente();
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
    
    public PacienteDAO1 getDao() {
        return dao;
    }

    public void setDao(PacienteDAO1 dao) {
        this.dao = dao;
    }

    public Paciente getObjeto() {
        return objeto;
    }

    public void setObjeto(Paciente objeto) {
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
