function chamarApi(tipo, cor) {
    let url = 'http://localhost:8080/sorteio/' + tipo;

    document.getElementById('overlay').style.display = 'flex';
    document.getElementById('numeros').innerHTML = '<p>Carregando...</p>';
    document.getElementById('trevos').innerHTML = '';

    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data.resultado);
            let numerosHtml = '';

            if (tipo === 5 && data.resultado) {  // Tipo Dupla Sena
                numerosHtml += '<div style="margin-bottom: 10px;"><strong>1º Sorteio:</strong></div>';
                numerosHtml += '<div class="sorteio-container">';
                numerosHtml += data.resultado.primeiroSorteio.map(num => `<div class='numero' style='background: ${cor}'>${num}</div>`).join('');
                numerosHtml += '</div>';

                numerosHtml += '<div style="margin-top: 15px; margin-bottom: 10px;"><strong>2º Sorteio:</strong></div>';
                numerosHtml += '<div class="sorteio-container">';
                numerosHtml += data.resultado.segundoSorteio.map(num => `<div class='numero' style='background: ${cor}'>${num}</div>`).join('');
                numerosHtml += '</div>';

                document.getElementById('numeros').innerHTML = numerosHtml;
            } 
            else if (data.resultado && data.resultado.numeros && Array.isArray(data.resultado.numeros)) {
                document.getElementById('numeros').innerHTML = data.resultado.numeros
                    .map(num => `<div class='numero' style='background: ${cor}'>${num}</div>`)
                    .join('');
            } 
            else {
                document.getElementById('numeros').innerHTML = '<p>Erro ao exibir números.</p>';
            }

            if (tipo === 0 && data.resultado.trevos && Array.isArray(data.resultado.trevos)) {
                document.getElementById('trevos').innerHTML = data.resultado.trevos
                    .map(num => `<div class='trevo'>🍀 ${num}</div>`)
                    .join('');
            }
        })
        .catch(error => {
            document.getElementById('numeros').innerHTML = '<p>Erro ao buscar dados.</p>';
            console.error('Erro:', error);
        });
}

function fecharOverlay() {
    document.getElementById('overlay').style.display = 'none';
}