package br.org.estudo.service;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import br.org.estudo.bo.AgendaBO;
import br.org.estudo.entity.Agenda;

@Dependent
public class AgendaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendaBO agendaBO;

    public List<Agenda> findAll() {

        return agendaBO.findAll();
    }

    public Agenda save(Agenda agenda) {

        return agendaBO.save(agenda);
    }

    public void delete(Agenda agenda) {

        agendaBO.delete(agenda);
    }
}
