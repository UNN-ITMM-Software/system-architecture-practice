/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirplaneManagement;

import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class BAirplaneManagement {
    static public IAirplaneManagement build(IRole r)
    {
        return new AirplaneManagement(r);
    }
}
