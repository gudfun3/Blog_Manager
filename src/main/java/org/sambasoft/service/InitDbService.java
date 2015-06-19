package org.sambasoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.sambasoft.entities.Blog;
import org.sambasoft.entities.Item;
import org.sambasoft.entities.Role;
import org.sambasoft.entities.User;
import org.sambasoft.repositories.BlogRepository;
import org.sambasoft.repositories.ItemRepository;
import org.sambasoft.repositories.RoleRepository;
import org.sambasoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void initdb(){
		 Role roleUser = new Role();
		 roleUser.setName("ROLE_USER");
		 roleRepository.save(roleUser);
		 Role roleAdmin = new Role();
		 roleAdmin.setName("ROLE_Admin");
		 roleRepository.save(roleAdmin);
		 
		 User userAdmin = new User();
		 userAdmin.setName("admin");
		 List<Role> roles = new ArrayList<Role>();
		 roles.add(roleAdmin);
		 roles.add(roleUser);
		 userAdmin.setRoles(roles);
		 userRepository.save(userAdmin);
		 
		  Blog  blogone = new Blog();
		  blogone.setName("google");
		  blogone.setUrl("www.google.com");
		  blogone.setUser(userAdmin);
	      blogRepository.save(blogone);
	      
	      Item itemone = new Item();
	      itemone.setBlog(blogone);
	      itemone.setTitle("firstblog");
	      itemone.setLink("www.google.com");
	      itemone.setPublishishedDate(new Date());
	      itemRepository.save(itemone);
	      
	      Item itemtwo = new Item();
	      itemtwo.setBlog(blogone);
	      itemtwo.setTitle("secondtblog");
	      itemtwo.setLink("www.yahoo.com");
	      itemtwo.setPublishishedDate(new Date());
	      itemRepository.save(itemtwo);
	      
	      
	      
		  
		  
		 
		 
		 
		 
		
	}

}
