package br.org.estudo.view.mbean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.org.estudo.entity.Agenda;
import br.org.estudo.service.AgendaService;

@Named("agendaMBeanEdit")
@ViewScoped
public class AgendaMBeanForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendaService agendaService;

    private Agenda agenda;

    @PostConstruct
    public void init() {
        agenda = (Agenda) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("agendaEdit");

        if (agenda == null) {
            agenda = new Agenda();
        }
    }

    public String salvar() {

        agendaService.save(agenda);

        return "agendaList";
    }

    public String voltar() {

        return "agendaList";
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
