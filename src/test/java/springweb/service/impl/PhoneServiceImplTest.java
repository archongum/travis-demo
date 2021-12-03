package springweb.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springweb.domain.Phone;
import springweb.mapper.PhoneMapper;


@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplTest {

    @Mock
    private PhoneMapper phoneMapper;

    private PhoneServiceImpl phoneServiceImpl;

    @Before
    public void before() {
        phoneServiceImpl = new PhoneServiceImpl(phoneMapper);
    }

    @Test
    public void getPhone_ShouldReturnPhone() {
        BDDMockito.given(phoneMapper.getPhoneType("iPhone")).willReturn("Apple");

        Assertions.assertThat(phoneServiceImpl.getPhone("iPhone"))
            .isEqualTo(new Phone("iPhone", "Apple"))
            .isNotEqualTo(new Phone("iPhone", "B"));
    }
}
