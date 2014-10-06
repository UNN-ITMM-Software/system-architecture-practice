/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Example;

import Presentation.AirplaneManagement.BAirplaneManagement;
import Presentation.AirplaneManagement.IAirplaneManagement;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import View.ViewAirplaneText;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

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
