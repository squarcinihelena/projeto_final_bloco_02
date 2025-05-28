# Projeto Farmácia API - Backend com Spring Boot

---

## Descrição

---

O **Projeto Farmácia API** é uma **API RESTful** construída com **Spring Boot** que simula um sistema de gerenciamento para uma farmácia. Ele permite o **cadastro, consulta, atualização e exclusão** de produtos e categorias, e conta com um robusto sistema de **autenticação de usuários via JWT**.

Este projeto foi desenvolvido para a prática e aplicação de conceitos de APIs escaláveis e seguras, utilizando as tecnologias mais recentes do ecossistema Spring.

### Recursos em destaque:

* **Gestão completa de Produtos**: Inclui nome, preço, estoque, validade e associação a categorias.
* **Organização por Categorias**: Definição e gerenciamento de tipos de produtos (ex: Medicamentos, Higiene, Cosméticos).
* **Cadastro e Autenticação de Usuários**: Sistema de login seguro para controle de acesso às operações da API.
* **Flexibilidade**: Padrões de desenvolvimento que facilitam a integração com diversas aplicações frontend.

---

## Sobre esta API

---

A API da Farmácia foi desenvolvida em **Java** com o framework **Spring Boot**, seguindo os princípios da **Arquitetura RESTful** e a estrutura de camadas (Controller, Service, Repository). Ela oferece **endpoints bem definidos** para o gerenciamento de Usuários, Categorias e Produtos, garantindo uma interação fluida e segura.

### Principais funcionalidades da API:

* **Usuários**: Consulta, cadastro, login (geração de token JWT) e atualização de dados.
* **Categorias**: Consulta, criação, atualização e remoção de categorias para classificar os produtos.
* **Produtos**: Criação, edição, listagem, busca e remoção de produtos, com associação a categorias e validações específicas (preço, estoque, validade).
* **Segurança Avançada**: Autenticação e autorização via **token JWT** para proteger endpoints sensíveis.
* **Validações Robustas**: Utilização do **Jakarta Validation** para garantir a integridade dos dados de entrada.