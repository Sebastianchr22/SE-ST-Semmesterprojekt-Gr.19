package PrettyWoman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdi
 */
class Moves {
    
    private int moves = 10;

    public int getMoves() {
        return moves;
    }
    public void removeMoves() {
        moves--;
    }

    public void resetMoves() {
        moves = 10;
    }

}
