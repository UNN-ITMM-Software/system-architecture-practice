/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Example;

import Presentation.AirplaneManagement.BAirplaneManagement;
import Presentation.AirplaneManagement.IAirplaneManagement;
import Infrastructure.GettingAirportAccess.BAirport;
import Model.AplicationObject.IAirplane;
import Model.AplicationObject.IAirport;
import Model.AplicationObject.IFlight;
import Presentation.ManagementFlightsAtCompany.BManagementFlights;
import Presentation.ManagementFlightsAtCompany.IManagementFlights;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import View.ViewAirplaneText;
import View.ViewAllFlightsText;
import java.util.Date;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

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
