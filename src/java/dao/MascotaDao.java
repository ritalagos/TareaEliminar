package dao;

import Interfaces.IMascota;
import entidades.Mascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

public class MascotaDao implements IMascota {

    @Override
    public boolean guardarMascota(Mascota mascota) {
        boolean resp = true;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transacction = sesion.beginTransaction();
        try {
            sesion.save(mascota);
            transacction.commit();
        } catch (Exception e) {
            resp = false;
            System.out.println("error guardar::"+e);
        }
        sesion.close();
        return resp;
    }

    @Override
    public ArrayList<Mascota> listarMascota() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascota> milista = new ArrayList<>();
        Query query = sesion.createQuery("From Mascota");
        milista = (ArrayList<Mascota>) query.list();
        return milista;

    }

    public boolean actualizarMascota(Mascota objeto) {
        boolean resp=true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(objeto);
        transaccion.commit();
        } catch (Exception e) {
            resp=false;
            System.out.println("ERROR EN UPDATE  :: "+e);
        }
        sesion.close();
        return  resp;
    }

    //ejemplo 4
    public List<Mascota> listarxRaza(Session session, String raza) {
        String hql = " from Mascota where raza='" + raza + "'";
        Query query = session.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return lista;
    }

    public List<Mascota> listarxNombreMascota(Session session, String nombreMascota) {
        String hql = " from Mascota where nombreMascota='" + nombreMascota + "'";
        Query query = session.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return lista;
    }

    public Integer ContadorMascotas(Session session) {
        String hql = "select count(*) from Mascota";
        Query query = session.createQuery(hql);
        Long FilasTab = (Long) query.uniqueResult();
        Integer cont = FilasTab.intValue();
        return cont;
    }

    @Override
    public boolean delete(Mascota mascota) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascota);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DAO::" + e);
            resp = false;
            sesion.getTransaction().rollback();

        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return resp;
    }

}
