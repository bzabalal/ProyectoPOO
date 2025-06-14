function fetchComboBoxData() {
  fetch('http://localhost:9000/api/v1/funciones')
    .then(response => response.json())
    .then(data => {
      const funcionesLista = document.getElementById('funciones-lista');
      funcionesLista.innerHTML = '';

      if (Array.isArray(data)) {
        data.forEach(item => {
          if (item.horario && item.pelicula && item.pelicula.nombre) {
            const div = document.createElement('div');
            div.classList.add('funciones-lista');

            const h3 = document.createElement('h3');
            h3.textContent = `Horario: ${item.horario} - Película: ${item.pelicula.nombre}`;

            const pPrecio = document.createElement('p');
            pPrecio.textContent = 'Precio (fijo):';

            const inputPrecio = document.createElement('input');
            inputPrecio.type = 'text';
            inputPrecio.value = '5000';
            inputPrecio.readOnly = true;
            inputPrecio.placeholder = 'Precio';

            const inputAsiento = document.createElement('input');
            inputAsiento.type = 'text';
            inputAsiento.placeholder = 'Asiento';

            // Botón para guardar la entrada y asociarla con la función
            const button = document.createElement('button');
            button.textContent = 'Guardar';
            button.addEventListener('click', () => {
              const asiento = inputAsiento.value;

              fetch('http://localhost:9000/api/v1/entradas', {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                  precio: parseFloat(inputPrecio.value),
                  asiento: asiento,
                  funcion: {
                    id: item.id
                  }
                })
              })
                .then(response => {
                  if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                  }
                  return response.json();
                })
                .then(responseData => {
                  console.log('Entrada guardada:', responseData);
                })
                .catch(error => {
                  console.error('Error al guardar entrada:', error);
                });
            });

            div.appendChild(h3);
            div.appendChild(pPrecio);
            div.appendChild(inputPrecio);
            div.appendChild(inputAsiento);
            div.appendChild(button);

            funcionesLista.appendChild(div);
          }
        });
      }
    })
    .catch(error => {
      console.error('Error al obtener datos:', error);
    });
}

window.onload = fetchComboBoxData;
