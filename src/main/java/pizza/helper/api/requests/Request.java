package pizza.helper.api.requests;

import pizza.helper.domain.Pedaco;

import java.util.List;

public class Request {

    private List<Pedaco> pedacos;

    public List<Pedaco> getPedacos() {
        return pedacos;
    }

    public void setPedacos(List<Pedaco> pedacos) {
        this.pedacos = pedacos;
    }
}
