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
    var id = sabor.replace(new RegExp(" ", 'g'), "_")+'_qty';
    var quantidade = $('#quantidade').val();
    if(document.getElementById(sabor) == null){
        $('#list').append(
            '<tr id="'+sabor+'">' +
            '<td>' +
            '<div>'+sabor+'</div>' +

            '</td> ' +
            '<td>' +
            '<div id="'+id+'" contenteditable="true">'+quantidade+'</div>' +
            '</td>' +
            '<td>' +
            '<button type="button" onclick="deleteRow(this)">Remover</button>' +
            '</td>' +
            '</tr>');
    } else {
        var value = parseInt($("'#"+id+"'")[0].innerHTML) + parseInt(quantidade);
        if(value>100) value = 100;
        $(id)[0].innerHTML = value;
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
                $('#sabor').append($('<option>').text(value).attr('value', value.toString().replace(new RegExp(" ", 'g'), "_")));
            });
        }
    });
    var $select = $("#quantidade");
    for (i=1;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
}