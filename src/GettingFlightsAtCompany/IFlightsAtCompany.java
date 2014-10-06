/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GettingFlightsAtCompany;

import AplicationObject.IFlight;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Evgeniy
 */
public interface IFlightsAtCompany {
    Iterator<IFlight> all();
    Iterator<IFlight> since(Date from);
    boolean validate(IFlight flights);
}
