package pizza.helper.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class Pizza {

    @JsonIgnore
    private int pedacos;

    private HashMap<String, Integer> sabores;

    public Pizza() {
        sabores = new HashMap<>();
        pedacos = 0;
    }

    public Pizza(String sabor) {
        this.sabores = new HashMap<String, Integer>(){
            {
                put(sabor, 8);
            }
        };
        this.pedacos = 8;
    }

    public Map<String, Integer> getSabores() {
        return sabores;
    }

    public void addPedaco(String sabor, int qty) {
        sabores.compute(sabor, (token, oldValue)-> oldValue == null ? qty : oldValue + qty);
        pedacos += qty;
    }

    public void addPedaco(Pizza pizza, String sabor, int qty) {
        sabores.putAll(pizza.getSabores());
        sabores.compute(sabor, (token, oldValue)-> oldValue == null ? qty : oldValue + qty);
        pedacos += qty + pizza.getNumPedacos();
    }

    @JsonIgnore
    public int getNumPedacos() {
        return pedacos;
    }

    public void printPizza(String name) {
        System.out.println("Pizza "+name+":");
        sabores.forEach((x,y)->{
            System.out.println("\t"+x+": "+y);
        });
    }

    public void printPizza(int i) {
        System.out.println("Pizza "+i+":");
       sabores.forEach((x,y)->{
           System.out.println("\t"+x+": "+y);
       });
    }

    public void reset(){
        pedacos = 0;
        sabores.clear();
    }

    @JsonIgnore
    public Pizza clone(){
        Pizza pizza = new Pizza();
        pizza.pedacos = this.pedacos;
        pizza.sabores = new HashMap<>(this.sabores);
        return pizza;
    }
}
