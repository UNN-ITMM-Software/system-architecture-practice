/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestHandlers;

import Model.DataAccess.IHandler;

public class BBuildTestHandler {
    static public IHandler buildAiplanesHandler(){
        return new SubModelAirplaneStorage();
    }
    static public IHandler buildFlightsHandler(){
        return new SubModelFlightsStorage();
    }
}
