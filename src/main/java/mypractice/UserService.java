package mypractice;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}


//    @Component
//    public class DetailsService implements UserDetailsService {
//
//        @Autowired
//        UserRepository users;
//
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//            mypractice.User user = users.findByUsername(username);
//            if (user == null){
//                throw new UsernameNotFoundException(username + " was not found");
//            }
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    user.getPassword(),
//                    AuthorityUtils.createAuthorityList(user.getRoles())
//            );
//        }
//    }

