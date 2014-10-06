/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.GettingAirportAccess;

import Model.AplicationObject.IAirport;
import java.util.UUID;

class Airport implements IAirport{

    UUID id = UUID.randomUUID();
    String name="";
    
    public Airport(String name){
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
