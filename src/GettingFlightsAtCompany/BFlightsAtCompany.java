/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GettingFlightsAtCompany;

import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class BFlightsAtCompany {
    public static IFlightsAtCompany build(IRole r)
    {
        if(r == null)
        {
            r = BAuthentication.getRole();
        }
        return new FlightsAtCompany(r);
    }
}
