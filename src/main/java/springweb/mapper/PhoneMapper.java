package springweb.mapper;

import org.mapstruct.Mapper;


/**
 * @author Archon  12/3/2021
 * @since
 */
@Mapper
public interface PhoneMapper {
    String getPhoneType(String name);
}
