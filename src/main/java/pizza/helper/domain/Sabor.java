package pizza.helper.domain;

public enum Sabor {
    MUSSARELA("mussarela"),
    CALABRESA("calabresa"),
    PORTUGUESA("portuguesa"),
    MARGUERITA("marguerita"),
    FRANGO("frango"),
    PALMITO("palmito"),
    QUATRO_QUEIJOS("quatro_queijos"),
    DOIS_QUEIJOS("dois_queijos"),
    PEITO_DE_PERU("peito_de_peru")
    ;
    public String sabor;

    public String getSabor() {
        return sabor;
    }

    Sabor(String value) {
        this.sabor = value;
    }

    public static Sabor fromValue(String name){
        for(Sabor sabor :Sabor.values()){
            if(sabor.getSabor().equals(name)){
                return sabor;
            }
        }
        return null;
    }
}
