/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLFireman {

    public ArrayList<BE.BEFireman> getAll() {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        BE.BEFireman c = new BE.BEFireman("3007901556", "Bent", "Andreasen");
        res.add(c);
        BE.BEFireman B = new BE.BEFireman("2902901447", "Lars", "Jesus");
        res.add(B);
        return res;
    }

}
