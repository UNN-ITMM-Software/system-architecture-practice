/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.GettingAirportAccess;

public class BAirportAccess {
    static public IAirportAccess build(){
        return new AirportAccess();
    }
}
