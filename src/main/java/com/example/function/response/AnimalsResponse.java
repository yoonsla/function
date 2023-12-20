package com.example.function.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AnimalsResponse {

    List<String> cats;
    List<String> dogs;
}
