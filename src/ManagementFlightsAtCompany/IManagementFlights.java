/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagementFlightsAtCompany;

import AplicationObject.IAirplane;
import AplicationObject.IAirport;
import AplicationObject.IFlight;
import java.util.Date;

/**
 *
 * @author Evgeniy
 */
public interface IManagementFlights {
    IFlight addFlight(IAirport start, IAirport finish,
                       IAirplane airplane,
                       Date departureTime, Date arrivalTime);
    boolean cancelFlight(IFlight flights);
}
