/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.List;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author RITA
 */
public class Ejemplo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        List<Mascota> lista = mascotadao.listarxRaza(session, "chiguagua");
        for (Mascota mascota : lista) {
            System.out.println(mascota.getNombreCliente());
        }
    }
    
}
