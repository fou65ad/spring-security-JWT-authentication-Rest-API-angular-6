package ma.fouad.spingjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fouad.spingjwt.entities.AppRole;

public interface RoleRepository  extends JpaRepository<AppRole,Long> {
	public AppRole findByRoleName(String roleName);
}
