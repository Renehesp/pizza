package pizza.helper.domain;

public enum Sabor {
    ABOBRINHA("abobrinha"),
    ABOBRINHAII("abobrinhaii"),
    ALCACHOFRA_ESPECIAL("alcachofra_especial"),
    ALEMA("alema"),
    ALICHE("aliche"),
    AMERICANA("americana"),
    A_MODA_DO_CHEFE("a_moda_do_chefe"),
    ATUM("atum"),
    ATUM_COM_MUSSARELA_OU_CATUPIRY("atum_com_mussarela_ou_catupiry"),
    ATUM_SOLIDO("atum_solido"),
    BACON_COM_MUSSARELA_OU_CATUPIRY("bacon_com_mussarela_ou_catupiry"),
    BAINANA("baiana"),
    BAIANA_ESPECIAL("baiana_especial"),
    BARI("bari"),
    BERINJELA("berinjela"),
    BROCOLIS("brocolis"),
    CALABRESA("calabresa"),
    CALABRESA_COM_BACON("calabresa_com_bacon"),
    CALABRESA_COM_MUSSARELA_OU_CATUPIRY("calabresa_com_mussarela_ou_catupiry"),
    CAMARAO("camarao"),
    CANADENSE("canadense"),
    CARNE_SECA("carne_seca"),
    CATUPIRY("catupiry"),
    CINCO_QUEIJOS("cinco_queijos"),
    DA_HORA("da_hora"),
    DA_MAMA("da_mama"),
    DELICIA("delicia"),
    DO_PAPA("do_papa"),
    DOIS_QUEIJOS("dois_queijos"),
    ESCAROLA("escarola"),
    EXPRESSO("expresso"),
    FLORENCA("florença"),
    FORNEIRO("forneiro"),
    FRANGO_CAIPIRA("frango_caipira"),
    FRANGO_COM_CATUPIRY("frango_com_catupiry"),
    GRATINADA("gratinada"),
    JARDINEIRA("jardineira"),
    LIGHT("light"),
    LOMBO_COM_CATUPIRY_OU_MUSSARELA("lombo_com_catupiry_ou_mussarela"),
    MAFIOSA("mafiosa"),
    MARGUERITA("marguerita"),
    MARTINI("martini"),
    MILHO_VERDE("milho_verde"),
    MODA_DA_CASA("moda_da_casa"),
    MUSSARELA("mussarela"),
    NAPOLITANA("napolitana"),
    NOSTRA_PIZZA("nostra_pizza"),
    PALMITO("palmito"),
    PAULISTA("paulista"),
    PEITO_DE_PERU_COM_CATUPIRY("peito_de_peru_com_catupiry"),
    PEPERONI("peperoni"),
    PERUANA("peruana"),
    PHILADELPHIA("philadelphia"),
    PIZZAIOLO("pizzaiolo"),
    PLATAFORMA("plataforma"),
    PORTUGUESA("portuguesa"),
    PRIMADORA("primadora"),
    QUATRO_QUEIJOS("quatro_queijos"),
    ROMANA("romana"),
    RUCULA("rucula"),
    SABOR("sabor"),
    SALAME("salame"),
    SICILIANA("siciliana"),
    SIENA("siena"),
    SUPREMA("suprema"),
    TOSCANA("toscana"),
    TROPICAL("tropical"),
    VATICANO("vaticano"),
    VEGETARIANA("vegetariana")
    ;
    public String sabor;

    public String getSabor() {
        return sabor;
    }

    Sabor(String value) {
        this.sabor = value;
    }
}
