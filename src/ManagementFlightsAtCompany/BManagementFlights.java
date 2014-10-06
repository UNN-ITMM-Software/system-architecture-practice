/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagementFlightsAtCompany;

import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class BManagementFlights {
    static public IManagementFlights build(IRole r)
    {
        return new ManagementFlights(r);
    }
}
