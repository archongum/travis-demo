package springweb.service.impl;

import org.springframework.stereotype.Service;
import springweb.domain.Phone;
import springweb.mapper.PhoneMapper;
import springweb.service.PhoneService;


/**
 * @author Archon  12/3/2021
 * @since
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneMapper phoneMapper;

    public PhoneServiceImpl(PhoneMapper phoneMapper) {
        this.phoneMapper = phoneMapper;
    }

    @Override
    public Phone getPhone(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("Name should not exceed 5, current value: " + name);
        }

        String type = phoneMapper.getPhoneType(name);
        // bad
//        return new Phone(type, name);
        // good
        return new Phone(name, type);
    }
}
