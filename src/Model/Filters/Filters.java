/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Filters;

import Model.AplicationObject.IAirplane;
import Model.AplicationObject.IFlight;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public class Filters implements IFilters{

    @Override
    public Iterator<IFlight> flightsSinceDate(Iterator<IFlight> flights, Date from) {
        ArrayList<IFlight> al = new ArrayList<>();
        Iterator<IFlight> itr;
        IFlight fl;
        itr = flights;
        if(itr != null)
        {
            while(itr.hasNext())
            {
                fl = itr.next();
                if(fl.departureTime().after(from)){
                    al.add(fl);
                }
            }
        }
        return al.iterator();
    }

    @Override
    public boolean validateFlights(Iterator<IFlight> flights, IFlight flight) {
        Iterator<IFlight> itr;
        itr = flights;
        if(itr != null)
        {
            while(itr.hasNext())
            {
                if(itr.next().flightsID().equals(flight.flightsID())) return true;
            }
        }
        return false;
    }

    @Override
    public IAirplane findAirplaneByID(Iterator<IAirplane> airplanes, UUID id) {
        Iterator<IAirplane> itr = airplanes;
        if(itr != null)
        {
            while(itr.hasNext())
            {
                IAirplane airplane = itr.next();
                if(airplane.getID().equals(id))
                {
                    return airplane;
                }
            }
        }
        return null;
    }
    
}
