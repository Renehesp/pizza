package pizza.helper.service;

import pizza.helper.domain.Pedaco;
import pizza.helper.api.requests.Request;
import pizza.helper.api.responses.Response;
import pizza.helper.domain.Pizza;

import java.util.*;

public class PizzaManagementService {

    private final Map<String, Integer> LISTA_SABORES = new HashMap<>();
    private final List<Pizza> PIZZAS = new ArrayList<>();
    
    private Pizza PIZZA_INCOMPLETA_3 = new Pizza();
    private Pizza PIZZA_INCOMPLETA_4 = new Pizza();
    private Pizza PIZZA_INCOMPLETA_6 = new Pizza();

    public Response processa(List<Pedaco> pedacos){
       processaRequest(pedacos);
       processaSabores();
       return getResponse();

    }

    private void processaRequest(List<Pedaco> pedacos) {
        pedacos.forEach(request -> {
            while (request.getQuantidade() >= 7){
                PIZZAS.add(new Pizza(request.getSabor()));
                request.setQuantidade(request.getQuantidade() - 8);
            }
            if(request.getQuantidade() > 0){
                LISTA_SABORES.put(request.getSabor(), request.getQuantidade());
            }
        });
    }

    private void processaSabores() {
        LISTA_SABORES.forEach((sbr,qty)->{
            if (qty <= 3) {
                if(PIZZA_INCOMPLETA_6.getNumPedacos() == 6){
                    PIZZA_INCOMPLETA_6.addPedaco(sbr, 3);
                    PIZZAS.add(PIZZA_INCOMPLETA_6.clone());
                    PIZZA_INCOMPLETA_6.reset();
                }else if(PIZZA_INCOMPLETA_3.getNumPedacos() == 3){
                    PIZZA_INCOMPLETA_6.addPedaco(PIZZA_INCOMPLETA_3.clone(), sbr, 3);
                    PIZZA_INCOMPLETA_3.reset();
                } else{
                    PIZZA_INCOMPLETA_3.addPedaco(sbr,3);
                }
            } else if(qty == 4){
                if(PIZZA_INCOMPLETA_4.getNumPedacos() == 4){
                    PIZZA_INCOMPLETA_4.addPedaco(sbr,4);
                    PIZZAS.add(PIZZA_INCOMPLETA_4.clone());
                    PIZZA_INCOMPLETA_4.reset();
                } else {
                    PIZZA_INCOMPLETA_4.addPedaco(sbr,4);
                }

            } else {
                if(PIZZA_INCOMPLETA_3.getNumPedacos() == 3){
                    PIZZA_INCOMPLETA_3.addPedaco(sbr, 6);
                    PIZZAS.add(PIZZA_INCOMPLETA_3.clone());
                    PIZZA_INCOMPLETA_3.reset();
                }else if(PIZZA_INCOMPLETA_6.getNumPedacos() == 6){
                    PIZZA_INCOMPLETA_6.addPedaco(sbr, 3);
                    PIZZA_INCOMPLETA_3.addPedaco(sbr, 3);
                    PIZZAS.add(PIZZA_INCOMPLETA_6.clone());
                    PIZZA_INCOMPLETA_6.reset();
                } else{
                    PIZZA_INCOMPLETA_6.addPedaco(sbr,6);
                }
            }
        });
        if(PIZZA_INCOMPLETA_4.getNumPedacos() == 4 && PIZZA_INCOMPLETA_3.getNumPedacos() == 3){
            PIZZA_INCOMPLETA_4.addPedaco(PIZZA_INCOMPLETA_3.getSabores().keySet().stream().findFirst().get(),4);
            PIZZAS.add(PIZZA_INCOMPLETA_4.clone());
            PIZZA_INCOMPLETA_4.reset();
            PIZZA_INCOMPLETA_3.reset();
        } else if (PIZZA_INCOMPLETA_4.getNumPedacos() == 4 && PIZZA_INCOMPLETA_6.getNumPedacos() == 6){
            String sabor = PIZZA_INCOMPLETA_6.getSabores().keySet().stream().findFirst().get();
            PIZZA_INCOMPLETA_4.addPedaco(sabor,4);
            PIZZAS.add(PIZZA_INCOMPLETA_4.clone());
            PIZZA_INCOMPLETA_4.reset();
            PIZZA_INCOMPLETA_6.reset();
            PIZZA_INCOMPLETA_3.addPedaco(sabor,3);
        }
    }

    private Response getResponse(){
        if(PIZZA_INCOMPLETA_3.getNumPedacos() != 0){
            return new Response(PIZZAS,PIZZA_INCOMPLETA_3);
        } else if(PIZZA_INCOMPLETA_4.getNumPedacos() != 0){
            return new Response(PIZZAS,PIZZA_INCOMPLETA_4);
        } else if(PIZZA_INCOMPLETA_6.getNumPedacos() != 0){
            return new Response(PIZZAS,PIZZA_INCOMPLETA_6);
        } else{
            return new Response(PIZZAS);
        }
    }
}
