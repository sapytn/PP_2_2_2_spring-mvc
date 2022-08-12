package web.sercive;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import web.model.Car;

@Service
public class CarServiceImpl implements CarService {

  private static List<Car> cars = new ArrayList<>() {{
     add(new Car("VW", "POLO", 2019));
     add(new Car("HYUNDAI","SOLARIS", 2018));
     add(new Car("KIO", "RIO", 2020));
     add(new Car("LADA", "VESTA", 2014));
     add(new Car("RENO", "LOGAN", 2008));
    }};



  @Override
  public List<Car> getCars(int count) {
    if(count < 0) {
      return cars;
    }

    return cars.stream().limit(count).toList();
  }
}
