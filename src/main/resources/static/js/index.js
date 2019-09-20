const URL = 'https://pizza-helper.herokuapp.com';

function calcula() {
     var jsonRequest = getRequest();

    jQuery.support.cors = true;
    $.ajax({
        url:URL+'/calcula',
        type:'POST',
        contentType: "application/json",
        dataType: 'json',
        data: jsonRequest,
        success: function(json) {
            console.log(json);
            parseResponse(json.pizzas, json.incompleta);
        }
    });
}

function addSabores() {
    jQuery.support.cors = true;
    var sabor = $('#sabor').val();
    var quantidade = $('#quantidade').val();
    if(document.getElementById(sabor) == null){
        $('#list').append(
            '<tr id="'+sabor+'">' +
            '<td>' +
            '<div>'+sabor.replace(new RegExp("_", 'g'), " ")+'</div>' +

            '</td> ' +
            '<td>' +
            '<div id="'+sabor+'_qty" contenteditable="true">'+quantidade+'</div>' +
            '</td>' +
            '<td>' +
            '<button type="button" onclick="deleteRow(this)">Remover</button>' +
            '</td>' +
            '</tr>');
    } else {
        var id = '#'+sabor+'_qty';
        $(id)[0].innerHTML = parseInt($(id)[0].innerHTML) + parseInt(quantidade);
    }
}
function deleteRow(o) {
    var p = o.parentNode.parentNode;
    p.parentNode.removeChild(p);
}

function load(){
    jQuery.support.cors = true;
    $.ajax({
        url:URL+'/sabores',
        type:'GET',
        success: function( json ) {
            $.each(json, function(i, value) {
                $('#sabor').append($('<option>').text(value.toString().replace(new RegExp("_", 'g'), " ")).attr('value', value));
            });
        }
    });

}