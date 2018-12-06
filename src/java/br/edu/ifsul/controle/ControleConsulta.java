package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ConsultaDAO;
import br.edu.ifsul.dao.ExameDAO;
import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.dao.ReceituarioDAO;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author richard
 * 
 */
@ManagedBean(name = "controleConsulta")
@ViewScoped
public class ControleConsulta implements Serializable {

    private ConsultaDAO<Consulta> dao;
    private Consulta objeto;
    private MedicoDAO<Medico> daoMedico; 
    private PacienteDAO<Paciente> daoPaciente;
    private ReceituarioDAO<Receituario> daoReceituario;
    private Receituario Receituario;
    private ExameDAO<Exame> daoExame;
    private Exame Exame;
    private Boolean novoReceituario;
    private Boolean novoExame;

    public ControleConsulta() {
        dao = new ConsultaDAO<>();
        daoMedico = new MedicoDAO<>();
        daoPaciente = new PacienteDAO<>();
        daoReceituario = new ReceituarioDAO<>();
        daoExame = new ExameDAO<>();
    }
    
    public void imprimeConsulta(Integer id) {
        objeto = dao.localizar(id);
        List<Consulta> lista = new ArrayList<>();
        lista.add(objeto);
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioConsulta", parametros, lista);
    }

    public void novoReceituario() {
        Receituario = new Receituario();
        novoReceituario = true;
    }

    public void alterarReceituario(int index) {
        Receituario = objeto.getReceituarios().get(index);
        novoReceituario = false;
    }

    public void salvarReceituario() {
        if (novoReceituario) {
            objeto.adicionarReceituario(Receituario);
        }
        Util.mensagemInformacao("Receituario adicionado com sucesso!");
    }

    public void removerReceituario(int index) {
        objeto.removerReceituario(index);
        Util.mensagemInformacao("Receituario removido com sucesso!");
    }
    
    public void novoExame() {
        Exame = new Exame();
        novoExame = true;
    }

    public void alterarExame(int index) {
        Exame = objeto.getExames().get(index);
        novoExame = false;
    }

    public void salvarExame() {
        if (novoExame) {
            objeto.adicionarExame(Exame);
        }
        Util.mensagemInformacao("Exame adicionado com sucesso!");
    }

    public void removerExame(int index) {
        objeto.removerExame(index);
        Util.mensagemInformacao("Exame removido com sucesso!");
    }
    
    public String listar() {
        return "/privado/consulta/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Consulta();
    }

    public void salvar() {
        boolean persistiu;
        if (objeto.getId() == null) {
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public void editar(Integer id) {
        objeto = dao.localizar(id);
    }

    public void remover(Integer id) {
        objeto = dao.localizar(id);
        if (dao.remover(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public ExameDAO<Exame> getDaoExame() {
        return daoExame;
    }

    public void setDaoExame(ExameDAO<Exame> daoExame) {
        this.daoExame = daoExame;
    }

    public Exame getExame() {
        return Exame;
    }

    public void setExame(Exame Exame) {
        this.Exame = Exame;
    }

    public Boolean getNovoExame() {
        return novoExame;
    }

    public void setNovoExame(Boolean novoExame) {
        this.novoExame = novoExame;
    }

    
    
    
    public ConsultaDAO getDao() {
        return dao;
    }

    public void setDao(ConsultaDAO dao) {
        this.dao = dao;
    }

    public Consulta getObjeto() {
        return objeto;
    }

    public void setObjeto(Consulta objeto) {
        this.objeto = objeto;
    }

    public MedicoDAO<Medico> getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(MedicoDAO<Medico> daoMedico) {
        this.daoMedico = daoMedico;
    }

    public PacienteDAO<Paciente> getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(PacienteDAO<Paciente> daoPaciente) {
        this.daoPaciente = daoPaciente;
    }


    public ReceituarioDAO<Receituario> getDaoReceituario() {
        return daoReceituario;
    }

    public void setDaoReceituario(ReceituarioDAO<Receituario> daoReceituario) {
        this.daoReceituario = daoReceituario;
    }

    public Receituario getReceituario() {
        return Receituario;
    }

    public void setReceituario(Receituario Receituario) {
        this.Receituario = Receituario;
    }

    public Boolean getNovoReceituario() {
        return novoReceituario;
    }

    public void setNovoReceituario(Boolean novoReceituario) {
        this.novoReceituario = novoReceituario;
    }

}
