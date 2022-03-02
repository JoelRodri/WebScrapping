import jakarta.xml.bind.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase crea el archivo xml
 */
public class Xml {
    File file = new File("PilotosF1.xml");
    DataArray datas = new DataArray();
    Data data;
    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;
    Xml(List<Pilotos> pilotosList) {
            try {
                jaxbContext = JAXBContext.newInstance(DataArray.class);

                for (Pilotos piloto : pilotosList) {
                    data = new Data(piloto.nombre, piloto.numero, piloto.equipo,piloto.pais,piloto.podiums,piloto.puntos,piloto.gpComp,piloto.titulos,piloto.mejorPos,piloto.mejorClas,piloto.nacimiento,piloto.nacionalidad);
                    datas.addDatos(data);
                }

                jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(datas, file);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
    }
}
