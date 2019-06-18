
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import utilitarios.HibernateUtil;



/**
 *
 * @author RITA
 */
public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Mascota> lista = new LinkedList<>();
        MascotaDao mascotadao = new MascotaDao();

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        lista = mascotadao.listarMascota();

        for (Mascota mascota : lista) {
            System.out.println(mascota.getNombreMascota());
        }
    }

}
