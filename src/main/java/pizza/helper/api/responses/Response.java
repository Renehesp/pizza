package pizza.helper.api.responses;

import pizza.helper.domain.Pizza;

import java.util.List;

public class Response {

    private List<Pizza> pizzas;

    private Pizza incompleta;

    public Response(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Response(List<Pizza> pizzas, Pizza incompleta) {
        this.pizzas = pizzas;
        this.incompleta = incompleta;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Pizza getIncompleta() {
        return incompleta;
    }

    public void setIncompleta(Pizza incompleta) {
        this.incompleta = incompleta;
    }
}
