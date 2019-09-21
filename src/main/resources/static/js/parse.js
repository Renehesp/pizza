var i = 0;
function getRequest() {
    var map = [];
    var table = $('#list')[0];
    for (var i = 1 ; i < table.rows.length; i++) {
        var obj ={};
        var sbr = table.rows[i].cells[0].querySelector('div').innerHTML;
        var qty = table.rows[i].cells[1].querySelector('div').innerHTML;
        obj["sabor"] = sbr;
        obj["quantidade"] = qty;
        map.push(obj);
    }
    var request = {};
    request["pedacos"] = map;
    return JSON.stringify(request);
}

function parseResponse(pizzas, incompleta){
    $('#pedido')[0].innerHTML = '';
    $('#pedido')
        .append('<h2>Pedido:</h2><br>')
        
    if(pizzas != null && pizzas.length > 0){
        $('#pedido').append('Pizzas Completas:<br>')
        .append('<ul id="resposta"> </ul>');
        var i = 1;
        for(pizza in pizzas){
            var json = pizzas[pizza].sabores;
            var map = new Map(Object.entries(json));
            $('#resposta').append('<h3>Pizza '+ i++ +':</h3>');
            map.forEach(adicionaPizza);
        }
    }

    if(incompleta !== null){
        $('#pedido').append('Pizza Incompleta:<br>')
        .append('<ul id="incompleta"> </ul>');
        var map2 = new Map(Object.entries(incompleta.sabores));
        map2.forEach(adicionaIncompleta);
    }

}

function adicionaPizza(valor, chave, mapa) {
    $('#resposta').append('<li><a>'+chave+': '+getFraction(valor)+'</a></li>');
}
function adicionaIncompleta(valor, chave, mapa) {
    $('#incompleta').append('<li><a>'+chave+': '+getFraction(valor)+'</a></li>');
}

function getFraction(qty){
    switch (qty) {
        case 3:
            return "Um ter&ccedil;o";
        case 4:
            return "Meia";
        case 6:
            return "Dois ter&ccedil;os";
        default:
            return "Inteira";
    }
}