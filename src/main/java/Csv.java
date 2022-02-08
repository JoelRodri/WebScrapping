import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csv {
    File file = new File("pilotosF1.csv");


    public Csv(List<Pilotos> pilotosList) {
        CSVWriter csvWriter;
        String[] head = {"Nom","Numero","Escuderia","Pais","Podiums","Puntos Totales","GP Completados","Titulos Mundiales","Mejor Posición","Mejor Classificación","Lugar Nacimiento","Nacionalidad"};
        List<String[]> data = new ArrayList<>();
        for (Pilotos piloto: pilotosList){
            data.add(new String[] {piloto.getNombre(),piloto.getNumero(),piloto.getEquipo(),piloto.getPais(),piloto.getPodiums(),piloto.getPuntos(),piloto.getGpComp(),piloto.getTitulos(),piloto.getMejorPos(),piloto.getMejorClas(),piloto.getNacimiento(),piloto.getNacionalidad()});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeNext(head);
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
