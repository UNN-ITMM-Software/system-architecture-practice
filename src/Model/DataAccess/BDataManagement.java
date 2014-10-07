/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DataAccess;

import Infrastructure.Repository.BInfrastructure;
import Model.RepositoryInterface.IBInfrastructure;
import Model.RequestHandlers.BBuildTestHandler;

public class BDataManagement {
    static IRootDataManagement rdm = null;
    static IBInfrastructure infr = null;
    static public IDataManagement build(){
        if(rdm == null)
        {
            rdm = new RootDataManagement();
            infr = new BInfrastructure();
            rdm.addHandler(BBuildTestHandler.buildAiplanesHandler(infr));
            rdm.addHandler(BBuildTestHandler.buildFlightsHandler(infr));
        }
        return rdm;
    }
}
