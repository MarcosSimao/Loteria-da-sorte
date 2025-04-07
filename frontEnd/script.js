function chamarApi(tipo,cor) {
    let url = '';
    if (tipo === 'milionario') {
        url = 'http://localhost:8080/sorteio/milionario';
    } else if (tipo === 'quina') {
        url = 'http://localhost:8080/sorteio/quina';
    } else if (tipo === 'mega') {
        url = 'http://localhost:8080/sorteio/mega';
    }

    document.getElementById('overlay').style.display = 'flex';
    document.getElementById('numeros').innerHTML = '<p>Carregando...</p>';
    document.getElementById('trevos').innerHTML = '';

    fetch(url)
    .then(response => response.json())
    .then(data => {
        console.log(data.resultado)
        if (data.resultado && data.resultado.numeros && Array.isArray(data.resultado.numeros)) {
            document.getElementById('numeros').innerHTML = data.resultado.numeros
                .map(num => `<div class='numero' style='background: ${cor}'>${num}</div>`)
                .join('');
        } else {
            document.getElementById('numeros').innerHTML = '<p>Erro ao exibir números.</p>';
        }

        if (tipo === 'milionario' && data.resultado.trevos && Array.isArray(data.resultado.trevos)) {
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