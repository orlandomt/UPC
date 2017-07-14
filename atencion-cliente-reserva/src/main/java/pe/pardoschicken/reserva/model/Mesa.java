package pe.pardoschicken.reserva.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue
    @Column(name = "id_mesa")
    private int idMesa;

    @Column(name = "num_mesa")
    private int numMesa;

    @ManyToOne
    @JoinColumn(name = "cod_local")
    private Local codLocal;

    @OneToMany(mappedBy = "hora", fetch = FetchType.LAZY)
    private List<Hora> horas;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public Local getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(Local codLocal) {
        this.codLocal = codLocal;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }
}
