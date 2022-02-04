
package buffete;

public class idClientes {
    private int id;
    private String nombre;
//     private String paterno;
//      private String materno;
//       private String rfc;
//        private String curp;
    
    public idClientes(){
    
    }
    public idClientes(int id, String nombre){
    this.id = id;
    this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre + "  " + id;
    }
    
}
