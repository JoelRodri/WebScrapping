import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Pilotos")
public class DataArray {
    List<Data> datos = new ArrayList<>();

    public List<Data> getDatos() {
        return datos;
    }

    @XmlElement(name = "Piloto")
    public void setDatos(List<Data> datos) {
        this.datos = datos;
    }

    public void addDatos(Data data){
        this.datos.add(data);
    }

    public DataArray() {
    }
}
