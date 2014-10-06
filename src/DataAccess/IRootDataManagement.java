/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Evgeniy
 */
interface IRootDataManagement extends IDataManagement{
    void addHandler(IHandler h);
}
