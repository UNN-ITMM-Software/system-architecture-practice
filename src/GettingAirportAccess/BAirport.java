/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GettingAirportAccess;

import AplicationObject.IAirport;

/**
 *
 * @author Evgeniy
 */
public class BAirport {
    static public IAirport build(String name){
        IAirport ap = new Airport(name);
        ModelAllAirports.allAirport.put(ap.getID(), ap);
        return ap;
    }
}
