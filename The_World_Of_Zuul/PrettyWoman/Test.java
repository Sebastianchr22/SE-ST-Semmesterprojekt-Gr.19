/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrettyWoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sleaf
 */
public class Test {
HashMap<String, String> x;

Random       random    = new Random();
List<String> keys      = new ArrayList<String>(x.keySet());
String       randomKey = keys.get( random.nextInt(keys.size()) );
String       value     = x.get(randomKey);
}
