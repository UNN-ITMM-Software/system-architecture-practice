/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Example;

import Presentation.AirplaneManagement.BAirplane;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import Model.Request.RequestAddAirplane;
import View.ViewAirplaneText;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

public class AddAirplane {
    public static void main(String[] args) {
        IRole userRole = BAuthentication.getRole("user", "123");
        IRole manegerRole = BAuthentication.getRole("manager", "123");
        IDataManagement dt = BDataManagement.build();
        IAirplane airplane = BAirplane.build();
        
        ViewAirplaneText view = new ViewAirplaneText();
        view.init(userRole);
        
        dt.subscription(view);
        
        RequestAddAirplane rAddAirplane;
        rAddAirplane= new RequestAddAirplane(userRole, airplane);
        dt.exec(rAddAirplane);
        
        rAddAirplane = new RequestAddAirplane(manegerRole, airplane);
        dt.exec(rAddAirplane);
        
        rAddAirplane = new RequestAddAirplane(manegerRole, airplane);
        dt.exec(rAddAirplane);
    }
}
