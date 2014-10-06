/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.GettingAirportSchedule;

import Model.AplicationObject.IAirport;
import Model.AplicationObject.IFlight;
import java.util.Map;
import java.util.UUID;

public interface IAirportSchedule {
    Map<UUID, IFlight> all(IAirport airport);
    boolean validate(IAirport airport, IFlight flights);
}
