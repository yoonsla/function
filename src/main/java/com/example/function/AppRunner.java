package com.example.function;

import com.example.function.dto.AnimalDto;
import com.example.function.response.AnimalsResponse;
import com.example.function.service.TestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class AppRunner implements ApplicationRunner {

    private final TestService testService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<AnimalDto> animals = List.of(
            new AnimalDto("cat"),
            new AnimalDto("dog"),
            new AnimalDto("tiger"),
            new AnimalDto("lion"),
            new AnimalDto("wolf")
        );

        AnimalsResponse response = testService.getAnimals(animals);
        log.info(response);
    }
}
