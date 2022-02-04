package buffete;

import java.sql.*;
import java.util.ArrayList;

public class MYSQLConexion {

    public static Connection conectar = null;
    public static Statement sentencia;
    public static ResultSet resultado;

    public static Connection conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3307/buffette", "root", "");
            sentencia = conectar.createStatement();
        } catch (Exception e) {
        }

        return conectar;
    }

    public static ArrayList<String> llenar_Combo() {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            String sql = "select id_grado , descripcion from grado";
            resultado = sentencia.executeQuery(sql);
            System.out.println("Correcto");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
                lista.add(resultado.getString("id_grado"));
                lista.add(resultado.getString("descripcion"));

            }
        } catch (Exception e) {
        }

        return lista;
    }

    public static ArrayList<String> Medios() {
        ArrayList<String> medios = new ArrayList<String>();
        String query = "select id_medio , descripcion from tipo_medio";
        try {
            resultado = sentencia.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
                medios.add(resultado.getString("id_medio"));
//                     medios.add(resultado.getString("descripcion"));

            }
        } catch (Exception e) {
        }

        return medios;
    }

    public ArrayList<items> Estado() {
        ArrayList<items> estados = new ArrayList<>();
        String Secuele = "SELECT *, id_estado FROM estado ORDER BY id_estado ASC ";
        try {
            resultado = sentencia.executeQuery(Secuele);

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
//                 estados.add(resultado.getString("id_estado")); 
                items items = new items();
                items.setId(resultado.getInt("id_estado"));
                items.setDescripcion(resultado.getString("descripcion"));
                estados.add(items);
            }
        } catch (Exception e) {
        }
        return estados;
    }

    public ArrayList<grados> Grados() {
        ArrayList<grados> gdos = new ArrayList<>();
        String q = "SELECT *, id_grado FROM estudio ORDER BY id_grado ASC ";
        try {

            resultado = sentencia.executeQuery(q);
        } catch (Exception e) {
        }
        try {
            while (resultado.next()) {
                grados Grados = new grados();
                Grados.setId(resultado.getInt("id_grado"));
                Grados.setDescripcion(resultado.getString("descripcion"));
                gdos.add(Grados);

            }
        } catch (Exception e) {
        }
        return gdos;

    }
    public ArrayList<idClientes> Clientes(){
    ArrayList<idClientes> clientes = new ArrayList<>();
    
        try {
            String query = "SELECT *, id_cliente FROM cliente ORDER BY id_cliente ASC ";
            resultado = sentencia.executeQuery(query);
        } catch (Exception e) {
        } try {
            while (resultado.next()) {
           idClientes client = new idClientes();
           client.setId(resultado.getInt("id_cliente"));
           client.setNombre(resultado.getString("nombre"));
           clientes.add(client);
            
        }
        } catch (Exception e) {
        }
    
    
    return clientes;
    
    }
    
    public ArrayList<Demandado> IDDemandado(){
    ArrayList<Demandado> demandado = new ArrayList<>();
        try {
            String Q = "SELECT  d.id_demandado, p.nombre FROM demandado d, persona p WHERE p.id_demandado = d.id_demandado ORDER BY id_demandado ASC";
            resultado = sentencia.executeQuery(Q);
            
            
        } catch (Exception e) {
        } try {
            while (resultado.next()) {                
                Demandado dmado = new Demandado();
                dmado.setId(resultado.getInt("id_demandado"));
                dmado.setNombre(resultado.getString("nombre"));
                demandado.add(dmado);  
            }
        } catch (Exception e) {
        }
        return demandado;
    }
    
    public ArrayList<Abogatos> Abogado(){
    ArrayList<Abogatos> abogados = new ArrayList<>();
        try {
             String Q = "SELECT *, id_abogado FROM abogado ORDER BY id_abogado ASC";
            resultado = sentencia.executeQuery(Q);
            
        } catch (Exception e) {
        }try {
            while (resultado.next()) {            
                Abogatos abgdo = new Abogatos();
                abgdo.setId(resultado.getInt("id_abogado"));
                abgdo.setNombre(resultado.getString("nombre"));
                abogados.add(abgdo);
            
        }
        } catch (Exception e) {
        }
        
        return abogados;
    }
public ArrayList<TAsuntos> Asuntos(){
    ArrayList<TAsuntos> asuntos = new ArrayList<>();
        try {
             String Q = "SELECT *, id_tipo_asunto FROM tipo_asunto ORDER BY id_tipo_asunto ASC";
            resultado = sentencia.executeQuery(Q);
            
        } catch (Exception e) {
        }try {
            while (resultado.next()) {            
                TAsuntos TipoAsuntos = new TAsuntos();
                TipoAsuntos.setId(resultado.getInt("id_tipo_asunto"));
                TipoAsuntos.setDescripcion(resultado.getString("descripcion"));
                asuntos.add(TipoAsuntos);
            
        }
        } catch (Exception e) {
        }
        
        return asuntos;
    }

         public ArrayList<Demandas> TipoDemandas(){
             ArrayList<Demandas> demanda = new ArrayList<>();
             try {
                   String cnl = "SELECT * FROM tipo ORDER BY id_tipo ASC";
            resultado = sentencia.executeQuery(cnl);
             } catch (Exception e) {
             } try {
                 while (resultado.next()) {                 
                     Demandas tipodemanda = new Demandas();
                     tipodemanda.setId(resultado.getInt("id_tipo"));
                     tipodemanda.setDescripcion(resultado.getString("descripcion"));
                     demanda.add(tipodemanda);
                 
             }
             } catch (Exception e) {
             }
             
             return demanda;
    
       }
         
         
           public static ArrayList<String> llenar_Asunto() {
        ArrayList<String> asuntoII = new ArrayList<String>();

        try {
            String sql = "select id_asunto from asunto";
            resultado = sentencia.executeQuery(sql);
            System.out.println("Correcto");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
                asuntoII.add(resultado.getString("id_asunto"));
               

            }
        } catch (Exception e) {
        }

        return asuntoII;
    }
         public ArrayList<lugares> Lugares(){
             ArrayList<lugares> lugar = new ArrayList<>();
             try {
                   String cnl = "SELECT * FROM lugar ORDER BY id_lugar ASC";
            resultado = sentencia.executeQuery(cnl);
             } catch (Exception e) {
             } try {
                 while (resultado.next()) {                 
                     lugares lugartipo = new lugares();
                     lugartipo.setId(resultado.getInt("id_lugar"));
                     lugartipo.setDescripcion(resultado.getString("descripcion"));
                     lugar.add(lugartipo);
                 
             }
             } catch (Exception e) {
             }
             
             return lugar;
    
       }
       
         
         public static ArrayList<String> llenar_Audiencia() {
        ArrayList<String> audiencia = new ArrayList<String>();

        try {
            String sql = "select id_audiencia from audiencia";
            resultado = sentencia.executeQuery(sql);
            System.out.println("Correcto");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
                audiencia.add(resultado.getString("id_audiencia"));
               

            }
        } catch (Exception e) {
        }

        return audiencia;
    }
         
          public static ArrayList<String> llenar_Gente() {
        ArrayList<String> gente = new ArrayList<String>();

        try {
            String sql = "select id_gente from gente";
            resultado = sentencia.executeQuery(sql);
            System.out.println("Correcto");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while (resultado.next()) {
                gente.add(resultado.getString("id_gente"));
               

            }
        } catch (Exception e) {
        }

        return gente;
    }

}

   