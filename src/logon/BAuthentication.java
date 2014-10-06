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
public class BAuthentication {
    final public static IRole getRole(String login, String pass)
    {
        IRole r;
        if(login.equals("manager") && pass.equals("123"))
        {
            return new RoleCompanyManager("Root", login, pass);
        }
        return new RoleUser(login, login, pass);
    }
    final public static IRole getRole()
    {
        return new RoleGuest();
    }
}
