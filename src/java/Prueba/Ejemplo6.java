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
public class Ejemplo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        int cantidad = mascotadao.ContadorMascotas(session);
        System.out.println("Cantidad de mascotas:: "+cantidad);
        

    }

}
