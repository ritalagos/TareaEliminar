/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author RITA
 */
public interface IMascota {

    public abstract boolean guardarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarMascota();

    public abstract boolean actualizarMascota(Mascota objeto);

    public abstract List<Mascota> listarxRaza(Session session, String raza);

    public abstract List<Mascota> listarxNombreMascota(Session session, String nombreMascota);

    public abstract Integer ContadorMascotas(Session session);

    public abstract boolean delete(Mascota mascota);

}
