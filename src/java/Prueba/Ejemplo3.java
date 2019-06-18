/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

public class Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        Mascota mimascota = new Mascota(1, "doky", "Fidel", "chiguagua");
        mascotadao.actualizarMascota(mimascota);

        session.beginTransaction();
        session.saveOrUpdate(mimascota);
        session.getTransaction().commit();
        session.close();

    }

}
