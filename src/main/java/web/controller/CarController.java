package web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.sercive.CarService;
import web.sercive.CarServiceImpl;

@Controller
public class CarController {

  @Autowired
  private CarServiceImpl carService;

  @GetMapping(value = "/cars")
  public String printCarTable(@RequestParam(value = "count", required = false) Integer count,
      Model model) {
    if (count == null) {
			count = -1;
    }
    List<Car> cars = carService.getCars(count);
    model.addAttribute("cars", cars);
    return "car";
  }
}