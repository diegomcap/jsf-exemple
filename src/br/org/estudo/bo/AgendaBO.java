package br.org.estudo.bo;

import javax.enterprise.context.Dependent;
import br.org.estudo.entity.Agenda;
import br.org.estudo.util.GenericBO;

@Dependent
public class AgendaBO extends GenericBO<Integer, Agenda> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<?> getTypeClass() {
        return Agenda.class;
    }
}
