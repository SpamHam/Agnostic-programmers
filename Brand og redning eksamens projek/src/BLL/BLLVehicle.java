/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import BE.BEVehicle;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicle {
        public ArrayList<BEVehicle> getAll(){
        ArrayList<BEVehicle> res = new ArrayList<>();
        BEVehicle c = new BEVehicle(12345, "Man", "a3");
        res.add(c);
        BEVehicle b = new BEVehicle(34211, "BMW", "m3");
        res.add(b);
        return res;           
                   
    }
}
