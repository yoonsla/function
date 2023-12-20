package com.example.function.service;

import com.example.function.dto.AnimalDto;
import com.example.function.dto.Type;
import java.util.function.Function;
import org.springframework.data.util.Pair;

public interface PairFunction extends Function<AnimalDto, Pair<Type, AnimalDto>> {

    Pair<Type, AnimalDto> apply(AnimalDto t);
}

