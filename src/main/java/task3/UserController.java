package task3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto dto) {
        var user = userService.saveUser(dto);
        return userConverter.convert(user);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        var user = userService.findUserById(id);
        return userConverter.convert(user);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UpdateUserDto dto) {
        userService.update(id, dto);
        return userConverter.convert(user);
    }
}
