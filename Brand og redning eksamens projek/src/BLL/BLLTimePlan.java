/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import BE.BETimePlan;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLTimePlan {
    
    
        public ArrayList<BETimePlan> getAll(){
        ArrayList<BETimePlan> res = new ArrayList<>();
       BETimePlan c = new BETimePlan("HL", "Bent", 10, 2, 2, "X8989");
            res.add(c);
       BETimePlan B = new BETimePlan("BM", "Lars", 5, 2, 4, "K2323");
            res.add(B);
            return res;
    }
}
