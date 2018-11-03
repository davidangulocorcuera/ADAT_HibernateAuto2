/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author biolizard
 */
public class Main  {
    Session session;

    public Main() {

        HibernateUtil util = new HibernateUtil();

        session = util.getSessionFactory().openSession();

    }
    public static void main(String [] args){
        Main main = new Main();
        try {
            main.showAllPeliculas();
            main.showAllActores();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
     public void showAllPeliculas() throws FileNotFoundException, IOException {
        System.out.println("Consultando peliculas");

        Query q = session.createQuery("select e from Peliculas e");
        List results = q.list();

        Iterator cursesIterator = results.iterator();

        while (cursesIterator.hasNext()) {
            Peliculas peliculas = (Peliculas) cursesIterator.next();

            System.out.println("Id: " + peliculas.getCodigo() + ", Nombre: " + peliculas.getTitulo() + ", Fecha; " + peliculas.getFecha() + ", Presupuesto " + peliculas.getPresupuesto()
                    );

        }

        System.out.println("Fin Consulta");
    }
     public void showAllActores() throws FileNotFoundException, IOException {
        System.out.println("Consultando actores");

        Query q = session.createQuery("select e from Actores e");
        List results = q.list();

        Iterator cursesIterator = results.iterator();

        while (cursesIterator.hasNext()) {
            Actores actor = (Actores) cursesIterator.next();

            System.out.println("Id: " + actor.getCodigo() + ", Nombre: " + actor.getNombre() + ", Fecha; " + actor.getFnacimiento() + ", Nacionalidad " + actor.getNacionalidad()
                    );

        }

        System.out.println("Fin Consulta");
    }
  

    
     
}

