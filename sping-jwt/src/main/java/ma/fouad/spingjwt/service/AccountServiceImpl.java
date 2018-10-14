package ma.fouad.spingjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.fouad.spingjwt.dao.RoleRepository;
import ma.fouad.spingjwt.dao.UserRepository;
import ma.fouad.spingjwt.entities.AppRole;
import ma.fouad.spingjwt.entities.AppUser;
@Service
@Transactional
public class  AccountServiceImpl implements AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
			AppRole role=roleRepository.findByRoleName(rolename);	
			AppUser user=userRepository.findByUsername(username);
			user.getRoles().add(role);

	}

	@Override
	public AppUser findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
