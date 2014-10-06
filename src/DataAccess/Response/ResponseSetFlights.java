/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Response;

import AplicationObject.EResponseState;
import AplicationObject.IFlight;
import DataAccess.IResponse;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Evgeniy
 */
public class ResponseSetFlights  extends ResponseSimple
    implements IResponse {

    Collection<IFlight> flights = null;

    public ResponseSetFlights(EResponseState st, Collection<IFlight> flights) {
        super(st);
        this.flights = flights;
    }

    public Iterator<IFlight> iterator()
    {
        return flights.iterator();
    }

}
