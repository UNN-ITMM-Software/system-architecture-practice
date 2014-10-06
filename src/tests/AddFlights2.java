/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import AirplaneManagement.BAirplaneManagement;
import AirplaneManagement.IAirplaneManagement;
import GettingAirportAccess.BAirport;
import AplicationObject.IAirplane;
import AplicationObject.IAirport;
import AplicationObject.IFlight;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import UI.IView;
import ManagementFlightsAtCompany.BManagementFlights;
import ManagementFlightsAtCompany.IManagementFlights;
import UI.ViewAirplaneText;
import UI.ViewAllFlightsText;
import java.util.Date;
import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class AddFlights2 {
    public static void main(String[] args) {
        IRole manegerRole = BAuthentication.getRole("manager", "123");
        IDataManagement dm = BDataManagement.build();
        
        ViewAirplaneText view1 = new ViewAirplaneText();
        ViewAllFlightsText view2 = new ViewAllFlightsText();
        view1.init(manegerRole);
        view2.init(manegerRole);
        
        dm.subscription(view1);
        dm.subscription(view2);
        
        IAirplaneManagement am = BAirplaneManagement.build(null);
        IAirplane ap1 = am.buy();
        IAirplane ap2 = am.buy();
        
        IAirport airport1 = BAirport.build("первый");
        IAirport airport2 = BAirport.build("второй");
        
        IManagementFlights mfl = BManagementFlights.build(manegerRole);
        
        IFlight fl1 = mfl.addFlight(airport1, airport2, ap1, 
                new Date(), new Date());
        IFlight fl2 = mfl.addFlight(airport2, airport1, ap2, 
                new Date(), new Date());
        
        mfl.cancelFlight(fl1);

    }
}
