# Relatório

## Introdução
---
Este documento serve de suporte e detalha a análise efetuada e os aspetos
técnicos do refactoring de um projeto Java feito por alunos como solução da plataforma de troca de CFDs para a componente curricular de projeto da cadeira de arquiteturas de software.

Nesta entrega da 2º fase foi proposto um projeto anônimo a cada grupo de alunos para encontrarem code smells e efetuar refactoring no código de maneira a melhorar os projetos, com uma avaliação das métricas e impacto no programa. Elaboração do trabalho passou por três fases: a de identificação e exploração do projeto e catalogamento dos code smells, de aplicações de técnicas de refactoring, melhoramento e limpeza do código, e comparação de métricas e análise do impacto do melhoramento ao programa.

## Análise
---
O projeto recebido foi um projeto Java numa arquitetura MVC, com camada de serviços e camada de persistência. O projeto apresenta boa estrutura e aplicação de single responsability principle e abstração das classes e o seu funcionamento e relação. 
Algumas classes apresentam métodos vazios e incompletos como as classes responsáveis pela persistência dos dados da aplicação.

## Code Smells
---
Após uma análise ao código e às várias classes do projeto foram encontradas as seguintes categorias de code smells nas seguintes classes:

- Bloaters
    - AtivoCreator

- OO Abusers
    - AuthController
    - CFDController
    - Favorito
    - Mercado
    - Portfolio
    - APIConexao

- Dispensable
    - CFDController
    - FavoritoController
    - MercadoController
    - UtilizadorController
    - Ativo
    - CFD
    - Favorito
    - Mercado
    - CFDDAO
    - DBConexao
    - FavoritoDAO
    - UtilizadorDAO
    - APIConexao
    - AtivoCreator

- Couplers
    - FavoritoController
    - Ativo


## Refactoring
---

## Métricas e análise
---