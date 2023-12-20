package com.example.function.service;

import com.example.function.dto.AnimalDto;
import com.example.function.dto.Type;
import com.example.function.response.AnimalsResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    public AnimalsResponse getAnimals(List<AnimalDto> animals) {
        List<String> cats = List.of("cat, tiger, lion");
        return listCommand(
            animals,
            animal ->
                cats.stream().anyMatch(v -> v.contains(animal.getName()))
                    ? Pair.of(Type.CAT, animal)
                    : Pair.of(Type.DOG, animal)
        );
    }

    public AnimalsResponse listCommand(List<AnimalDto> animals, PairFunction pairMapper) {
        Map<Type, List<AnimalDto>> collect = animals.stream()
            .map(pairMapper)
            .collect(Collectors.groupingBy(Pair::getFirst, Collectors.mapping(Pair::getSecond, Collectors.toList())));
        List<AnimalDto> cats = collect.get(Type.CAT);
        List<AnimalDto> dogs = collect.get(Type.DOG);
        return new AnimalsResponse(toName(cats), toName(dogs));
    }

    private List<String> toName(List<AnimalDto> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream()
            .map(AnimalDto::getName)
            .collect(Collectors.toList());
    }
}
