package br.org.estudo.view.mbean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.org.estudo.entity.Agenda;
import br.org.estudo.service.AgendaService;

@Named("agendaMBeanList")
@ViewScoped
public class AgendaMBeanList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendaService agendaService;

    private List<Agenda> agendaList;

    private Agenda agendaSelecionada;

    @PostConstruct
    public void init() {

        agendaList = agendaService.findAll();
    }

    public String edit() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("agendaEdit", agendaSelecionada);

        return "agendaEdit";
    }

    public String delete() {

        agendaService.delete(agendaSelecionada);

        init();

        return "";
    }

    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
    }

    public Agenda getAgendaSelecionada() {
        return agendaSelecionada;
    }

    public void setAgendaSelecionada(Agenda agendaSelecionada) {
        this.agendaSelecionada = agendaSelecionada;
    }
}
