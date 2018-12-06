/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicamentoDAO1;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author richa
 */

@ManagedBean(name = "controleMedicamento")
@SessionScoped
public class ControleMedicamento implements Serializable{
    
    private MedicamentoDAO1 dao;
    private Medicamento objeto;
//    private PaisDAO daoPais;

    public ControleMedicamento(){
        dao = new MedicamentoDAO1();
//        daoPais = new PaisDAO();
    }
    
    public String listar(){
        return "/privado/medicamento/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Medicamento();
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
    
    public MedicamentoDAO1 getDao() {
        return dao;
    }

    public void setDao(MedicamentoDAO1 dao) {
        this.dao = dao;
    }

    public Medicamento getObjeto() {
        return objeto;
    }

    public void setObjeto(Medicamento objeto) {
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
