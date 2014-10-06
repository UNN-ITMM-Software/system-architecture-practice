/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logon;

import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
class RoleUser implements IRole{
    
    String login;
    String pass;
    String name;
    
    public RoleUser(String name, String login, String pass){
        this.login = login;
        this.pass  = pass;
    }
    

    @Override
    public UUID getStatusID() {
        return RoleStatus.user;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
