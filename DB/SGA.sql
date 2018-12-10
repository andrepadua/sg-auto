DROP DATABASE SGA;
CREATE SCHEMA IF NOT EXISTS SGA DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS SGA.ACESSORIO 
(
  SEQ_ACESSORIO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_ACESSORIO VARCHAR(50) NOT NULL COMMENT 'Nome do Acessório' 
, VAL_ACESSORIO DECIMAL(14, 2) NOT NULL COMMENT 'Valor do veículo'
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, SEQ_MOTORIZACAO INT(11) NOT NULL COMMENT 'Relacionamento com a tabela MOTORIZACAO'
, SEQ_FORNECEDOR INT(11) NOT NULL COMMENT 'Relacionamento com a tabela Fornecedor'
, PRIMARY KEY (SEQ_ACESSORIO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.ACESSORIOVEICULO 
(
  SEQ_ACESSORIOVEICULO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, SEQ_ACESSORIO INT(11) NOT NULL COMMENT 'Relacionamento com ACESSORIO' 
, SEQ_VEICULO INT(11) NOT NULL COMMENT 'Relacionamento com VEICULO' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, PRIMARY KEY (SEQ_ACESSORIOVEICULO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.CONCESSIONARIA 
(
  SEQ_CONCESSIONARIA INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_CONCESSIONARIA VARCHAR(100) COMMENT 'Nome da Concessionária'
, NUM_CNPJ VARCHAR(30) COMMENT 'Número do CNPJ'
, DSC_RAZAO_SOCIAL VARCHAR(50) COMMENT 'Descrição da Razão Social'
, END_CONCESSIONARIA VARCHAR(100) COMMENT 'Endereço da Concessionária'
, NOM_CONTATO VARCHAR(60) COMMENT 'Nome do Contato'
, NUM_TELEFONE_CONTATO VARCHAR(30) COMMENT 'Número de Telefone do Contato'
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp'
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp'
, PRIMARY KEY (SEQ_CONCESSIONARIA))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.FORNECEDOR 
(
  SEQ_FORNECEDOR INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_FORNECEDOR VARCHAR(100) COMMENT 'Nome do Fornecedor' 
, NOM_FANTASIA VARCHAR(100) COMMENT 'Nome Fantasia' 
, NUM_CNPJ VARCHAR(30) COMMENT 'Número do CNPJ' 
, DSC_RAZAO_SOCIAL VARCHAR(50) COMMENT 'Descrição da Razão Social' 
, END_FORNECEDOR VARCHAR(100) COMMENT 'Endereço do Fornecedor' 
, NOM_CONTATO VARCHAR(60) COMMENT 'Nome do Contato' 
, NUM_TELEFONE_CONTATO VARCHAR(30) COMMENT 'Telefone de Contato' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, PRIMARY KEY (SEQ_FORNECEDOR))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.MOTORIZACAO 
(
  SEQ_MOTORIZACAO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, DSC_MOTORIZACAO VARCHAR(50) NOT NULL COMMENT 'Descrição Padrão da Motorização'
, NUM_POTENCIA INT(11) NOT NULL COMMENT 'Quantidade de Potência (EM HP)' 
, NUM_VELOCIDADE_FINAL DECIMAL(14, 2) NOT NULL COMMENT 'Valor da Velocidade Final (EM KM/H)' 
, NUM_AUTONOMIA DECIMAL(14, 2) NOT NULL COMMENT 'Consumo em litros por tipo de combustível' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, SEQ_TIPOMOTORIZACAO INT(11) NOT NULL COMMENT 'Relacionamento com a tabela TIPOMOTORIZACAO'
, PRIMARY KEY (SEQ_MOTORIZACAO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.PECA 
(
  SEQ_PECA INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_PECA VARCHAR(50) COMMENT 'Nome da Peça' 
, SEQ_FORNECEDOR INT(11) NOT NULL COMMENT 'Relacionamento com a tabela Fornecedor'
, FLG_PROD_MONT TINYINT DEFAULT 0 NOT NULL COMMENT 'Flag de Produzido pela montadora' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimStamp' 
, PRIMARY KEY (SEQ_PECA))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.PECAVEICULO 
(
  SEQ_PECAVEICULO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, SEQ_PECA INT(11) NOT NULL COMMENT 'Relacionamento com a tabela PECA'
, SEQ_VEICULO INT(11) NOT NULL COMMENT 'Relacionamento com a tabela VEICULO'
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, PRIMARY KEY (SEQ_PECAVEICULO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.TIPOMOTORIZACAO 
(
  SEQ_TIPOMOTORIZACAO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, DESC_TIPOMOTORIZACAO VARCHAR(50) COMMENT 'Descrição do Tipo de Motorização...' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimStamp' 
, PRIMARY KEY (SEQ_TIPOMOTORIZACAO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.TIPOVEICULO 
(
  SEQ_TIPOVEICULO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_TIPOVEICULO VARCHAR(50) COMMENT 'Nome do Veículo' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimStamp' 
, PRIMARY KEY (SEQ_TIPOVEICULO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.VEICULO 
(
  SEQ_VEICULO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_VEICULO VARCHAR(50) NOT NULL COMMENT 'Nome do Veículo' 
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, SEQ_TIPOVEICULO INT(11) NOT NULL COMMENT 'Relacionamento com a Tabela SGA.TIPOVEICULO'
, SEQ_CONCESSIONARIA INT(11) NOT NULL COMMENT 'Relacionamento com a Tabela SGA.CONCESSIONARIA'
, PRIMARY KEY (SEQ_VEICULO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.PERFIL 
(
  SEQ_PERFIL INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_PERFIL VARCHAR(50) NOT NULL COMMENT 'Nome do Perfil'
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, PRIMARY KEY (SEQ_PERFIL))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS SGA.USUARIO 
(
  SEQ_USUARIO INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária da Tabela' 
, NOM_USUARIO VARCHAR(100) NOT NULL COMMENT 'Nome do Usuário'
, LOGINNAME VARCHAR(30) NOT NULL COMMENT 'LOGINNAME do Usuário'
, USUARIO VARCHAR(30) COMMENT 'Usuário de TimeStamp' 
, DAT_USUARIO DATETIME COMMENT 'Data de TimeStamp' 
, SEQ_PERFIL INT(11) NOT NULL COMMENT 'Relacionamento com a Tabela Perfil'
, PRIMARY KEY (SEQ_USUARIO))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE SGA.ACESSORIOVEICULO ADD CONSTRAINT ACESSORIOVEICULO_UK_001 UNIQUE (SEQ_ACESSORIO, SEQ_VEICULO);
ALTER TABLE SGA.PECAVEICULO ADD CONSTRAINT PECAVEICULO_UK_001 UNIQUE (SEQ_PECA, SEQ_VEICULO);

ALTER TABLE SGA.ACESSORIO ADD CONSTRAINT ACESSORIO_FORNECEDOR_FK FOREIGN KEY (SEQ_FORNECEDOR) REFERENCES SGA.FORNECEDOR (SEQ_FORNECEDOR);
ALTER TABLE SGA.ACESSORIO ADD CONSTRAINT ACESSORIO_MOTORIZACAO_FK FOREIGN KEY (SEQ_MOTORIZACAO) REFERENCES SGA.MOTORIZACAO (SEQ_MOTORIZACAO);
ALTER TABLE SGA.ACESSORIOVEICULO ADD CONSTRAINT ACESSORIOVEICULO_ACESSORIO_FK FOREIGN KEY (SEQ_ACESSORIO) REFERENCES SGA.ACESSORIO (SEQ_ACESSORIO);
ALTER TABLE SGA.ACESSORIOVEICULO ADD CONSTRAINT ACESSORIOVEICULO_VEICULO_FK FOREIGN KEY (SEQ_VEICULO) REFERENCES SGA.VEICULO (SEQ_VEICULO);
ALTER TABLE SGA.MOTORIZACAO ADD CONSTRAINT MOTORIZACAO_TIPOMOTORIZACAO_FK FOREIGN KEY (SEQ_TIPOMOTORIZACAO) REFERENCES SGA.TIPOMOTORIZACAO (SEQ_TIPOMOTORIZACAO);
ALTER TABLE SGA.PECA ADD CONSTRAINT PECA_FORNECEDOR_FK FOREIGN KEY (SEQ_FORNECEDOR) REFERENCES SGA.FORNECEDOR (SEQ_FORNECEDOR);
ALTER TABLE SGA.PECAVEICULO ADD CONSTRAINT PECAVEICULO_PECA_FK FOREIGN KEY (SEQ_PECA) REFERENCES SGA.PECA (SEQ_PECA);
ALTER TABLE SGA.PECAVEICULO ADD CONSTRAINT PECAVEICULO_VEICULO_FK FOREIGN KEY (SEQ_VEICULO) REFERENCES SGA.VEICULO (SEQ_VEICULO);
ALTER TABLE SGA.VEICULO ADD CONSTRAINT VEICULO_CONCESSIONARIA_FK FOREIGN KEY (SEQ_CONCESSIONARIA) REFERENCES SGA.CONCESSIONARIA (SEQ_CONCESSIONARIA);
ALTER TABLE SGA.VEICULO ADD CONSTRAINT VEICULO_TIPOVEICULO_FK FOREIGN KEY (SEQ_TIPOVEICULO) REFERENCES SGA.TIPOVEICULO (SEQ_TIPOVEICULO);
ALTER TABLE SGA.USUARIO ADD CONSTRAINT USUARIO_PERFIL_FK FOREIGN KEY (SEQ_PERFIL) REFERENCES PERFIL (SEQ_PERFIL) ;

ALTER TABLE SGA.ACESSORIO COMMENT 'Para cada modelo, há diversos tipos de configurações possíveis e exclusivas para cada modelo, sendo cada configuração é formada por vários tipos de acessórios e motorização. ';
ALTER TABLE SGA.ACESSORIOVEICULO COMMENT 'Cada tipo de acessório e caracterizado por um código, nome e custo, e diferenciado para cada modelo de carro.';
ALTER TABLE SGA.CONCESSIONARIA COMMENT 'A fabrica só vendem seus veículos para a rede de concessionárias associada à marca, não vendendo diretamente para o usuário final, por isso é necessário saber, a Razão social, CNPJ, endereços, telefones, e os nomes de contato das diversas redes de concessionárias.';
ALTER TABLE SGA.FORNECEDOR COMMENT 'Os fabricantes de peças só produzem peças e os de acessórios só produzem acessórios. As informações relevantes de fornecedores são: Razão social, CNPJ, endereço, telefones e nome de contato.';
ALTER TABLE SGA.MOTORIZACAO COMMENT 'As informações relevantes para a motorização são:  Potencia em HP, velocidade final, autonomia (consumo em litros por tipo de combustível).';
ALTER TABLE SGA.PECA COMMENT 'Muitas das peças que compõem os carros são produzidas por uma rede de fabricantes de peças sendo que para cada tipo de peça pode ser fornecida por mais de um fornecedor.';
ALTER TABLE SGA.PECAVEICULO COMMENT 'Muitas das peças que compõem os carros são produzidas por uma rede de fabricantes de peças sendo que para cada tipo de peça pode ser fornecida por mais de um fornecedor.';
ALTER TABLE SGA.VEICULO COMMENT 'A ACME montadora de carros produz vários modelos de carros de passeio e de transporte leve.';
ALTER TABLE SGA.PERFIL COMMENT 'Tabela de Perfil';
ALTER TABLE SGA.USUARIO COMMENT 'Tabela de Usuários';

insert into sga.perfil (nom_perfil) values ('Administrador');
insert into sga.usuario (nom_usuario, loginname, seq_perfil) values ('admin', 'admin', 1);

-- Script para a tabela: sga.ACESSORIO



#------------------------------------------------ sga.ACESSORIO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.ACESSORIO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_acessorio(in    p_nom_acessorio  VARCHAR(50),
                                        in    p_val_acessorio  DECIMAL(14, 2),
                                        in    p_seq_motorizacao INT(11),
                                        in    p_seq_fornecedor INT(11),
                                        inout p_seq_acessorio  INT(11))

  begin

    insert into sga.acessorio
      (NOM_ACESSORIO, VAL_ACESSORIO, SEQ_MOTORIZACAO, SEQ_FORNECEDOR)
    values 
      (p_NOM_ACESSORIO, p_VAL_ACESSORIO, p_SEQ_MOTORIZACAO, p_SEQ_FORNECEDOR);
    SET p_seq_acessorio = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_acessorio(in    p_nom_acessorio  VARCHAR(50),
                                        in    p_val_acessorio  DECIMAL(14, 2),
                                        in    p_seq_motorizacao INT(11),
                                        in    p_seq_fornecedor INT(11),
                                        inout p_seq_acessorio  INT(11)) 

  begin

  update sga.acessorio
    set NOM_ACESSORIO = p_NOM_ACESSORIO, VAL_ACESSORIO = p_VAL_ACESSORIO, SEQ_MOTORIZACAO = p_SEQ_MOTORIZACAO, SEQ_FORNECEDOR = p_SEQ_FORNECEDOR
  where SEQ_ACESSORIO = p_SEQ_ACESSORIO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_acessorio(inout p_seq_acessorio  INT(11))

  begin

  delete from sga.acessorio where SEQ_ACESSORIO = p_SEQ_ACESSORIO;

end$$
DELIMITER ;


-- Script para a tabela: sga.ACESSORIOVEICULO



#------------------------------------------------ sga.ACESSORIOVEICULO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.ACESSORIOVEICULO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_acessorioveiculo(in    p_seq_acessorio       INT(11),
                                               in    p_seq_veiculo         INT(11),
                                               inout p_seq_acessorioveiculo INT(11))

  begin

    insert into sga.acessorioveiculo
      (SEQ_ACESSORIO, SEQ_VEICULO)
    values 
      (p_SEQ_ACESSORIO, p_SEQ_VEICULO);
    SET p_seq_acessorioveiculo = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_acessorioveiculo(in    p_seq_acessorio       INT(11),
                                               in    p_seq_veiculo         INT(11),
                                               inout p_seq_acessorioveiculo INT(11)) 

  begin

  update sga.acessorioveiculo
    set SEQ_ACESSORIO = p_SEQ_ACESSORIO, SEQ_VEICULO = p_SEQ_VEICULO
  where SEQ_ACESSORIOVEICULO = p_SEQ_ACESSORIOVEICULO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_acessorioveiculo(inout p_seq_acessorioveiculo INT(11))

  begin

  delete from sga.acessorioveiculo where SEQ_ACESSORIOVEICULO = p_SEQ_ACESSORIOVEICULO;

end$$
DELIMITER ;


-- Script para a tabela: sga.CONCESSIONARIA



#------------------------------------------------ sga.CONCESSIONARIA ------------------------------------------------
#------------------------------------ Script para a tabela: sga.CONCESSIONARIA --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_concessionaria(in    p_nom_concessionaria  VARCHAR(100),
                                             in    p_num_cnpj            VARCHAR(30),
                                             in    p_dsc_razao_social    VARCHAR(50),
                                             in    p_end_concessionaria  VARCHAR(100),
                                             in    p_nom_contato         VARCHAR(60),
                                             in    p_num_telefone_contato VARCHAR(30),
                                             inout p_seq_concessionaria  INT(11))

  begin

    insert into sga.concessionaria
      (NOM_CONCESSIONARIA, NUM_CNPJ, DSC_RAZAO_SOCIAL, END_CONCESSIONARIA, NOM_CONTATO, NUM_TELEFONE_CONTATO)
    values 
      (p_NOM_CONCESSIONARIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_CONCESSIONARIA, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO);
    SET p_seq_concessionaria = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_concessionaria(in    p_nom_concessionaria  VARCHAR(100),
                                             in    p_num_cnpj            VARCHAR(30),
                                             in    p_dsc_razao_social    VARCHAR(50),
                                             in    p_end_concessionaria  VARCHAR(100),
                                             in    p_nom_contato         VARCHAR(60),
                                             in    p_num_telefone_contato VARCHAR(30),
                                             inout p_seq_concessionaria  INT(11)) 

  begin

  update sga.concessionaria
    set NOM_CONCESSIONARIA = p_NOM_CONCESSIONARIA, NUM_CNPJ = p_NUM_CNPJ, DSC_RAZAO_SOCIAL = p_DSC_RAZAO_SOCIAL, END_CONCESSIONARIA = p_END_CONCESSIONARIA, NOM_CONTATO = p_NOM_CONTATO, NUM_TELEFONE_CONTATO = p_NUM_TELEFONE_CONTATO
  where SEQ_CONCESSIONARIA = p_SEQ_CONCESSIONARIA;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_concessionaria(inout p_seq_concessionaria  INT(11))

  begin

  delete from sga.concessionaria where SEQ_CONCESSIONARIA = p_SEQ_CONCESSIONARIA;

end$$
DELIMITER ;


-- Script para a tabela: sga.FORNECEDOR



#------------------------------------------------ sga.FORNECEDOR ------------------------------------------------
#------------------------------------ Script para a tabela: sga.FORNECEDOR --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_fornecedor(in    p_nom_fornecedor      VARCHAR(100),
                                         in    p_nom_fantasia        VARCHAR(100),
                                         in    p_num_cnpj            VARCHAR(30),
                                         in    p_dsc_razao_social    VARCHAR(50),
                                         in    p_end_fornecedor      VARCHAR(100),
                                         in    p_nom_contato         VARCHAR(60),
                                         in    p_num_telefone_contato VARCHAR(30),
                                         inout p_seq_fornecedor      INT(11))

  begin

    insert into sga.fornecedor
      (NOM_FORNECEDOR, NOM_FANTASIA, NUM_CNPJ, DSC_RAZAO_SOCIAL, END_FORNECEDOR, NOM_CONTATO, NUM_TELEFONE_CONTATO)
    values 
      (p_NOM_FORNECEDOR, p_NOM_FANTASIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_FORNECEDOR, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO);
    SET p_seq_fornecedor = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_fornecedor(in    p_nom_fornecedor      VARCHAR(100),
                                         in    p_nom_fantasia        VARCHAR(100),
                                         in    p_num_cnpj            VARCHAR(30),
                                         in    p_dsc_razao_social    VARCHAR(50),
                                         in    p_end_fornecedor      VARCHAR(100),
                                         in    p_nom_contato         VARCHAR(60),
                                         in    p_num_telefone_contato VARCHAR(30),
                                         inout p_seq_fornecedor      INT(11)) 

  begin

  update sga.fornecedor
    set NOM_FORNECEDOR = p_NOM_FORNECEDOR, NOM_FANTASIA = p_NOM_FANTASIA, NUM_CNPJ = p_NUM_CNPJ, DSC_RAZAO_SOCIAL = p_DSC_RAZAO_SOCIAL, END_FORNECEDOR = p_END_FORNECEDOR, NOM_CONTATO = p_NOM_CONTATO, NUM_TELEFONE_CONTATO = p_NUM_TELEFONE_CONTATO
  where SEQ_FORNECEDOR = p_SEQ_FORNECEDOR;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_fornecedor(inout p_seq_fornecedor      INT(11))

  begin

  delete from sga.fornecedor where SEQ_FORNECEDOR = p_SEQ_FORNECEDOR;

end$$
DELIMITER ;


-- Script para a tabela: sga.MOTORIZACAO



#------------------------------------------------ sga.MOTORIZACAO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.MOTORIZACAO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_motorizacao(in    p_num_potencia        INT(11),
                                          in    p_num_velocidade_final DECIMAL(14, 2),
                                          in    p_num_autonomia       DECIMAL(14, 2),
                                          in    p_seq_tipomotorizacao INT(11),
                                          in    p_dsc_motorizacao     VARCHAR(50),
                                          inout p_seq_motorizacao     INT(11))

  begin

    insert into sga.motorizacao
      (NUM_POTENCIA, NUM_VELOCIDADE_FINAL, NUM_AUTONOMIA, SEQ_TIPOMOTORIZACAO, DSC_MOTORIZACAO)
    values 
      (p_NUM_POTENCIA, p_NUM_VELOCIDADE_FINAL, p_NUM_AUTONOMIA, p_SEQ_TIPOMOTORIZACAO, p_DSC_MOTORIZACAO);
    SET p_seq_motorizacao = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_motorizacao(in    p_num_potencia        INT(11),
                                          in    p_num_velocidade_final DECIMAL(14, 2),
                                          in    p_num_autonomia       DECIMAL(14, 2),
                                          in    p_seq_tipomotorizacao INT(11),
                                          in    p_dsc_motorizacao     VARCHAR(50),
                                          inout p_seq_motorizacao     INT(11)) 

  begin

  update sga.motorizacao
    set NUM_POTENCIA = p_NUM_POTENCIA, NUM_VELOCIDADE_FINAL = p_NUM_VELOCIDADE_FINAL, NUM_AUTONOMIA = p_NUM_AUTONOMIA, SEQ_TIPOMOTORIZACAO = p_SEQ_TIPOMOTORIZACAO, DSC_MOTORIZACAO = p_DSC_MOTORIZACAO
  where SEQ_MOTORIZACAO = p_SEQ_MOTORIZACAO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_motorizacao(inout p_seq_motorizacao     INT(11))

  begin

  delete from sga.motorizacao where SEQ_MOTORIZACAO = p_SEQ_MOTORIZACAO;

end$$
DELIMITER ;


-- Script para a tabela: sga.PECA



#------------------------------------------------ sga.PECA ------------------------------------------------
#------------------------------------ Script para a tabela: sga.PECA --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_peca(in    p_nom_peca      VARCHAR(50),
                                   in    p_seq_fornecedor INT(11),
                                   in    p_flg_prod_mont INT(1),
                                   inout p_seq_peca      INT(11))

  begin

    insert into sga.peca
      (NOM_PECA, SEQ_FORNECEDOR, FLG_PROD_MONT)
    values 
      (p_NOM_PECA, p_SEQ_FORNECEDOR, p_FLG_PROD_MONT);
    SET p_seq_peca = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_peca(in    p_nom_peca      VARCHAR(50),
                                   in    p_seq_fornecedor INT(11),
                                   in    p_flg_prod_mont INT(1),
                                   inout p_seq_peca      INT(11)) 

  begin

  update sga.peca
    set NOM_PECA = p_NOM_PECA, SEQ_FORNECEDOR = p_SEQ_FORNECEDOR, FLG_PROD_MONT = p_FLG_PROD_MONT
  where SEQ_PECA = p_SEQ_PECA;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_peca(inout p_seq_peca      INT(11))

  begin

  delete from sga.peca where SEQ_PECA = p_SEQ_PECA;

end$$
DELIMITER ;


-- Script para a tabela: sga.PECAVEICULO



#------------------------------------------------ sga.PECAVEICULO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.PECAVEICULO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_pecaveiculo(in    p_seq_peca       INT(11),
                                          in    p_seq_veiculo    INT(11),
                                          inout p_seq_pecaveiculo INT(11))

  begin

    insert into sga.pecaveiculo
      (SEQ_PECA, SEQ_VEICULO)
    values 
      (p_SEQ_PECA, p_SEQ_VEICULO);
    SET p_seq_pecaveiculo = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_pecaveiculo(in    p_seq_peca       INT(11),
                                          in    p_seq_veiculo    INT(11),
                                          inout p_seq_pecaveiculo INT(11)) 

  begin

  update sga.pecaveiculo
    set SEQ_PECA = p_SEQ_PECA, SEQ_VEICULO = p_SEQ_VEICULO
  where SEQ_PECAVEICULO = p_SEQ_PECAVEICULO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_pecaveiculo(inout p_seq_pecaveiculo INT(11))

  begin

  delete from sga.pecaveiculo where SEQ_PECAVEICULO = p_SEQ_PECAVEICULO;

end$$
DELIMITER ;


-- Script para a tabela: sga.PERFIL



#------------------------------------------------ sga.PERFIL ------------------------------------------------
#------------------------------------ Script para a tabela: sga.PERFIL --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_perfil(in    p_nom_perfil VARCHAR(50),
                                     inout p_seq_perfil INT(11))

  begin

    insert into sga.perfil
      (NOM_PERFIL)
    values 
      (p_NOM_PERFIL);
    SET p_seq_perfil = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_perfil(in    p_nom_perfil VARCHAR(50),
                                     inout p_seq_perfil INT(11)) 

  begin

  update sga.perfil
    set NOM_PERFIL = p_NOM_PERFIL
  where SEQ_PERFIL = p_SEQ_PERFIL;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_perfil(inout p_seq_perfil INT(11))

  begin

  delete from sga.perfil where SEQ_PERFIL = p_SEQ_PERFIL;

end$$
DELIMITER ;


-- Script para a tabela: sga.TIPOMOTORIZACAO



#------------------------------------------------ sga.TIPOMOTORIZACAO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.TIPOMOTORIZACAO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_tipomotorizacao(in    p_desc_tipomotorizacao VARCHAR(50),
                                              inout p_seq_tipomotorizacao INT(11))

  begin

    insert into sga.tipomotorizacao
      (DESC_TIPOMOTORIZACAO)
    values 
      (p_DESC_TIPOMOTORIZACAO);
    SET p_seq_tipomotorizacao = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_tipomotorizacao(in    p_desc_tipomotorizacao VARCHAR(50),
                                              inout p_seq_tipomotorizacao INT(11)) 

  begin

  update sga.tipomotorizacao
    set DESC_TIPOMOTORIZACAO = p_DESC_TIPOMOTORIZACAO
  where SEQ_TIPOMOTORIZACAO = p_SEQ_TIPOMOTORIZACAO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_tipomotorizacao(inout p_seq_tipomotorizacao INT(11))

  begin

  delete from sga.tipomotorizacao where SEQ_TIPOMOTORIZACAO = p_SEQ_TIPOMOTORIZACAO;

end$$
DELIMITER ;


-- Script para a tabela: sga.TIPOVEICULO



#------------------------------------------------ sga.TIPOVEICULO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.TIPOVEICULO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_tipoveiculo(in    p_nom_tipoveiculo VARCHAR(50),
                                          inout p_seq_tipoveiculo INT(11))

  begin

    insert into sga.tipoveiculo
      (NOM_TIPOVEICULO)
    values 
      (p_NOM_TIPOVEICULO);
    SET p_seq_tipoveiculo = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_tipoveiculo(in    p_nom_tipoveiculo VARCHAR(50),
                                          inout p_seq_tipoveiculo INT(11)) 

  begin

  update sga.tipoveiculo
    set NOM_TIPOVEICULO = p_NOM_TIPOVEICULO
  where SEQ_TIPOVEICULO = p_SEQ_TIPOVEICULO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_tipoveiculo(inout p_seq_tipoveiculo INT(11))

  begin

  delete from sga.tipoveiculo where SEQ_TIPOVEICULO = p_SEQ_TIPOVEICULO;

end$$
DELIMITER ;


-- Script para a tabela: sga.USUARIO



#------------------------------------------------ sga.USUARIO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.USUARIO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_usuario(in    p_nom_usuario VARCHAR(100),
                                      in    p_loginname  VARCHAR(30),
                                      in    p_seq_perfil INT(11),
                                      inout p_seq_usuario INT(11))

  begin

    insert into sga.usuario
      (NOM_USUARIO, LOGINNAME, SEQ_PERFIL)
    values 
      (p_NOM_USUARIO, p_LOGINNAME, p_SEQ_PERFIL);
    SET p_seq_usuario = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_usuario(in    p_nom_usuario VARCHAR(100),
                                      in    p_loginname  VARCHAR(30),
                                      in    p_seq_perfil INT(11),
                                      inout p_seq_usuario INT(11)) 

  begin

  update sga.usuario
    set NOM_USUARIO = p_NOM_USUARIO, LOGINNAME = p_LOGINNAME, SEQ_PERFIL = p_SEQ_PERFIL
  where SEQ_USUARIO = p_SEQ_USUARIO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_usuario(inout p_seq_usuario INT(11))

  begin

  delete from sga.usuario where SEQ_USUARIO = p_SEQ_USUARIO;

end$$
DELIMITER ;


-- Script para a tabela: sga.VEICULO



#------------------------------------------------ sga.VEICULO ------------------------------------------------
#------------------------------------ Script para a tabela: sga.VEICULO --------------------------------------
#
#-------------------------------------------- create script MySQL CRUD --------------------------------------------
DELIMITER $$
create procedure sga.sp_inc_veiculo(in    p_nom_veiculo       VARCHAR(50),
                                      in    p_seq_tipoveiculo   INT(11),
                                      in    p_seq_concessionaria INT(11),
                                      inout p_seq_veiculo       INT(11))

  begin

    insert into sga.veiculo
      (NOM_VEICULO, SEQ_TIPOVEICULO, SEQ_CONCESSIONARIA)
    values 
      (p_NOM_VEICULO, p_SEQ_TIPOVEICULO, p_SEQ_CONCESSIONARIA);
    SET p_seq_veiculo = LAST_INSERT_ID();

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_alt_veiculo(in    p_nom_veiculo       VARCHAR(50),
                                      in    p_seq_tipoveiculo   INT(11),
                                      in    p_seq_concessionaria INT(11),
                                      inout p_seq_veiculo       INT(11)) 

  begin

  update sga.veiculo
    set NOM_VEICULO = p_NOM_VEICULO, SEQ_TIPOVEICULO = p_SEQ_TIPOVEICULO, SEQ_CONCESSIONARIA = p_SEQ_CONCESSIONARIA
  where SEQ_VEICULO = p_SEQ_VEICULO;

end$$
DELIMITER ;

DELIMITER $$
create procedure sga.sp_del_veiculo(inout p_seq_veiculo       INT(11))

  begin

  delete from sga.veiculo where SEQ_VEICULO = p_SEQ_VEICULO;

end$$
DELIMITER ;

