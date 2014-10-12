/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DataAccess;

/**
 *
 * @author Evgeniy
 */
public interface IRepository {
    IResponse exec(IRequest r);
}
