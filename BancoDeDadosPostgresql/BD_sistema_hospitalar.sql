-- ==============================================================================================
-- DML: POPULAÇÃO DA BASE DE DADOS - INSERÇÃO DE DADOS - PROJETO FINAL SISTEMA HOSPITALAR
-- Feito por: Leandro Coutinho, Almir Acacio, Kenji Okubo, Douglas Barboza, Bernado Caetano. 
-- Data: 04/2026 | Local: Petrópolis/RJ
-- ==============================================================================================

-- Comecei inserindo os Planos de Saúde e Hospitais primeiro porque 
-- eles não têm chave estrangeira (FK) apontando para ninguém.
-- Se eu tentar cadastrar o paciente antes do plano de saúde, o banco não deixa!		
-- 1. Inserindo 15 Planos de Saúde (Os IDs serão gerados de 1 a 15)
INSERT INTO plano_de_saude (nome_convenio, telefone, cobertura) VALUES 
('Unimed Petrópolis', 22221111, 'regional'),
('SulAmérica Premium', 40040000, 'nacional'),
('Bradesco Saúde', 40042700, 'nacional'),
('Amil Fácil Serrana', 30041000, 'regional'),
('GEAP Saúde', 20202020, 'nacional'),
('Cassi Banco do Brasil', 33333333, 'nacional'),
('Porto Seguro Saúde', 33334444, 'nacional'),
('MedSênior Premium', 30000000, 'nacional'),
('Golden Cross', 30001111, 'regional'),
('Assim Saúde', 22223333, 'regional'),
('Klin Saúde', 22445566, 'regional'),
('Prevent Senior', 33557799, 'nacional'),
('Hapvida', 40204020, 'nacional'),
('Notredame Intermédica', 40909090, 'nacional'),
('Allianz Saúde', 30031000, 'nacional');

-- 2. Inserindo 15 Hospitais (IDs de 1 a 15)
INSERT INTO hospital (cnpj, nome_hospital, telefone, email, endereco) VALUES 
('24248601000110', 'Hospital Santa Teresa', 22334455, 'contato@hst.com.br', 'Rua Paulino Afonso - Bingen'),
('28805819000133', 'Hospital Unimed Petrópolis', 22445566, 'atendimento@unimed.br', 'Rua D. Pedro I - Centro'),
('11222333000144', 'Hospital Clínico de Corrêas', 22556677, 'sac@hcc.com.br', 'Est. União e Indústria - Corrêas'),
('22333444000155', 'Hospital Alcides Carneiro', 22667788, 'diretoria@hac.gov.br', 'Rua Vigário Corrêa - Cascatinha'),
('33444555000166', 'SMH Beneficência Portuguesa', 22778899, 'contato@smh.com.br', 'Av. Portugal - Valparaíso'),
('44555666000177', 'UPA Cascatinha', 22889900, 'upa.cascatinha@sus.br', 'Rua Bernardo Proença - Cascatinha'),
('55666777000188', 'UPA Centro', 22990011, 'upa.centro@sus.br', 'Rua Washington Luiz - Centro'),
('66777888000199', 'UPA Itaipava', 22112233, 'upa.itaipava@sus.br', 'Est. União e Indústria - Itaipava'),
('77888999000100', 'Centro Médico Imperador', 22223344, 'contato@cmi.com.br', 'Rua do Imperador - Centro'),
('88999000000111', 'Hospital Municipal Earp', 22334466, 'hse@sus.gov.br', 'Rua Paulino Afonso - Centro'),
('99000111000122', 'Clínica São Judas', 22558899, 'contato@saojudas.com', 'Rua Teresa - Alto da Serra'),
('00111222000133', 'Hospital Nossa Sra. Aparecida', 22661122, 'diretoria@hnsa.com', 'Av. Barão do Rio Branco - Centro'),
('11222333000199', 'Clínica da Criança', 22330000, 'pediatria@clinicacrianca.com', 'Rua 16 de Março - Centro'),
('22333444000100', 'Hospital Psiquiátrico', 22441111, 'contato@hps.gov.br', 'Rua Bingen - Bingen'),
('33444555000122', 'Centro Traumatológico Especial', 22552222, 'trauma@cte.com.br', 'Est. Saudade - Saudade');

-- 3. Inserindo 15 Credenciamentos
-- Ligando o hospital (ID 1 a 15) ao plano de saúde (ID 1 a 15) manualmente.
INSERT INTO credenciamento (id_hospital, id_plano_saude, data_credenciamento) VALUES 
(1, 1, '2025-01-10'), (2, 2, '2025-01-15'), (3, 3, '2025-02-20'), 
(4, 4, '2025-03-05'), (5, 5, '2025-04-10'), (6, 6, '2025-05-12'), 
(7, 7, '2025-06-18'), (8, 8, '2025-07-22'), (9, 9, '2025-08-30'), 
(10, 10, '2025-09-10'), (11, 11, '2025-10-01'), (12, 12, '2025-10-15'),
(13, 13, '2025-11-05'), (14, 14, '2025-11-20'), (15, 15, '2025-12-01');

-- 4. Inserindo 15 Alas 
-- Coloquei quase todas as alas no Hospital 1 e 2 para facilitar depois.
INSERT INTO ala (id_hospital, leitos_disponiveis, tipo_ala) VALUES 
(1, 20, 'UTI'), (1, 15, 'pediatria'), (1, 30, 'enfermaria'), 
(2, 40, 'enfermaria'), (2, 10, 'UTI'), (2, 12, 'pediatria'), 
(3, 25, 'enfermaria'), (3, 15, 'UTI'), (4, 20, 'enfermaria'), 
(5, 8, 'UTI'), (6, 10, 'pediatria'), (7, 5, 'UTI'),
(8, 20, 'enfermaria'), (9, 15, 'pediatria'), (10, 30, 'enfermaria');

-- 5. Inserindo 15 Enfermeiras
-- Professor, a Enfermeira 1 é a Chefe Geral (id_enfermeira_chefe = NULL). 
-- As outras 14 respondem para ela (id_enfermeira_chefe = 1).
INSERT INTO enfermeira (id_ala, id_enfermeira_chefe, cre, turno, nome_enfermeira) VALUES 
(1, NULL, 'COREN-RJ 1010', 'manha', 'Marta Vieira (Chefe)'), 
(1, 1, 'COREN-RJ 1020', 'manha', 'Juliana Costa'),
(2, 1, 'COREN-RJ 1030', 'tarde', 'Patrícia Lima'),
(3, 1, 'COREN-RJ 1040', 'noite', 'Roberto Almeida'),
(4, 1, 'COREN-RJ 1050', 'manha', 'Letícia Soares'),
(5, 1, 'COREN-RJ 1060', 'tarde', 'Carlos Mendes'),
(6, 1, 'COREN-RJ 1070', 'noite', 'Bruna Tavares'),
(7, 1, 'COREN-RJ 1080', 'manha', 'Vanessa Silva'),
(8, 1, 'COREN-RJ 1090', 'tarde', 'Lucas Ferreira'),
(9, 1, 'COREN-RJ 1100', 'noite', 'Aline Gomes'),
(10, 1, 'COREN-RJ 1110', 'manha', 'Suelen Cardoso'),
(11, 1, 'COREN-RJ 1120', 'tarde', 'Rafael Nunes'),
(12, 1, 'COREN-RJ 1130', 'noite', 'Camila Moura'),
(13, 1, 'COREN-RJ 1140', 'manha', 'Bianca Castro'),
(14, 1, 'COREN-RJ 1150', 'tarde', 'Fernando Dias');

-- 6. Inserindo 15 Leitos
INSERT INTO leito (id_ala, status_leito) VALUES 
(1, 'ocupado'), (1, 'livre'), (1, 'em_manutencao'), 
(2, 'ocupado'), (2, 'livre'), (3, 'livre'), 
(4, 'ocupado'), (5, 'livre'), (6, 'livre'), 
(7, 'em_manutencao'), (8, 'ocupado'), (9, 'livre'),
(10, 'livre'), (11, 'ocupado'), (12, 'em_manutencao');

-- 7. Inserindo 15 Pacientes
INSERT INTO paciente (nome_paciente, documento, endereco, telefone, data_nascimento) VALUES 
('João Mota', '11122233344', 'Itaipava', 22221111, '1985-06-15'),
('Maria Silva', '22233344455', 'Bingen', 22222222, '1992-11-20'),
('Carlos Nogueira', '33344455566', 'Quitandinha', 22223333, '1970-03-08'),
('Fernanda Lima', '44455566677', 'Centro', 22224444, '2001-09-30'),
('Thiago Gomes', '55566677788', 'Retiro', 22225555, '1995-12-10'),
('Luciana Carvalho', '66677788899', 'Correas', 22226666, '1965-07-22'),
('Roberto Machado', '77788899900', 'Valparaíso', 22227777, '1980-01-05'),
('Alice Ferreira', '88899900011', 'Cascatinha', 22228888, '2010-05-12'),
('Bruno Alves', '99900011122', 'Araras', 22229999, '1988-08-18'),
('Carla Mendes', '00011122233', 'Mosela', 22220000, '1999-12-25'),
('Vitor Hugo', '12312312344', 'Nogueira', 22331111, '2005-02-14'),
('Mariana Rios', '32132132155', 'Pedro do Rio', 22442222, '1990-07-07'),
('Paulo Souza', '45645645666', 'Alto da Serra', 22553333, '1982-10-10'),
('Beatriz Neves', '78978978977', 'Morin', 22664444, '1998-04-18'),
('Eduardo Costa', '98798798788', 'Secretário', 22775555, '1975-12-01');

-- 8. Inserindo 15 Internações (A saída é obrigatoriamente maior que a entrada)
INSERT INTO internacao (id_paciente, id_leito, data_entrada, data_saida) VALUES 
(1, 1, '2026-04-01 08:00:00-03', '2026-04-05 10:00:00-03'),
(2, 2, '2026-04-02 09:30:00-03', '2026-04-04 14:00:00-03'),
(3, 3, '2026-04-03 11:00:00-03', '2026-04-10 09:00:00-03'),
(4, 4, '2026-04-04 15:20:00-03', '2026-04-08 11:30:00-03'),
(5, 5, '2026-04-05 18:45:00-03', '2026-04-07 10:00:00-03'),
(6, 6, '2026-04-06 20:00:00-03', '2026-04-12 08:00:00-03'),
(7, 7, '2026-04-07 07:30:00-03', '2026-04-09 15:00:00-03'),
(8, 8, '2026-04-08 14:00:00-03', NULL), -- Esse paciente ainda está no hospital!
(9, 9, '2026-04-09 10:15:00-03', '2026-04-15 12:00:00-03'),
(10, 10, '2026-04-10 22:30:00-03', NULL),
(11, 11, '2026-04-11 09:00:00-03', '2026-04-13 14:00:00-03'),
(12, 12, '2026-04-12 11:30:00-03', '2026-04-16 10:00:00-03'),
(13, 13, '2026-04-13 15:00:00-03', '2026-04-17 18:00:00-03'),
(14, 14, '2026-04-14 07:00:00-03', NULL),
(15, 15, '2026-04-15 20:00:00-03', '2026-04-20 09:00:00-03');

-- 9. Inserindo 15 Faturas (O vencimento é maior que a emissão)
INSERT INTO fatura (id_paciente, valor_fatura, data_emissao, data_vencimento, forma_pagamento, status_pagamento) VALUES 
(1, 850.00, '2026-04-10', '2026-04-20', 'Cartão', 'pendente'),
(2, 1500.00, '2026-04-11', '2026-04-21', 'PIX', 'pago'),
(3, 650.00, '2026-04-12', '2026-04-22', 'Boleto', 'pago'),
(4, 300.00, '2026-04-13', '2026-04-23', 'Convênio', 'pendente'),
(5, 50.00, '2026-04-14', '2026-04-24', 'N/A', 'cancelado'),
(6, 750.00, '2026-04-15', '2026-04-25', 'Convênio', 'em_analise'),
(7, 1200.00, '2026-04-16', '2026-04-26', 'Cartão', 'pendente'),
(8, 400.00, '2026-04-17', '2026-04-27', 'PIX', 'pago'),
(9, 450.00, '2026-04-18', '2026-04-28', 'Boleto', 'pendente'),
(10, 500.00, '2026-04-19', '2026-04-29', 'Convênio', 'pendente'),
(11, 250.00, '2026-04-20', '2026-04-30', 'PIX', 'pago'),
(12, 800.00, '2026-04-21', '2026-05-01', 'Cartão', 'pendente'),
(13, 90.00, '2026-04-22', '2026-05-02', 'Dinheiro', 'pago'),
(14, 2100.00, '2026-04-23', '2026-05-03', 'Convênio', 'em_analise'),
(15, 600.00, '2026-04-24', '2026-05-04', 'Boleto', 'pendente');

-- 10. Inserindo 15 Médicos
INSERT INTO medico (nome_medico, crm, especialidade) VALUES 
('Dr. Henrique Viana', 'CRM-RJ 45892', 'Cardiologia'),
('Dra. Amanda Souza', 'CRM-RJ 61234', 'Neurologia'),
('Dr. Rodrigo Albuquerque', 'CRM-RJ 33451', 'Ortopedia'),
('Dra. Beatriz Santos', 'CRM-RJ 78901', 'Pediatria'),
('Dr. Felipe Moraes', 'CRM-RJ 54321', 'Cirurgia Geral'),
('Dra. Camila Barros', 'CRM-RJ 12345', 'Dermatologia'),
('Dr. Marcos Silva', 'CRM-RJ 67890', 'Gastroenterologia'),
('Dra. Paula Fernandes', 'CRM-RJ 98765', 'Ginecologia'),
('Dr. Leandro Costa', 'CRM-RJ 54322', 'Psiquiatria'),
('Dra. Juliana Rocha', 'CRM-RJ 11223', 'Endocrinologia'),
('Dr. Thiago Pereira', 'CRM-RJ 22334', 'Urologia'),
('Dra. Sofia Mendes', 'CRM-RJ 55667', 'Oftalmologia'),
('Dr. Arthur Lima', 'CRM-RJ 88990', 'Otorrinolaringologia'),
('Dra. Laura Farias', 'CRM-RJ 11002', 'Oncologia'),
('Dr. Diego Martins', 'CRM-RJ 33445', 'Infectologia');

-- 11. Inserindo 15 Atendimentos
-- Relacionando o Paciente (1 a 15) com o Médico (1 a 15)
INSERT INTO atendimento (id_paciente, id_medico, data_hora, tipo_atendimento, status_atendimento, observacoes_clinicas, valor_atendimento, valor_internacao) VALUES 
(1, 1, '2026-04-10 09:00:00-03', 'consulta', 'realizado', 'Pressão alta.', 350.00, 500.00),
(2, 2, '2026-04-11 10:30:00-03', 'consulta', 'realizado', 'Enxaqueca.', 350.00, 0.00),
(3, 3, '2026-04-12 14:00:00-03', 'emergencia', 'realizado', 'Torsão no tornozelo.', 650.00, 0.00),
(4, 4, '2026-04-13 15:15:00-03', 'revisao', 'realizado', 'Retorno pediátrico.', 150.00, 0.00),
(5, 5, '2026-04-14 08:45:00-03', 'consulta', 'cancelado', 'Não compareceu.', 0.00, 0.00),
(6, 6, '2026-04-15 11:20:00-03', 'consulta', 'cancelado', 'Alergia na pele.', 350.00, 0.00),
(7, 7, '2026-04-16 13:00:00-03', 'emergencia', 'realizado', 'Dores de estômago.', 700.00, 500.00),
(8, 8, '2026-04-17 16:30:00-03', 'consulta', 'realizado', 'Rotina ginecológica.', 400.00, 0.00),
(9, 9, '2026-04-18 09:00:00-03', 'consulta', 'cancelado', 'Ansiedade.', 450.00, 0.00),
(10, 10, '2026-04-19 10:00:00-03', 'consulta', 'realizado', 'Diabetes.', 350.00, 150.00),
(11, 11, '2026-04-20 11:00:00-03', 'revisao', 'realizado', 'Pós operatório.', 200.00, 0.00),
(12, 12, '2026-04-21 14:30:00-03', 'consulta', 'realizado', 'Exame de vista.', 300.00, 0.00),
(13, 13, '2026-04-22 08:00:00-03', 'emergencia', 'realizado', 'Dor de ouvido intensa.', 500.00, 0.00),
(14, 14, '2026-04-23 09:15:00-03', 'consulta', 'realizado', 'Acompanhamento oncológico.', 450.00, 0.00),
(15, 15, '2026-04-24 16:00:00-03', 'consulta', 'realizado', 'Suspeita de dengue.', 300.00, 0.00);

-- 12. Inserindo 15 Medicamentos
INSERT INTO medicamento (nome_medicamento, dosagem, quantidade) VALUES 
('Dipirona', 500.00, 100), ('Paracetamol', 750.00, 150), ('Ibuprofeno', 400.00, 80), 
('Amoxicilina', 500.00, 50), ('Omeprazol', 20.00, 200), ('Losartana', 50.00, 120), 
('Rivotril', 2.00, 40), ('Rocefin', 1.00, 30), ('Plasil', 10.00, 90), 
('Dramin', 50.00, 60), ('Aspirina', 100.00, 100), ('Loratadina', 10.00, 50),
('Azitromicina', 500.00, 40), ('Sertralina', 50.00, 80), ('Clonazepam', 2.00, 60);

-- 13. Inserindo 15 Prescrições (Vou usar o ID do atendimento e o ID do remédio)
INSERT INTO prescricao (id_atendimento, id_medicamento, observacao) VALUES 
(1, 6, '1 ao dia'), (2, 1, 'Se estiver com dor'), (3, 3, 'De 8 em 8h'), 
(4, 2, 'Gotas'), (7, 5, 'Jejum'), (8, 4, '12 em 12h'), 
(10, 6, 'Manter uso'), (11, 1, 'Para dor'), (12, 12, '1 comprimido à noite'), 
(13, 13, 'Durante 5 dias'), (14, 14, 'Uso contínuo'), (15, 1, 'Se febre'),
(1, 1, 'Em SOS'), (2, 7, 'Antes de dormir'), (3, 11, 'Para dor forte');

-- 14. Inserindo 15 Exames 
INSERT INTO exame (id_medico, id_atendimento, data_solicitacao, tipo_exame, valor_exame, resultado, data_resultado, descricao) VALUES 
(1, 1, '2026-04-10', 'imagem', 350.00, 'normal', '2026-04-11', 'Eletrocardiograma'),
(2, 2, '2026-04-11', 'imagem', 1200.00, 'alterado', '2026-04-12', 'Ressonância'),
(3, 3, '2026-04-12', 'imagem', 150.00, 'alterado', '2026-04-12', 'Raio-X'),
(4, 4, '2026-04-13', 'sangue', 80.00, 'normal', '2026-04-14', 'Hemograma'),
(5, 5, '2026-04-14', 'sangue', 40.00, 'normal', '2026-04-15', 'Glicemia'),
(6, 6, '2026-04-15', 'outros', 450.00, 'alterado', '2026-04-20', 'Biópsia'),
(7, 7, '2026-04-16', 'outros', 800.00, 'alterado', '2026-04-17', 'Endoscopia'),
(8, 8, '2026-04-17', 'sangue', 60.00, 'normal', '2026-04-18', 'Colesterol'),
(9, 9, '2026-04-18', 'sangue', 120.00, 'normal', '2026-04-19', 'Cortisol'),
(10, 10, '2026-04-19', 'sangue', 90.00, 'critico', '2026-04-20', 'Hemoglobina Glicada'),
(11, 11, '2026-04-20', 'sangue', 70.00, 'normal', '2026-04-21', 'PSA'),
(12, 12, '2026-04-21', 'imagem', 200.00, 'normal', '2026-04-21', 'Mapeamento de Retina'),
(13, 13, '2026-04-22', 'outros', 180.00, 'alterado', '2026-04-22', 'Audiometria'),
(14, 14, '2026-04-23', 'imagem', 900.00, 'critico', '2026-04-25', 'Tomografia'),
(15, 15, '2026-04-24', 'sangue', 100.00, 'alterado', '2026-04-25', 'Sorologia Dengue');

-- 15. Inserindo 15 Laboratórios
INSERT INTO laboratorio (id_exame, nome_laboratorio, tipo_laboratorio) VALUES 
(1, 'Lab Santa Teresa', 'interno'), (2, 'Sérgio Franco Bingen', 'externo'), 
(3, 'Lab Santa Teresa', 'interno'), (4, 'Lab Unimed', 'interno'), 
(5, 'Bronstein Centro', 'externo'), (6, 'Lamin Itaipava', 'externo'), 
(7, 'Pacheco Análises', 'externo'), (8, 'LNCC', 'externo'), 
(9, 'Hemocentro Petrópolis', 'externo'), (10, 'Clínica de Imagem 3D', 'externo'),
(11, 'Lab Corrêas', 'interno'), (12, 'OftalmoCenter Lab', 'externo'),
(13, 'AudioClínica', 'externo'), (14, 'OncoLab', 'interno'),
(15, 'Lab Municipal', 'externo');

-- 16. Inserindo 15 Laudos
INSERT INTO laudo (id_laboratorio, arquivo_referencia) VALUES 
(1, '/laudos/2026/ecg_01.pdf'), (2, '/laudos/2026/rm_02.pdf'), 
(3, '/laudos/2026/rx_03.pdf'), (4, '/laudos/2026/hemo_04.pdf'), 
(5, '/laudos/2026/glic_05.pdf'), (6, '/laudos/2026/biop_06.pdf'), 
(7, '/laudos/2026/endo_07.pdf'), (8, '/laudos/2026/col_08.pdf'), 
(9, '/laudos/2026/cort_09.pdf'), (10, '/laudos/2026/hemo_10.pdf'),
(11, '/laudos/2026/psa_11.pdf'), (12, '/laudos/2026/ret_12.pdf'),
(13, '/laudos/2026/audio_13.pdf'), (14, '/laudos/2026/tomo_14.pdf'),
(15, '/laudos/2026/deng_15.pdf');

-- Como foi pedido nos requisitos:
-- "A única tabela que não será populada é a de nota_fiscal".
-- Então ela continua vazia para o Java preencher!