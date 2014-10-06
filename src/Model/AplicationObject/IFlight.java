/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.AplicationObject;

import java.util.Date;
import java.util.UUID;

public interface IFlight{
    UUID flightsID();
    IAirport startAirport();
    IAirport finishAirport();
    IAirplane airplane();
    Date departureTime();
    Date arrivalTime();
}
