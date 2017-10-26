/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

/**
 *
 * @author Abdi
 */
public class Field {
    String name;
    int pos;
    
    Field(String name, int pos){
        this.name = name;
        this.pos = pos;
    }
    public String getName(){
        return name;
    }
    public int getPos(){
        return pos;
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
