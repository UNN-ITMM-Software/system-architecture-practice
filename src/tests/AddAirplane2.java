/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import AirplaneManagement.BAirplaneManagement;
import AirplaneManagement.IAirplaneManagement;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import UI.IView;
import UI.ViewAirplaneText;
import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class AddAirplane2 {
    public static void main(String[] args) {
        IRole userRole = BAuthentication.getRole("user", "123");
        IDataManagement dt = BDataManagement.build();
        
        ViewAirplaneText view = new ViewAirplaneText();
        view.init(userRole);
        
        dt.subscription(view);
     
        IAirplaneManagement am = BAirplaneManagement.build(null);
        am.buy();
        
        am.buy();
    }
}
