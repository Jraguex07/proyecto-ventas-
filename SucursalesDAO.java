/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intecap;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SucursalesDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Object datos[][];
   
    
    public Object[][] listar_tabla() {
        String instruccion = "select * from sucursales";

        try {
            int x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();

            while (rs.next()) {
                x++;
            }
            datos = new Object[x][5];
            x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                datos[x][0] = rs.getInt(1);
                datos[x][1] = rs.getString(2);
                datos[x][2] = rs.getString(3);
                datos[x][3] = rs.getString(4);
                datos[x][4] = rs.getInt(5);
                x++;
            }

        } catch (Exception e) {
        }

        return datos;
    }
    
    public void crear(int codigo, String nombre, String direccion, String correo, int telefono){
    String sql = "insert into sucursales(codigo, nombre, direccion, correo, telefono) values (?,?,?,?,?)";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, correo);
            ps.setInt(5, telefono);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
        public void modificar(int codigo, String nombre, String direccion, String correo , int telefono) {

        String sql = "update sucursales set codigo='" + codigo + "', nombre='" + nombre + "', direccion='" + direccion +"', correo ='"+ correo + "', telefono ='"+telefono+ "'where codigo ='" + codigo + "'";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
        
        public static void main(String[] args) {
        SucursalesDAO sc = new SucursalesDAO();
        sc.modificar(1212, "jeronimo"," xona55", "jaja", 7878787);
    }
    
}
