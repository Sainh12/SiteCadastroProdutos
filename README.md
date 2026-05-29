# SiteCadastroProdutos
## Aqui está o projeto de Site para cadastro de Produtos



#create dbsite;
use DBSite;

create table produtos(
	id serial,
    nome VARCHAR(100) not null,
    marca VARCHAR(100) not null,
    categoria VARCHAR(100) not null,
    preco DECIMAL(10,2) not null,
    quantidade BIGINT not null,
    cor VARCHAR(50),
    peso DECIMAL(6,2),
    descricao text,
    dataCadastro date
);
select * from produtos;

Código usado para criar o banco que eu estou usando
