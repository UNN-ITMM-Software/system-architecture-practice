/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logon;

/**
 *
 * @author Evgeniy
 */
public class RoleVerification {
    public static boolean isManager(IRole r){
        if(RoleStatus.manager.equals(r.getStatusID()))
        {
            return true;
        }
        return false;
    }

    public static boolean isUser(IRole r){
        if(RoleStatus.manager.equals(r.getStatusID()))
        {
            return true;
        }
        if(RoleStatus.user.equals(r.getStatusID()))
        {
            return true;
        }
        return false;
    }
}
