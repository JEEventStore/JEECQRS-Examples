package org.jeecqrs.example.quickstart.web;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.jeecqrs.example.quickstart.application.fixtures.LoadFixtures;

@Named
public class LoadFixturesAction {

    @Inject
    private FacesContext facesContext;

    @EJB
    private LoadFixtures loadFixtures;

    public String loadFixtures() {
        loadFixtures.load();
        facesContext.addMessage(null, new FacesMessage("All fixtures loaded."));
        return null;
    }

}
