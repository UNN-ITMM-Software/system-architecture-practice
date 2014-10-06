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
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public class BFlights {
    public static IFlight build(UUID id, IAirport startAirport, IAirport finishAirport,
                   IAirplane airplane, Date departureTime, Date arrivalTime)
    {
        return new Flight(id, startAirport, finishAirport, airplane, departureTime, arrivalTime);
    }
}
