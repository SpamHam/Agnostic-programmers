/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import BE.BEMaterial;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLMaterial {
    
        public ArrayList<BEMaterial> getAll(){
        ArrayList<BEMaterial> res = new ArrayList<>();
        BEMaterial a = new BEMaterial("Pulverslukker", 2);
        res.add(a);
        BEMaterial b = new BEMaterial("Flydespærringer", 3);
        res.add(b);
        BEMaterial c = new BEMaterial("Lysmateriel", 4);
        res.add(c);
        BEMaterial d = new BEMaterial("C-slanger", 16);
        res.add(d);
        BEMaterial e = new BEMaterial("Flasker (300 bar)", 12);
        res.add(e);
        return res;
    }
    
}
