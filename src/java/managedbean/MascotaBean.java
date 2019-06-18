package managedbean;

import dao.MascotaDao;
import entidades.Mascota;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MascotaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Mascota mascota;

    public MascotaBean() {
        mascota = new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String guardar() {

        MascotaDao dao = new MascotaDao();
        boolean resp = dao.guardarMascota(mascota);
        if (resp) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registar correctamente"));
        }
        return "/RegistroMascota";

    }

    public ArrayList<Mascota> listar() {
        ArrayList<Mascota> milista = new ArrayList<>();
        MascotaDao dao = new MascotaDao();
        milista = dao.listarMascota();
        return milista;

    }

    public String actualizarMascota() {
        MascotaDao dao = new MascotaDao();
        boolean resp= dao.actualizarMascota(mascota);
        if (resp) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo actualizar correctamente"));
        }
        return "/RegistroMascota";

    }

    public String eliminarMascota(Mascota data) {
        MascotaDao dao = new MascotaDao();
        boolean resp = dao.delete(data);
        if (resp) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Borrado con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se elimino correctamente"));
        }
        return "/RegistroMascota";
    }

    public String limpiar() {
        mascota = new Mascota();
        return "/RegistroMascota";
    }

}
