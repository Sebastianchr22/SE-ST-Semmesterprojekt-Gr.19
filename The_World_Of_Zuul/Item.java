/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sleaf
 */
    public enum Item {
        RING("ring"),
        AMULET("amulet"),
        PANTIES("panties");
        
        private String itemString;
        
        Item(String itemString){
            this.itemString = itemString;
        }
        public String getItems(){
            return itemString;
        }
    }
