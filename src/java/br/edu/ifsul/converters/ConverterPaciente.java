package br.edu.ifsul.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author richard
 * 
 */
@FacesConverter(value = "converterPaciente")
public class ConverterPaciente implements Serializable, Converter {

    @Override // método que converte da tela para o objeto
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")){
            return null;
        }
        try {
            return EntityManagerUtil.getEntityManager().find(Paciente.class, Integer.parseInt(string));
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Paciente obj = (Paciente) o;
        return obj.getId().toString();
    }

}
