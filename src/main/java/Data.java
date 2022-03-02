import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Piloto")
public class Data {
    String nombre;
    String numero;
    String equipo;
    String pais;
    String podiums;
    String puntos;
    String gpComp;
    String titulos;
    String mejorPos;
    String mejorClas;
    String nacimiento;
    String nacionalidad;

    public Data() {
    }

    public Data(String nombre, String numero, String equipo, String pais, String podiums, String puntos, String gpComp, String titulos, String mejorPos, String mejorClas, String nacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.equipo = equipo;
        this.pais = pais;
        this.podiums = podiums;
        this.puntos = puntos;
        this.gpComp = gpComp;
        this.titulos = titulos;
        this.mejorPos = mejorPos;
        this.mejorClas = mejorClas;
        this.nacimiento = nacimiento;
        this.nacionalidad = nacionalidad;
    }

    @XmlElement(name = "Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "Numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlElement(name = "Equipo")
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @XmlElement(name = "Pais")
    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlElement(name = "Podiums")
    public void setPodiums(String podiums) {
        this.podiums = podiums;
    }

    @XmlElement(name = "Puntos")
    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    @XmlElement(name = "GP_Completados")
    public void setGpComp(String gpComp) {
        this.gpComp = gpComp;
    }

    @XmlElement(name = "Titulos")
    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    @XmlElement(name = "Mejor_Posición")
    public void setMejorPos(String mejorPos) {
        this.mejorPos = mejorPos;
    }

    @XmlElement(name = "Mejor_Classificación")
    public void setMejorClas(String mejorClas) {
        this.mejorClas = mejorClas;
    }

    @XmlElement(name = "Nacimiento")
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    @XmlElement(name = "Nacionalidad")
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    public String getNombre() {return nombre;}

    public String getNumero() {return numero;}

    public String getEquipo() {
        return equipo;
    }

    public String getPais() {
        return pais;
    }

    public String getPodiums() {
        return podiums;
    }

    public String getPuntos() {
        return puntos;
    }

    public String getGpComp() {
        return gpComp;
    }

    public String getTitulos() {
        return titulos;
    }

    public String getMejorPos() {
        return mejorPos;
    }

    public String getMejorClas() {
        return mejorClas;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}
