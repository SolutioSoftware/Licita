CREATE TABLE tbl_pregao(

	id BIGSERIAL PRIMARY KEY,
	numero_processo VARCHAR(20) NOT NULL,
	numero_pregao VARCHAR(20),
	descricao VARCHAR(255),
	status_pregao VARCHAR(10),
	sincronizado BOOLEAN
	
);


CREATE TABLE tbl_endereco(
	
	id BIGSERIAL PRIMARY KEY,
	logradouro VARCHAR(60),
	cidade VARCHAR(60),
	estado CHAR(2),
	cep CHAR(8),
	numero INTEGER,
	complemento VARCHAR(50)

);

CREATE TABLE tbl_pessoa_fisica(
	
	id BIGSERIAL PRIMARY KEY,
	id_endereco BIGINT,
	nome VARCHAR(80),
	cpf CHAR(11) UNIQUE NOT NULL,
	rg VARCHAR(30),
	CONSTRAINT fk_pessoa_fisica_endereco FOREIGN KEY(id_endereco) REFERENCES tbl_endereco(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_pessoa_juridica(
	
	id BIGSERIAL PRIMARY KEY,
	id_endereco BIGINT,
	razao_social VARCHAR(80),
	nome_fantasia VARCHAR(80),	
	cnpj CHAR(14) UNIQUE NOT NULL
	CONSTRAINT fk_pessoa_juridica_endereco FOREIGN KEY(id_endereco) REFERENCES tbl_endereco(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_contato_pessoa_juridica(
		id BIGSERIAL PRIMARY KEY,
		tipo_contato VARCHAR(10),
		valor VARCHAR(50) NOT NULL,
		id_pessoa_juridica BIGINT NOT NULL,
		CONSTRAINT fk_pessoa_juridica_contato FOREIGN KEY(id_pessoa_juridica) REFERENCES tbl_pessoa_juridica(id)
);

CREATE TABLE tbl_contato_pessoa_fisica(
		id BIGSERIAL PRIMARY KEY,
		tipo_contato VARCHAR(10),
		valor VARCHAR(50) NOT NULL,
		id_pessoa_fisica BIGINT NOT NULL,
		CONSTRAINT fk_pessoa_fisica_contato FOREIGN KEY(id_pessoa_fisica) REFERENCES tbl_pessoa_fisica(id)
);

CREATE TABLE tbl_pregoeiro(
	
	id BIGSERIAL UNIQUE,
	id_pessoa_fisica BIGINT UNIQUE NOT NULL,
	CONSTRAINT pk_pregoeiro PRIMARY KEY(id, id_pessoa_fisica),
	CONSTRAINT fk_pregoeiro_pessoa_fisica FOREIGN KEY(id_pessoa_fisica) REFERENCES tbl_pessoa_fisica(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_login(
	
	id BIGSERIAL PRIMARY KEY,
	id_pregoeiro BIGINT,
	usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(20) NOT NULL,
	logado BOOLEAN,
	CONSTRAINT fk_login_pregoeiro FOREIGN KEY(id_pregoeiro) REFERENCES tbl_pregoeiro(id)
	
	
);

CREATE TABLE tbl_membro_apoio(
	
	id BIGSERIAL UNIQUE,
	id_pessoa_fisica BIGINT UNIQUE NOT NULL,
	funcao VARCHAR(25),
	CONSTRAINT pk_membro_apoio PRIMARY KEY(id, id_pessoa_fisica),
	CONSTRAINT fk_membro_apoio_pessoa_fisica FOREIGN KEY(id_pessoa_fisica) REFERENCES tbl_pessoa_fisica(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_instituicao_licitadora(
	
	id BIGSERIAL UNIQUE,
	id_pessoa_juridica BIGINT UNIQUE NOT NULL,
	CONSTRAINT pk_instituicao_licitadora PRIMARY KEY(id, id_pessoa_juridica),
	CONSTRAINT fk_licitadora_pessoa_juridica FOREIGN KEY(id_pessoa_juridica) REFERENCES tbl_pessoa_juridica(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_empresa_licitante(

	id BIGSERIAL UNIQUE,
	id_pessoa_juridica BIGINT UNIQUE NOT NULL,
	inscricao_estadual VARCHAR(25),
	tipo_empresa VARCHAR(30) NOT NULL,
	complemento VARCHAR(150),
	CONSTRAINT pk_empresa_licitante PRIMARY KEY(id, id_pessoa_juridica),
	CONSTRAINT fk_licitante_pessoa_juridica FOREIGN KEY(id_pessoa_juridica) REFERENCES tbl_pessoa_juridica(id) ON DELETE CASCADE
	

);

CREATE TABLE tbl_conta_bancaria(
	
	id BIGSERIAL UNIQUE,
	id_licitante BIGINT UNIQUE NOT NULL,
	banco INTEGER,
	nome VARCHAR(50),
	agencia VARCHAR(10),
	numero_conta VARCHAR(15),
	operacao VARCHAR(6),
	CONSTRAINT pk_conta_bancaria PRIMARY KEY (id, id_licitante),
	CONSTRAINT fk_conta_licitante FOREIGN KEY(id_licitante) REFERENCES tbl_empresa_licitante(id) ON DELETE CASCADE
	
	
);


CREATE TABLE tbl_representante_legal(
	
	id BIGSERIAL UNIQUE,
	id_pessoa_fisica BIGINT UNIQUE NOT NULL,
	id_licitante BIGINT UNIQUE NOT NULL,
	CONSTRAINT pk_representante_legal PRIMARY KEY(id, id_pessoa_fisica, id_licitante),
	CONSTRAINT fk_representante_legal_pessoa_fisica FOREIGN KEY(id_pessoa_fisica) REFERENCES tbl_pessoa_fisica(id) ON DELETE CASCADE,
	CONSTRAINT fk_representante_legal_licitante FOREIGN KEY(id_licitante) REFERENCES tbl_empresa_licitante(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_sessao(
	
	id BIGSERIAL PRIMARY KEY,
	id_pregao BIGINT NOT NULL,
	id_pregoeiro BIGINT NOT NULL,
	horario_inicio TIMESTAMP,
	horario_encerramento TIMESTAMP,
	data_realizacao DATE,
	horario_previsto TIME,
	status_sessao VARCHAR(20),
	CONSTRAINT fk_sessao_pregao FOREIGN KEY(id_pregao) REFERENCES tbl_pregao(id) ON DELETE RESTRICT,
	CONSTRAINT fk_sessao_pregoeiro FOREIGN KEY(id_pregoeiro) REFERENCES tbl_pregoeiro(id) ON DELETE RESTRICT
	
);

CREATE TABLE tbl_item_pregao(
	
	id BIGSERIAL PRIMARY KEY,
	id_pregao BIGINT NOT NULL,
	numero_item INTEGER,
	quantidade INTEGER NOT NULL,
	valor_referencia NUMERIC NOT NULL,
	nome VARCHAR(30) NOT NULL,
	descricao VARCHAR(50),
	unidade VARCHAR(15),
	status_item VARCHAR(15),
	CONSTRAINT fk_item_pregao FOREIGN KEY(id_pregao) REFERENCES tbl_pregao(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_proposta(
	
	id BIGSERIAL PRIMARY KEY,
	id_licitante BIGINT NOT NULL,
	id_sessao BIGINT,
	id_item_pregao BIGINT NOT NULL,
	valor_unitario NUMERIC NOT NULL,
	classificada BOOLEAN,
	CONSTRAINT fk_proposta_licitante FOREIGN KEY(id_licitante) REFERENCES tbl_empresa_licitante(id) ON DELETE RESTRICT,
	CONSTRAINT fk_proposta_item_pregao FOREIGN KEY(id_item_pregao) REFERENCES tbl_item_pregao(id) ON DELETE RESTRICT,
	CONSTRAINT fk_proposta_sessao FOREIGN KEY(id_sessao) REFERENCES tbl_sessao(id) ON DELETE CASCADE
	
);

CREATE TABLE tbl_lance(
	
	id BIGSERIAL PRIMARY KEY,
	id_sessao BIGINT NOT NULL,
	id_licitante BIGINT NOT NULL,
	id_item_pregao BIGINT NOT NULL,
	horario_lance TIMESTAMP NOT NULL,
	valor NUMERIC NOT NULL,
	CONSTRAINT fk_lance_licitante FOREIGN KEY(id_licitante) REFERENCES tbl_empresa_licitante(id) ON DELETE RESTRICT,
	CONSTRAINT fk_lance_item_pregao FOREIGN KEY(id_item_pregao) REFERENCES tbl_item_pregao(id) ON DELETE RESTRICT,
	CONSTRAINT fk_lance_sessao FOREIGN KEY(id_sessao) REFERENCES tbl_sessao(id) ON DELETE CASCADE
);

CREATE TABLE tbl_status_sessao(
	
	id BIGSERIAL PRIMARY KEY,
	valor VARCHAR(20)
	
);

CREATE TABLE tbl_status_pregao(
	
	id BIGSERIAL PRIMARY KEY,
	valor VARCHAR(20)
	
);


CREATE TABLE tbl_status_item_pregao(
	
	id BIGSERIAL PRIMARY KEY,
	valor VARCHAR(20)
	
);

CREATE TABLE tbl_historico_status_pregao(

	id_pregao BIGINT NOT NULL,
	id_status BIGINT NOT NULL,
	CONSTRAINT fk_pregao_status FOREIGN KEY(id_pregao) REFERENCES tbl_pregao(id) ON DELETE CASCADE,
	CONSTRAINT fk_status_pregao FOREIGN KEY(id_status) REFERENCES tbl_status_pregao(id) ON DELETE CASCADE

);

CREATE TABLE tbl_historico_status_sessao(

	id_sessao BIGINT NOT NULL,
	id_status BIGINT NOT NULL,
	CONSTRAINT fk_sessao_status FOREIGN KEY(id_sessao) REFERENCES tbl_sessao(id) ON DELETE CASCADE,
	CONSTRAINT fk_status_sessao FOREIGN KEY(id_status) REFERENCES tbl_status_sessao(id) ON DELETE CASCADE

);

CREATE TABLE tbl_historico_status_item_pregao(

	id_item_pregao BIGINT NOT NULL,
	id_status BIGINT NOT NULL,
	CONSTRAINT fk_item_status FOREIGN KEY(id_item_pregao) REFERENCES tbl_item_pregao(id) ON DELETE CASCADE,
	CONSTRAINT fk_status_item FOREIGN KEY(id_status) REFERENCES tbl_status_item_pregao(id) ON DELETE CASCADE

);



