package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.List;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

public class Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        List<Mascota> lista = mascotadao.listarxNombreMascota(session, "Lucas");
        for (Mascota mascota : lista) {
            System.out.println(mascota.getRaza());
        }
    }

}
