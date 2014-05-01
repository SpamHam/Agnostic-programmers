/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import BE.BECRUDFireman;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLCRUDFireman {
    
        public ArrayList<BECRUDFireman> getAll(){
        ArrayList<BECRUDFireman> res = new ArrayList<>();
        BECRUDFireman c = new BECRUDFireman("3007901556", "Bent", "Andreasen");
            res.add(c);
       BECRUDFireman B = new BECRUDFireman("2902901447", "Lars", "Jesus");
            res.add(B);
            return res;
    }
    
}
