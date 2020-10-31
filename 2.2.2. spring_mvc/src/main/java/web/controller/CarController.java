package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/car")
    public String getCountCar(@RequestParam(value = "count", required = false) String count,
                              ModelMap model){
        List<String> messages = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Mazda", 3, "red"));
        cars.add(new Car("Ferrary", 430, "red"));
        cars.add(new Car("Porsche", 911, "yellow"));
        cars.add(new Car("BMW", 3, "blue"));
        cars.add(new Car("Tesla", 10, "white"));

        if(count == null){
            for (Car car : cars)
                messages.add(car.toString());
        } else {
            int countInt = Integer.parseInt(count);
            if (countInt >= 0 && countInt <= cars.size()) {
                for (int i = 0; i < countInt; i++) {
                    messages.add(cars.get(i).toString());
                }
            } else {
                for (Car car : cars)
                    messages.add(car.toString());
            }
        }
        model.addAttribute("messages", messages);
        return "car";
    }
}
