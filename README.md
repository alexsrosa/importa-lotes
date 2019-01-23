#### Olá, seja bem vindo ao **Projeto de importação de arquivos em lote**!

[![Build Status](https://travis-ci.com/alexsrosa/importa-lotes.svg?branch=master)](https://travis-ci.com/alexsrosa/importa-lotes)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=alexsrosa%3Aimporta-lotes&metric=alert_status)](https://sonarcloud.io/dashboard?id=alexsrosa%3Aimporta-lotes)

_Segue alguns passos para instalação e utilização:_

#### Instalação (Sem IDE):

##### 1 - Clone o projeto no github

##### 2 - Efetue o build, acessando a pasta criada pelo git:

Linux e Mac:

`./gradlew clean assemble`

Windows:

`gradlew clean assemble`

Este comando ira fazer o build e gerar os arquivos necessários para utilização da aplicação.

##### 3 - Com o arquivo `.jar` gerado, a aplicação pode ser executada.

_(Atenção, o computador deve possuir o Java 8 instalado)_

Rode o comando abaixo para verificar seu Java:

`
java -version
`

O resultado deve ser parecido com o apresentado abaixo:

```
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

Caso contrário, instale o Java antes de prosseguir para o próximo passo.

Com o Java OK, acesse `/build/libs`. Dentro desta pasta deve ter o arquivo `importa-lotes-0.0.1-SNAPSHOT.jar`. 
E rode o comando abaixo:

`cd build/libs`

E depois o comando: 

`java -jar importa-lotes-0.0.1-SNAPSHOT.jar`

Ou somente o comando:

`java -jar build/libs/importa-lotes-0.0.1-SNAPSHOT.jar`

##### 4 - Será exibido o seguinte texto na tela sinalizando o sucesso da operação:

``` 
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.2.RELEASE)
```

#### Instalação (Com IDE):

##### 1 - Clone o projeto no github

##### 2 - Importe o projeto na sua IDE de preferência

##### 3 - Aperte o botão "RUN" e avalie o código

##### 4 - Será exibido o seguinte texto na tela sinalizando o sucesso da operação:

``` 
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.2.RELEASE)
```

## Detalhes da implementação:

Este projeto efetua a leitura dos arquivos existentes na pasta "/data/in", 
esfetua o processamento e gera um relatório na pasta "/data/out".

## O parse do arquivo consiste em 3 tipos:

### Dados do vendedor
Os dados do vendedor têm o formato id ​ 001​ e a linha terá o seguinte formato.

```
001çCPFçNameçSalary
```

### Dados do cliente
Os dados do cliente têm o formato id ​ 002​ e a linha terá o seguinte formato.

```
002çCNPJçNameçBusiness Area
```

### Dados de vendas
Os dados de vendas têm o formato id ​ 003​ . Dentro da linha de vendas, existe a lista
de itens, que é envolto por colchetes []. A linha terá o seguinte formato.


```
003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
```

## Exemplo do arquivo:

O sistema é capaz de ler o exemplo abaixo:

```
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
```


## Análise de dados - Relatório

O sistema deve lê somente arquivos ".dat".
O nome do arquivo segue o padrão, {flat_file_name}.done.dat.

O conteúdo do arquivo de saída deve resumir os seguintes dados:
- Quantidade de clientes no arquivo de entrada
- Quantidade de vendedor no arquivo de entrada
- ID da venda mais cara
- O pior vendedor


