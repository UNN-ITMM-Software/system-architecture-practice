/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DataAccess;

import Model.Logon.IRole;
import Model.RepositoryInterface.IBInfrastructure;

public interface IRequest {
    IRole getRole();
    IResponse exec(IBInfrastructure infrastructure);
    boolean can();
}
