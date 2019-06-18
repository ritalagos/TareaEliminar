/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import managedbean.MascotaBean;

/**
 *
 * @author RITA
 */
public class eliminar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*MascotaDao mascotadao = new MascotaDao();
        Mascota ma = new Mascota(9, "ds", "ds", "ds");
        boolean res = mascotadao.delete(ma);
        System.out.println("resp::"+res);*/
        MascotaBean md = new MascotaBean();
        Mascota ma = new Mascota(7, "asas", "asas", "asas");
        String re= md.eliminarMascota(ma);
        System.out.println("res:"+re);
    }
    
}
