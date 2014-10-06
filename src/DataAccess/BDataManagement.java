/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DataAccess.subModel.BBuildTestHandler;

/**
 *
 * @author Evgeniy
 */
public class BDataManagement {
    static IRootDataManagement rdm = null;
    static public IDataManagement build(){
        if(rdm == null)
        {
            rdm = new RootDataManagement();
            rdm.addHandler(BBuildTestHandler.buildAiplanesHandler());
            rdm.addHandler(BBuildTestHandler.buildFlightsHandler());
        }
        return rdm;
    }
}
