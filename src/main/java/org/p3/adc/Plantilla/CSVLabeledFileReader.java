package org.p3.adc.Plantilla;

import org.p3.adc.Constructores.RowWithLabel;
import org.p3.adc.Constructores.Table;
import org.p3.adc.Constructores.TableWithLabels;

public class CSVLabeledFileReader extends CSVUnlabeledFileReader{
    private TableWithLabels tabla;
    public CSVLabeledFileReader(String file) {
        super(file);
        tabla=new TableWithLabels();
    }

    @Override
    void processData(String data) {
        RowWithLabel row = new RowWithLabel();
        String[] datos = data.split(",");
        for(int i=0;i<datos.length-1;i++){
            row.addFila(Double.parseDouble(datos[i]));
        }
        tabla.addEtiquetas(datos[datos.length - 1],row);
        tabla.addFila(row);
    }

    @Override
    public TableWithLabels getTable() {
        return tabla;
    }
}
