/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Filters;

import Model.AplicationObject.IAirplane;
import Model.AplicationObject.IFlight;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public interface IFilters {
    Iterator<IFlight> flightsSinceDate(Iterator<IFlight> flights, Date from);
    boolean validateFlights(Iterator<IFlight> flights, IFlight flight);
    IAirplane findAirplaneByID(Iterator<IAirplane> airplanes, UUID id);
}
