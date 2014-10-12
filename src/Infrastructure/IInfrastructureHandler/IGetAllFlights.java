/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.IInfrastructureHandler;

import Model.DataAccess.IRrepository;
import Model.DataAccess.IResponse;
import Model.Request.RequestAllFlights;

public interface IGetAllFlights  extends IRrepository{
    IResponse get(RequestAllFlights r);
}
