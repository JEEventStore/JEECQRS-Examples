package org.jeecqrs.example.quickstart.web;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

@SuppressWarnings("unused")
public class Resources {
    
     @Produces
     public FacesContext getFacesContext() {
         return FacesContext.getCurrentInstance();
     }
     
}
