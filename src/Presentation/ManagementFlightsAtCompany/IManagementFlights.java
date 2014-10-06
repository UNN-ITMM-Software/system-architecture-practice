/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.ManagementFlightsAtCompany;

import Model.AplicationObject.IAirplane;
import Model.AplicationObject.IAirport;
import Model.AplicationObject.IFlight;
import java.util.Date;

public interface IManagementFlights {
    IFlight addFlight(IAirport start, IAirport finish, 
                       IAirplane airplane,
                       Date departureTime, Date arrivalTime);
    boolean cancelFlight(IFlight flights);
}
