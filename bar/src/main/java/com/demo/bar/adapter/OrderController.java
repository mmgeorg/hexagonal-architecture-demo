package com.demo.bar.adapter;

import com.demo.bar.adapter.model.CocktailDTO;
import com.demo.bar.domain.model.Cocktail;
import com.demo.bar.port.in.CocktailOrderInPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private CocktailOrderInPort cocktailOrderPort;

    @PostMapping
    public CocktailDTO sendOrder(@RequestBody String orderRequest){

        Cocktail cocktail = cocktailOrderPort.heyGiveMeDrink(orderRequest);
        return CocktailDTO.from(cocktail);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleException(Exception exception, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
