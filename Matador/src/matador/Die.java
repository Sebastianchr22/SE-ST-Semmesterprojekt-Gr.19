/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

import java.util.Random;

/**
 *
 * @author Abdi
 */
public class Die {
    private static Random generator = new Random();
    private int sides;
    
    public Die(int sides){
        this.sides = sides;
    }
    
    Die(){
        this(6);
    }
    public int throwDice(){
        return generator.nextInt(sides) + 1;
    }
}
