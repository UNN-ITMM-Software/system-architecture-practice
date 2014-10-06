/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.ManagementFlightsAtCompany;

import Model.Logon.IRole;

public class BManagementFlights {
    static public IManagementFlights build(IRole r)
    {
        return new ManagementFlights(r);
    }
}
