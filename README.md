# MinIO Demo com Spring Boot

Este projeto é uma demonstração de como integrar o MinIO com um aplicativo Spring Boot para upload e recuperação de imagens. O MinIO é um servidor de armazenamento de objetos compatível com Amazon S3, e este projeto mostra como usar o MinIO para armazenar e recuperar arquivos de imagem.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.x
- MinIO Server 
- Docker (para rodar o MinIO localmente)

## Configuração do MinIO

1. **Configuração do MinIO**:
   - Acesse o console do MinIO em `http://localhost:9090`.
   - Crie um bucket chamado `images` (ou qualquer nome que você preferir).

## Executando o Projeto

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd seu-projeto

2. **Excute o docker compose**:
   
   ```
   docker-compose up
