create type cobertura as enum ('regional','nacional');

create table if not exists plano_de_saude(
	
	id_plano_saude serial primary key,
	nome_convenio varchar(60) not null unique,
	telefone int not null,
	cobertura cobertura not null
);

create table if not exists hospital(
	id_hospital serial primary key,
	cnpj char(14) not null unique,
	nome_hospital varchar(100) not null unique,
	telefone int not null,
	email varchar(200) not null,
	endereco varchar(200) not null
);

create table if not exists credenciamento(
	id_credenciamento serial primary key,
	id_hospital int not null,
	id_plano_saude int not null,
	data_credenciamento date default current_date not null,
	constraint fk_hospital foreign key (id_hospital) references hospital(id_hospital),
	constraint fk_plano_saude foreign key (id_plano_saude) references plano_de_saude(id_plano_saude)
);

create type tipo_ala as enum ('UTI','enfermaria','pediatria');

create table if not exists ala(
	id_ala serial primary key,
	id_hospital int null,
	leitos_disponiveis int not null check(leitos_disponiveis > 0),
	tipo_ala tipo_ala not null
);

create type turno_enfermeira as enum ('manha','tarde','noite');

create table if not exists enfermeira(
	id_enfermeira serial primary key,
	id_ala int not null,
	id_enfermeira_chefe int not null,
	cre char(20) not null unique,
	turno turno_enfermeira not null,
	nome_enfermeira varchar(150) not null,
	constraint fk_ala foreign key (id_ala) references ala(id_ala),
	constraint fk_enfermeira_chefe foreign key (id_enfermeira_chefe) references enfermeira(id_enfermeira) on delete set null 
);

create type status_leito as enum ('ocupado','livre','em_manutencao');

create table if not exists leito(
	id_leito serial primary key,
	id_ala int not null,
	status_leito status_leito not null default 'livre',
	constraint fk_ala foreign key (id_ala) references ala(id_ala)
);

create table if not exists paciente(
	id_paciente serial primary key,
	nome_paciente varchar(150) not null,
	documento char(14) not null,
	endereco varchar(200) not null,
	telefone int,
	data_nasciemento date not null
);

create table if not exists internacao(
	id_internacao serial primary key,
	id_paciente int not null,
	id_leito int not null,
	data_entrada timestamptz not null ,
	data_saida timestamptz,
	constraint chk_datas_internacao CHECK (data_saida IS NULL OR data_saida >= data_entrada),
	constraint fk_paciente foreign key (id_paciente) references paciente(id_paciente),
	constraint fk_leito foreign key (id_leito) references leito(id_leito)
);

create type forma_pagamento as enum ('pendente','em_analise','pago','cancelado');

create table if not exists fatura(
	id_fatura serial primary key,
	id_paciente int not null,
	valor_fatura decimal(10,2),
	data_emissao date,
	data_vencimento date,
	forma_pagamento varchar(60),
	status_pagamento forma_pagamento default 'pendente',
	constraint chk_datas_fatura check (data_vencimento >= data_emissao),
	constraint fk_paciente foreign key (id_paciente) references paciente(id_paciente)
);

create table if not exists nota_fiscal(
	id_nota_fiscal serial primary key,
	id_fatura int not null,
	valor_pis decimal(10,2),
	valor_cofins decimal(10,2),
	valor_iss decimal(10,2),
	valor_irpj decimal(10,2),
	valor_csll decimal(10,2),
	valor_total decimal(10,2),
	forma_pagamento varchar(60) not null,
	constraint fk_fatura foreign key (id_fatura) references fatura(id_fatura)
);

create table if not exists medico(
	id_medico serial primary key,
	nome_medico varchar(150) not null,
	crm char(20) not null unique,
	especialidade varchar(100) not null
);

create type status_atendimento as enum ('realizado', 'cancelado','revisao');
create type tipo_atendimento as enum ('consulta','emergencia','revisao');

create table if not exists atendimento(
	id_atendimento serial primary key,
	id_paciente int not null,
	id_medico int not null,
	data_hora timestamptz,
	tipo_atendimento tipo_atendimento not null,
	status_atendimento status_atendimento not null,
	observacoes_clinicas text,
	valor_atendimento decimal(10,2) not null,
	valor_internacao decimal(10,2) not null,
	constraint fk_paciente foreign key (id_paciente) references paciente(id_paciente),
	constraint fk_medico foreign key (id_medico) references medico(id_medico)
	);

create table if not exists medicamento(
	id_medicamento serial primary key,
	nome_medicamento varchar(60) not null,
	dosagem decimal(5,2),
	quantidade int
);

create table if not exists prescricao(
	id_prescricao serial primary key,
	id_atendimento int not null,
	id_medicamento int not null,
	observacao varchar(100),
	constraint fk_atendimento foreign key (id_atendimento) references atendimento(id_atendimento),
	constraint fk_medicamento foreign key (id_medicamento) references medicamento(id_medicamento)
);

create type tipo_exame as enum ('sangue','imagem','outros');
create type resultado as enum ('normal','alterado','critico');

create table if not exists exame(
	id_exame serial primary key,
	id_medico int not null,
	id_atendimento int not null,
	data_solicitacao date not null,
	tipo_exame tipo_exame not null,
	valor_exame decimal(10,2) not null,
	resultado resultado not null,
	data_resultado date,
	descricao text,
	constraint chk_datas_exame check (data_resultado IS NULL OR data_resultado >= data_solicitacao),
	constraint fk_medico foreign key (id_medico) references medico(id_medico),
	constraint fk_atendimento foreign key (id_atendimento) references atendimento(id_atendimento)
);

create type tipo_laboratorio  as enum ('interno','externo');

create table if not exists laboratorio(
	id_laboratorio serial primary key,
	id_exame int not null,
	nome_laboratorio varchar(100) not null,
	tipo_laboratorio tipo_laboratorio not null,
	constraint fk_exame foreign key (id_exame) references exame(id_exame)
);

create table if not exists laudo(
	id_laudo serial primary key,
	id_laboratorio int not null,
	arquivo_referencia text,
	constraint fk_laboratorio foreign key (id_laboratorio) references laboratorio(id_laboratorio)
);