package work.icql.springboot.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-17T11:13:20+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTO do2dto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsercode( user.getUsercode() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setAge( user.getAge() );
        userDTO.setMemo( user.getMemo() );

        userDTO.setDeleted( user.getDeleted() == 1 ? "是" : "否" );

        return userDTO;
    }

    @Override
    public List<User> do2dto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( users.size() );
        for ( User user : users ) {
            list.add( user );
        }

        return list;
    }
}
