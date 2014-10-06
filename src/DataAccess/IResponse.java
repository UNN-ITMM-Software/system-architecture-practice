/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import AplicationObject.EResponseState;

/**
 *
 * @author Evgeniy
 */
public interface IResponse {
    EResponseState state();
    boolean isValid();
}
