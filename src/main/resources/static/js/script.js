function fetchComboBoxData() {
  fetch('http://localhost:9000/api/v1/funciones')
      .then(response => response.json())
      .then(data => {
        const funcionesLista = document.getElementById('funciones-lista');
        funcionesLista.innerHTML = ''; // Limpiar contenido previo

        if (Array.isArray(data)) {
          data.forEach(funcion => {
            if (funcion.horario && funcion.pelicula && funcion.pelicula.nombre) {
              const contenedorFuncion = document.createElement('div');
              contenedorFuncion.classList.add('funciones-lista');

              const tituloFuncion = document.createElement('h3');
              tituloFuncion.textContent = `Horario: ${funcion.horario} - Película: ${funcion.pelicula.nombre}`;

              const etiquetaPrecio = document.createElement('p');
              etiquetaPrecio.textContent = 'Precio (fijo):';

              const campoPrecio = document.createElement('input');
              campoPrecio.type = 'text';
              campoPrecio.value = '5000';
              campoPrecio.readOnly = true;
              campoPrecio.placeholder = 'Precio';

              const campoAsiento = document.createElement('input');
              campoAsiento.type = 'text';
              campoAsiento.placeholder = 'Asiento';

              const botonGuardar = document.createElement('button');
              botonGuardar.textContent = 'Guardar';

              botonGuardar.addEventListener('click', () => {
                const asientoIngresado = campoAsiento.value;

                fetch('http://localhost:9000/api/v1/entradas', {
                  method: 'POST',
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  body: JSON.stringify({
                    precio: parseFloat(campoPrecio.value),
                    asiento: asientoIngresado,
                    funcion: {
                      id: funcion.id
                    }
                  })
                })
                    .then(res => {
                      if (!res.ok) {
                        throw new Error(`Error HTTP: ${res.status}`);
                      }
                      return res.json();
                    })
                    .then(dataRespuesta => {
                      console.log('Entrada registrada con éxito:', dataRespuesta);
                    })
                    .catch(err => {
                      console.error('Fallo al guardar la entrada:', err);
                    });
              });

              contenedorFuncion.appendChild(tituloFuncion);
              contenedorFuncion.appendChild(etiquetaPrecio);
              contenedorFuncion.appendChild(campoPrecio);
              contenedorFuncion.appendChild(campoAsiento);
              contenedorFuncion.appendChild(botonGuardar);

              funcionesLista.appendChild(contenedorFuncion);
            }
          });
        }
      })
      .catch(err => {
        console.error('No se pudo recuperar la información de funciones:', err);
      });
}

window.onload = fetchComboBoxData;
