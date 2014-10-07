/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;

/**
 *
 * @author Evgeniy
 */
public interface IInfrastructureHandler {
    IResponse exec(IRequest r);
}
