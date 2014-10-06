/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DataAccess;

public interface IDataManagement {
    IResponse exec(IRequest r);
    void subscription(IObserver v);
}
