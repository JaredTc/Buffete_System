/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffete;

/**
 *
 * @author Jared
 */
public class TAsuntos {
    private int id;
    private String descripcion;
    
    
    public TAsuntos(){
    }
    public TAsuntos(int id, String descripcion ){
        
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion + "  " + id;
    }
    
    
}