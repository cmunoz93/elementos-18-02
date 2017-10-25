/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1801;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author T-107
 */

@SpringUI
@Theme("valo")

public class MiUI extends UI{
    
   @Autowired RepositorioMensajito repoMensa;

    @Override
    public void init(VaadinRequest request) {
        
        VerticalLayout layout=new VerticalLayout();
        
        //generamos una etiqueta 
        
        Label etiqueta=new Label("Aplicacion con mensajes");
        etiqueta.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(etiqueta);
        setContent(layout);
        
        Label etiquetaGuardar =new Label("Aplicacion con mensajes");
        etiquetaGuardar.addStyleName(ValoTheme.LABEL_H2);
        TextField textoTitulo=new TextField();
        textoTitulo.setPlaceholder("escribe el titulo");
        TextArea textoCuerpo=new TextArea();
        textoCuerpo.setPlaceholder("Escriba el cuerpo de su mensaje");
        Button boton=new Button("Guardar mensaje");
        
        boton.addClickListener(evento->{
            if(textoCuerpo.getValue().equals("")&&textoTitulo.getValue().equals("")){
                Notification.show("Los campos son requeridos",Notification.Type.ERROR_MESSAGE);
                }else{
           repoMensa.save(new Mensajito(textoTitulo.getValue(),textoCuerpo.getValue()));           
            Notification.show("Se guardo el mensaje", Notification.Type.ERROR_MESSAGE);
            }        
            });
        
// Create a grid bound to the list
Grid<Mensajito> grid = new Grid<>();
grid.setItems((List)repoMensa.findAll());
grid.addColumn(Mensajito::getId).setCaption("ID del mensaje");

grid.addColumn(Mensajito::getTitulo).setCaption("Titulo del mensaje");

grid.addColumn(Mensajito::getCuerpo).setCaption("Cuerpo del mensaje");


        
  layout.addComponent(etiqueta);
  layout.addComponent(etiquetaGuardar);
  layout.addComponent(textoTitulo);
  layout.addComponent(textoCuerpo);
  layout.addComponent(boton);
  setContent(layout);
  layout.addComponent(grid);
  
  
        
        //Primero creamos un horizontal layout 
        
        HorizontalLayout layout1=new HorizontalLayout();
        
       TextField textoId=new TextField();
    textoId.setPlaceholder("Introduzca el id");
    Button botonBuscarId=new Button("Buscar"); 
    botonBuscarId.addStyleName(ValoTheme.BUTTON_PRIMARY);
    
    
    
    
    layout1.addComponent(textoId);
    layout1.addComponent(botonBuscarId);
    layout.addComponent(layout1);
    
    HorizontalLayout layout2=new HorizontalLayout();
        TextField textoBuscarId=new TextField();
        TextField textoBuscarTitulo=new TextField();
        TextArea textoBuscarCuerpo=new TextArea();
        layout2.addComponent(textoBuscarId);
         layout2.addComponent(textoBuscarTitulo);
          layout2.addComponent(textoBuscarCuerpo);
        layout.addComponent(layout2);
                
        Button botonActualizar=new Button("Actualizar");
        botonActualizar.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        layout.addComponent(botonActualizar);
        setContent(layout);
        
        
        
        botonBuscarId.addClickListener(evento->{
            Mensajito mensa= repoMensa.findOne(Integer.parseInt(textoId.getValue()));
        
        
        textoBuscarId.setValue(""+mensa.getId());
        textoBuscarTitulo.setValue(mensa.getTitulo());
        textoBuscarCuerpo.setValue(mensa.getCuerpo());
        
    });
    
    
}
}