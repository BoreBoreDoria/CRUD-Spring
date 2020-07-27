package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Car;
import web.service.CarService;

import java.util.List;
import java.util.Map;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/")
    public ModelAndView allCars(){
        List<Car> cars = carService.listAll();
        ModelAndView modelAndView = new ModelAndView("cars");
        modelAndView.addObject("listCars",cars);
        return modelAndView;
    }


    @RequestMapping("/new")
    public String newCarForm(Map<String, Object> model){
        Car car = new Car();
        model.put("car", car);
        return "new_car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("car") Car car) {
        carService.save(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCar(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        carService.delete(id);
        return modelAndView;
    }
}
