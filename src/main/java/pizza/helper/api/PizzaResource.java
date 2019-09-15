package pizza.helper.api;

import org.springframework.web.bind.annotation.*;
import pizza.helper.api.requests.Request;
import pizza.helper.api.responses.Response;
import pizza.helper.domain.Sabor;
import pizza.helper.service.PizzaManagementService;

import java.util.*;
import java.util.stream.Collectors;



@RestController
@CrossOrigin
public class PizzaResource {


    @GetMapping("/sabores")
    public List<String> getSabores(){
        return Arrays.stream(Sabor.values()).map(Sabor::name).collect(Collectors.toList());
    }

    @PostMapping("/calcula")
    public Response calculaPedido(@RequestBody Request request){
        PizzaManagementService service = new PizzaManagementService();
        return service.processa(request.getPedacos());
    }
}
