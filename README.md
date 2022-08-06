# Projeto Imposto Contribuinte
Os dados são de pessoa física e pessoa jurídica:

### Modelagem de dados - Diagrama de Classes
![Modelo](src/main/resources/static/img/Modelo.png)

A regra aplicada de forma simplificada foi que:

Pessoa Física: pessoas com renda anual abaixo de R$ 20.000,00 pagam 15% de impostos e as acima deste valor pagam 25% de impostos. Os gastos com saúde são abatidos em 50%  no imposto total.

Exemplo: Se a renda foi R$ 100.000,00 e gastos com saúde R$ 2000,00 a regra aplicará: 

(100.000,00 * 25%) - (2000,00 * 50%) = R$ 24.000,00 em impostos.

Pessoa Jurídica: pagam 16% de impostos. Se possuir mais de 10 funcionários pagam 14% de impostos.

## BackEnd Java utilizando as tecnologias:
* Orientado à Objetos
* Spring Boot
* JPA - Hibernate
* PostGreeSQL
* HTML5
* CSS3

### FrontEnd (em produção) 
[Link da aplicação](https://imposto-contribuinte.herokuapp.com/) 