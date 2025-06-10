package org.example.blogplatforms.userss;

import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class UsersService {
        private final UsersRepository usersRepository;
        public UsersService(UsersRepository usersRepository) {
            this.usersRepository = usersRepository;
        }
        public Users createUser(Users users){

            return usersRepository.save(users);
        }
        public Users getUserById(long id){
            return usersRepository.findById(id).orElse(null);
        }
        public List<Users> getAllUsers(){
            return usersRepository.findAll();
        }
        public void deleteUserById(long id)
        throws IllegalArgumentException{
            if(!usersRepository.existsById(id)){}
            else{throw new IllegalArgumentException("User not found");
            }
            usersRepository.deleteById(id);
        }
        public Users updateUser(Users users){
            var user = usersRepository.findById(users.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
            user.setUsername(users.getUsername());
            user.setEmail(users.getEmail());

            return usersRepository.save(users);
        }

    }


