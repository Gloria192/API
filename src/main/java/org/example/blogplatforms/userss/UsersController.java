package org.example.blogplatforms.userss;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "Users", description = "The Users API")

public class UsersController {
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @GetMapping
    @Operation(summary = "Get all users")
    public Iterable<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
    @PostMapping
    @Operation
            (summary ="enter the user")
    public  Users createUser(@RequestBody UsersCreationDto Dto){
        Users user=new Users();
        user.setUsername(Dto.getUsername());
        user.setEmail(Dto.getEmail());
        return usersService.createUser(user);
    }
    @PutMapping("/{id}")
    @Operation
            (summary = "the updated users")
    public Users updateduser(@PathVariable long id,@RequestBody UsersCreationDto Dto) {
        Users user = new Users();
        user.setId(id);
        user.setUsername(Dto.getUsername());
        user.setEmail(Dto.getEmail());
        return usersService.updateUser(user);
    }

        @DeleteMapping("/{id}")
        @Operation(summary = "Delete a user by ID")
        public ResponseEntity<String> deleteUser(@PathVariable long id) {
            var user = usersRepository.findById(id);

            if (user.isPresent()) {
                usersRepository.delete(user.get());
                return ResponseEntity.ok("User deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        }


@DeleteMapping
    @Operation(summary = "Delete all users")
    public void deleteUserById() {
        usersRepository.deleteAll();
    }


    }
