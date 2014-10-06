/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import AirplaneManagement.BAirplane;
import AplicationObject.IAirplane;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import UI.IView;
import DataAccess.Request.RequestAddAirplane;
import UI.ViewAirplaneText;
import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
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
