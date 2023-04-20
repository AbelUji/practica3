package org.p3.adc.Clases;

import org.p3.adc.Constructores.Row;
import org.p3.adc.Constructores.RowWithLabel;
import org.p3.adc.Constructores.Table;
import org.p3.adc.Constructores.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {
    public Table readTable(String filename) throws FileNotFoundException {
        Table tabla=new Table();
        Scanner sc=new Scanner(new File(filename));
        int contador=0;
        while(sc.hasNext()){
            String[] datos = sc.nextLine().split(",");
            if(contador==0){
                tabla.addEtiquetas(datos);
                contador++;
            }
            else{
                Row row=new Row();
                for(String element:datos){
                    row.addFila(Double.valueOf(element));
                }
                tabla.addFila(row);
            }
        }
        sc.close();
        return tabla;
    }

    public TableWithLabels readTableWithLabels(String filename) throws FileNotFoundException{
        TableWithLabels tabla= new TableWithLabels();
        Scanner sc = new Scanner(new File(filename));
        int contador = 0;
        while (sc.hasNext()){
            String [] datos= sc.nextLine().split(",");
            if(contador==0){
                tabla.addEtiquetas(datos);
                contador++;
            }else{
                RowWithLabel row = new RowWithLabel();
                for(int i=0;i<datos.length-1;i++){
                    row.addFila(Double.parseDouble(datos[i]));
                }
                tabla.addEtiquetas(datos[datos.length - 1],row);
                tabla.addFila(row);
            }
        }
        sc.close();
        return tabla;
    }
}