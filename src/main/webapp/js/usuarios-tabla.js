
var urlLink = "http://localhost:8080/prueba/Usuarios.jsp" // Link para la conexión con el API rest

var userTable = $("#user_table").DataTable( {
    ajax: {
      type: "POST",
      url: urlLink + "list", //ruta de la API consultaremos.
      dataSrc: ''
    },
    columns: [
        { data: 'cedula_usuario' },
        { data: 'email_usuario' },
        { data: 'nombre_usuario' },
        { data: 'password_usuario' },
        { data: 'usuario' }
    ],
      language: {
        "decimal":        "",
        "emptyTable":     "No hay datos disponibles en la tabla",
        "info":           "Mostrando _START_ a _END_ de _TOTAL_ entradas",
        "infoEmpty":      "Mostrando 0 a 0 de 0 entradas",
        "infoFiltered":   "(filtrado de _MAX_ entradas totales)",
        "infoPostFix":    "",
        "thousands":      ",",
        "lengthMenu":     "Mostrar _MENU_ entradas",
        "loadingRecords": "Cargando...",
        "processing":     "Procesando...",
        "search":         "Buscar:",
        "zeroRecords":    "No se encontró ningun elemento",
        "paginate": {
            "first":      "Primera",
            "last":       "Última",
            "next":       "Siguiente",
            "previous":   "Anterior"
        },
        "aria": {
            "sortAscending":  ": activate to sort column ascending",
            "sortDescending": ": activate to sort column descending"
        }
  }
});
