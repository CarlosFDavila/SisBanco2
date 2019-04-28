/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbanco2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author carlos
 */
public class Pruebas {
    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection conndbc = null;
    dbconexion dbc = new dbconexion();
    
    Pruebas(){
                conndbc = dbc.databaseConn();
    }
    
    public String cadena_factura() throws SQLException{
            String sql = "Select *from facturas";
            pst = conndbc.prepareStatement(sql);
            rst = pst.executeQuery();
            String aux="";
            while(rst.next()){
                String id_f = rst.getString("id_factura");
                String id_c = rst.getString("id_cliente");
                String monto = rst.getString("monto");
                String estado = rst.getString("estado");
                //DefaultTableModel dftable = (DefaultTableModel) TablaU.getModel();
                //Object obj[] = {apellidos,nombres,ci,fecha_de_nacimiento,genero};
                //dftable.addRow(obj);
                aux+=id_f+id_c+monto+estado;
            }
        return aux;

    }
    
    public static void main(String[] args) throws SQLException{
        Pruebas pru = new Pruebas();
        String cadena = pru.cadena_factura();
        System.out.print(cadena);
        
    }

}
