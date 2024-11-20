package com.demo.bar.port.out;

import java.util.List;

public interface LiquorStorageOutPort {

    boolean tryToGetIngredients(List<String> ingredients);

}
