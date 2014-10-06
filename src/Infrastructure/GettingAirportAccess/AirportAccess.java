/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.GettingAirportAccess;

import Model.AplicationObject.IAirport;
import java.util.Iterator;
import java.util.UUID;
import Model.Logon.IRole;

class AirportAccess implements IAirportAccess{

    
    @Override
    public IAirport getAccess(IRole role, UUID airportID) {
        return ModelAllAirports.allAirport.get(airportID);
    }

    @Override
    public IAirport getAccess(IRole role, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<IAirport> all(IRole role) {
        return ModelAllAirports.allAirport.values().iterator();
    }
    
}
