package com.acme.technical;

import com.acme.technical.domain.model.Administrator;
import com.acme.technical.domain.repository.AdministratorRepository;
import com.acme.technical.domain.service.AdministratorService;
import com.acme.technical.exception.ResourceNotFoundException;
import com.acme.technical.service.AdministratorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AdministratorServiceImplIntegrationTest {

    @MockBean
    private AdministratorRepository administratorRepository;

    @Autowired
    private AdministratorService administratorService;

    @TestConfiguration
    static class AdministratorServiceImplTestConfiguration {
        @Bean
        public AdministratorService administratorService() {
            return new AdministratorServiceImpl();
        }
    }

    @Test
    @DisplayName("When GetAdministratorByEmail With Valid Email Then Returns Administrator")
    public void whenGetAdministratorByEmailWithValidEmailThenReturnsAdministrator() {
        // Arrange
        String email = "GreatAdministrator@gmail.com";
        Administrator administrator = new Administrator();
        administrator.setId(1L);
        administrator.setEmail(email);
        //given(administratorRepository.findByEmail(administrator.getEmail()))
        //        .willReturn(Optional.of(administrator));
        when(administratorRepository.findByEmail(email))
                .thenReturn(Optional.of(administrator));

        // Act
        Administrator foundAdministrator = administratorService.getAdministratorByEmail(email);

        // Assert
        assertThat(foundAdministrator.getEmail()).isEqualTo(email);

    }

    @Test
    @DisplayName("When GetAdministratorByEmail With Invalid Email Then Returns ResourceNotFoundException")
    public void whenGetAdministratorByEmailWithInvalidEmailThenReturnsResourceNotFoundException() {
        // Arrange
        String email = "Great Administrator";
        String template = "Resource %s not found for %s with value %s";
        when(administratorRepository.findByEmail(email))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Administrator", "Email", email);

        // Act
        Throwable exception = catchThrowable(() -> {
            Administrator foundAdministrator = administratorService.getAdministratorByEmail(email);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }


}
