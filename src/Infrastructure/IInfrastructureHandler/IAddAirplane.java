/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.IInfrastructureHandler;

import Model.DataAccess.IRrepository;
import Model.DataAccess.IResponse;
import Model.Request.RequestAddAirplane;

public interface IAddAirplane extends IRrepository{
    IResponse add(RequestAddAirplane r);
}
