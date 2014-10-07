/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestHandlers;

import Model.DataAccess.IHandler;
import Model.RepositoryInterface.IBInfrastructure;

public class BBuildTestHandler {
    static public IHandler buildAiplanesHandler(IBInfrastructure infr){
        return new SubModelAirplaneStorage(infr);
    }
    static public IHandler buildFlightsHandler(IBInfrastructure infr){
        return new SubModelFlightsStorage(infr);
    }
}
