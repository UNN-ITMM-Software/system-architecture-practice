/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestSecurity;

import Model.DataAccess.IRequest;
import Model.Logon.IRole;

/**
 *
 * @author Evgeniy
 */
public interface ICanExecute {
    boolean can(IRequest req);
}
