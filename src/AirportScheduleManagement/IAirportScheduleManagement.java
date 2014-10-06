/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirportScheduleManagement;

import AplicationObject.IAirport;
import AplicationObject.IFlight;

/**
 *
 * @author Evgeniy
 */
public interface IAirportScheduleManagement {
    boolean addFlight(IAirport airport, IFlight flights);
    boolean cancelFlight(IAirport airport, IFlight flights);
}
