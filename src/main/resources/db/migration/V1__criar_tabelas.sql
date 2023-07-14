CREATE SEQUENCE categoria_sequence START 1;
CREATE SEQUENCE produto_sequence START 1;

CREATE TABLE categoria (
	id bigint default NEXTVAL ('categoria_sequence') PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE produto (
id bigint default NEXTVAL ('produto_sequence') PRIMARY KEY,
categoria_id bigint NOT null,
nome VARCHAR(50) NOT NULL CHECK (nome <> ''),
valor FLOAT,
codigo_barras bigint, 
CONSTRAINT fk_categoria 
	FOREIGN KEY (categoria_id)
		REFERENCES categoria(id)
);




		