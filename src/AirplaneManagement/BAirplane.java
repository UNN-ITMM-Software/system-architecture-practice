/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirplaneManagement;

import AplicationObject.IAirplane;

/**
 *
 * @author Evgeniy
 */
public class BAirplane {
    static public IAirplane build()
    {
        return new Airplane();
    }
}
