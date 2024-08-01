package com.example.cardapio;

import food.Food;
import food.FoodRepository;
import food.FoodRequestDTO;
import food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;

    }
}
