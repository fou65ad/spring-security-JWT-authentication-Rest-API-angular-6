package ma.fouad.spingjwt.service;

import ma.fouad.spingjwt.entities.AppRole;
import ma.fouad.spingjwt.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUserName(String username);
}
