package pe.edu.upc.technicalservice;

import pe.edu.upc.technicalservice.domain.model.Engineer;
import pe.edu.upc.technicalservice.domain.repository.EngineerRepository;
import pe.edu.upc.technicalservice.domain.service.EngineerService;
import pe.edu.upc.technicalservice.exception.ResourceNotFoundException;
import pe.edu.upc.technicalservice.service.EngineerServiceImpl;
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
public class EngineerServiceImplIntegrationTest {

    @MockBean
    private EngineerRepository engineerRepository;

    @Autowired
    private EngineerService engineerService;

    @TestConfiguration
    static class EngineerServiceImplTestConfiguration {
        @Bean
        public EngineerService engineerService() {
            return new EngineerServiceImpl();
        }
    }

    @Test
    @DisplayName("When GetEngineerByEmail With Valid Email Then Returns Engineer")
    public void whenGetEngineerByEmailWithValidEmailThenReturnsEngineer() {
        // Arrange
        String email = "GreatEngineer@gmail.com";
        Engineer engineer = new Engineer();
        engineer.setId(1L);
        engineer.setEmail(email);
        //given(engineerRepository.findByEmail(engineer.getEmail()))
        //        .willReturn(Optional.of(engineer));
        when(engineerRepository.findByEmail(email))
                .thenReturn(Optional.of(engineer));

        // Act
        Engineer foundEngineer = engineerService.getEngineerByEmail(email);

        // Assert
        assertThat(foundEngineer.getEmail()).isEqualTo(email);

    }

    @Test
    @DisplayName("When GetEngineerByEmail With Invalid Email Then Returns ResourceNotFoundException")
    public void whenGetEngineerByEmailWithInvalidEmailThenReturnsResourceNotFoundException() {
        // Arrange
        String email = "Great Engineer";
        String template = "Resource %s not found for %s with value %s";
        when(engineerRepository.findByEmail(email))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Engineer", "Email", email);

        // Act
        Throwable exception = catchThrowable(() -> {
            Engineer foundEngineer = engineerService.getEngineerByEmail(email);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }


}
