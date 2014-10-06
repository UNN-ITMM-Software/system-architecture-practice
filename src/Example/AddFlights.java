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
import Model.AplicationObject.IFlight;
import Presentation.ManagementFlightsAtCompany.BFlights;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import Model.Request.RequestAddFlight;
import View.ViewAirplaneText;
import View.ViewAllFlightsText;
import java.util.Date;
import java.util.UUID;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

public class AddFlights {
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
        
        IFlight fl = BFlights.build(UUID.randomUUID(), 
                BAirport.build("первый"), BAirport.build("второй"), 
                ap1, new Date(), new Date());
        RequestAddFlight addF = new RequestAddFlight(manegerRole, fl);
        
        dm.exec(addF);        
        
        fl = BFlights.build(UUID.randomUUID(), 
                BAirport.build("второй"), BAirport.build("первый"),  
                ap2, new Date(), new Date());
        addF = new RequestAddFlight(manegerRole, fl);
        
        dm.exec(addF);
       
    }
}
