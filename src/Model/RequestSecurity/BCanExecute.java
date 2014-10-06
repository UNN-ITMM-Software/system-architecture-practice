/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestSecurity;

/**
 *
 * @author Evgeniy
 */
public class BCanExecute {
    static ICanExecute canExecute= new CanExecute();
    public static ICanExecute build(){
        return canExecute;
    }
}
