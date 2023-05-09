const express = require('express');
const fs = require('fs');

const app = express();
const port = 3000; //porta padrão

const bodyParser = require('body-parser');
app.use(bodyParser.json()); 

app.use(express.urlencoded({extended : true}));
app.use(express.json());

const router = express.Router();

//vvv rotas vvv
app.post('/', (req, res) => {
    const json = req.body; // obtém o JSON enviado no corpo da requisição
    console.log(json);
  
    // retorna uma resposta de sucesso
    res.status(200).send('JSON recebido com sucesso!');

    fs.writeFile('tarefas.json', JSON.stringify(json), 'utf-8', (err) => {
        if (err) throw err;
        console.log('The file has been saved!');
    });

});
  

app.listen(port);
console.log('API funcionando');
