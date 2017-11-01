package org.unitec.elementos1801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1801Application implements CommandLineRunner{
    @Autowired RepositorioMensajito repoMensa; 
    @Autowired RepositorioUsuario repoUsu;
    @Autowired RepositorioDireccion repoDir;

	public static void main(String[] args) {
		SpringApplication.run(Elementos1801Application.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        
        Usuario u=new Usuario(38563L, "Cesar", "cipineda");
        //repoUsu.save(u);
        
        Direccion d=new Direccion(new Usuario(38563L),"calle 13",5462,"Ecatepec");
        //repoDir.save(d);
    
        //Aqui haremos el join 
        Direccion d2 =repoDir.findOne(1l);
        System.out.println("Correo:"+d2.getU().getEmail()+"municipio"+d2.getMunicipio());
                
        
        //repoMensa.save(new Mensajito(1,"Segundo","Mi primera vez")); 
       // Mensajito m= repoMensa.findOne(1);
       //repoMensa.save(new Mensajito("17 de octubre", "no temblo"));  
       
      
        
    }
}
