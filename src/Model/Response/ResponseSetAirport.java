/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Response;

import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IResponse;
import java.util.Collection;
import java.util.Iterator;

public class ResponseSetAirport extends ResponseSimple
    implements IResponse {

    Collection<IAirplane> airplanes = null;
    
    public ResponseSetAirport(EResponseState st, Collection<IAirplane> airplanes) {
        super(st);
        this.airplanes = airplanes;
    }
    
    public Iterator<IAirplane> iterator()
    {
        return airplanes.iterator();
    }
    
}
