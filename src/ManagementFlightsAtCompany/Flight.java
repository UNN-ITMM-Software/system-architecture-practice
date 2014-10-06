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
class Flight implements IFlight{

    UUID id;
    IAirport startAirport;
    IAirport finishAirport;
    IAirplane airplane;
    Date departureTime;
    Date arrivalTime;

    public Flight(UUID id, IAirport startAirport, IAirport finishAirport,
                   IAirplane airplane, Date departureTime, Date arrivalTime)
    {
        this.id = id;
        this.startAirport = startAirport;
        this.finishAirport = finishAirport;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public UUID flightsID() {
        return id;
    }

    @Override
    public IAirport startAirport() {
        return startAirport;
    }

    @Override
    public IAirport finishAirport() {
        return finishAirport;
    }

    @Override
    public IAirplane airplane() {
        return airplane;
    }

    @Override
    public Date departureTime() {
        return departureTime;
    }

    @Override
    public Date arrivalTime() {
        return arrivalTime;
    }

}
