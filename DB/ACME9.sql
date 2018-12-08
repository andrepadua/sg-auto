CREATE TABLESPACE acme9_dados 
   DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\acme9_dados.dbf' SIZE 10M REUSE
   AUTOEXTEND ON NEXT 5M MAXSIZE 10M;

CREATE TABLESPACE acme9_indices
   DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\acme9_indices.dbf' SIZE 10M REUSE
   AUTOEXTEND ON NEXT 5M MAXSIZE 10M;

CREATE USER ACME9 IDENTIFIED BY ACME9;

alter user acme9 quota unlimited on acme9_dados;
alter user acme9 quota unlimited on acme9_indices;

CREATE TABLE ACME9.ACESSORIO 
(
  SEQ_ACESSORIO NUMBER(11) NOT NULL 
, NOM_ACESSORIO VARCHAR2(50) NOT NULL 
, VAL_ACESSORIO NUMBER(14, 2) NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, SEQ_MOTORIZACAO NUMBER(11) NOT NULL 
, SEQ_FORNECEDOR NUMBER(11) NOT NULL 
, CONSTRAINT ACESSORIO_PK PRIMARY KEY 
  (
    SEQ_ACESSORIO 
  )
   USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0) 
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_ACESSORIO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_ACESSORIO_ts 
  before insert or update on ACME9.ACESSORIO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_ACESSORIO_ts;
/

create or replace trigger ACME9.tg_ACESSORIO_pk 
  before insert on ACME9.ACESSORIO
  for each row
begin
  if (nvl(:new.seq_ACESSORIO, 0) = 0) then 
    :new.seq_ACESSORIO := ACME9.sq_ACESSORIO.nextval;
  end if;
end tg_ACESSORIO_pk;
/

CREATE TABLE ACME9.ACESSORIOVEICULO 
(
  SEQ_ACESSORIOVEICULO NUMBER(11) NOT NULL 
, SEQ_ACESSORIO NUMBER(11) NOT NULL 
, SEQ_VEICULO NUMBER(11) NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT ACESSORIOVEICULO_PK PRIMARY KEY 
  (
    SEQ_ACESSORIOVEICULO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0) 
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_ACESSORIOVEICULO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_ACESSORIOVEICULO_ts 
  before insert or update on ACME9.ACESSORIOVEICULO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_ACESSORIOVEICULO_ts;
/

create or replace trigger ACME9.tg_ACESSORIOVEICULO_pk 
  before insert on ACME9.ACESSORIOVEICULO
  for each row
begin
  if (nvl(:new.seq_ACESSORIOVEICULO, 0) = 0) then 
    :new.seq_ACESSORIOVEICULO := ACME9.sq_ACESSORIOVEICULO.nextval;
  end if;
end tg_ACESSORIOVEICULO_pk;
/

CREATE TABLE ACME9.CONCESSIONARIA 
(
  SEQ_CONCESSIONARIA NUMBER(11) NOT NULL 
, NOM_CONCESSIONARIA VARCHAR2(100) 
, NUM_CNPJ VARCHAR2(30) 
, DSC_RAZAO_SOCIAL VARCHAR2(50) 
, END_CONCESSIONARIA VARCHAR2(100) 
, NOM_CONTATO VARCHAR2(60) 
, NUM_TELEFONE_CONTATO VARCHAR2(30) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT CONCESSIONARIA_PK PRIMARY KEY 
  (
    SEQ_CONCESSIONARIA 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_CONCESSIONARIA
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_CONCESSIONARIA_ts 
  before insert or update on ACME9.CONCESSIONARIA
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_CONCESSIONARIA_ts;
/

create or replace trigger ACME9.tg_CONCESSIONARIA_pk 
  before insert on ACME9.CONCESSIONARIA
  for each row
begin
  if (nvl(:new.seq_CONCESSIONARIA, 0) = 0) then 
    :new.seq_CONCESSIONARIA := ACME9.sq_CONCESSIONARIA.nextval;
  end if;
end tg_CONCESSIONARIA_pk;
/

CREATE TABLE ACME9.FORNECEDOR 
(
  SEQ_FORNECEDOR NUMBER(11) NOT NULL 
, NOM_FORNECEDOR VARCHAR2(100) 
, NOM_FANTASIA VARCHAR2(100) 
, NUM_CNPJ VARCHAR2(30) 
, DSC_RAZAO_SOCIAL VARCHAR2(50) 
, END_FORNECEDOR VARCHAR2(100) 
, NOM_CONTATO VARCHAR2(60) 
, NUM_TELEFONE_CONTATO VARCHAR2(30) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT FORNECEDOR_PK PRIMARY KEY 
  (
    SEQ_FORNECEDOR 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0) 
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_FORNECEDOR
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_FORNECEDOR_ts 
  before insert or update on ACME9.FORNECEDOR
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_FORNECEDOR_ts;
/

create or replace trigger ACME9.tg_FORNECEDOR_pk 
  before insert on ACME9.FORNECEDOR
  for each row
begin
  if (nvl(:new.seq_FORNECEDOR, 0) = 0) then 
    :new.seq_FORNECEDOR := ACME9.sq_FORNECEDOR.nextval;
  end if;
end tg_FORNECEDOR_pk;
/

CREATE TABLE ACME9.MOTORIZACAO 
(
  SEQ_MOTORIZACAO NUMBER(11) NOT NULL 
, NUM_POTENCIA NUMBER(11) NOT NULL 
, NUM_VELOCIDADE_FINAL NUMBER(14, 2) NOT NULL 
, NUM_AUTONOMIA NUMBER(14, 2) NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, SEQ_TIPOMOTORIZACAO NUMBER(11) NOT NULL 
, CONSTRAINT MOTORIZACAO_PK PRIMARY KEY 
  (
    SEQ_MOTORIZACAO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0) 
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_MOTORIZACAO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_MOTORIZACAO_ts 
  before insert or update on ACME9.MOTORIZACAO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_MOTORIZACAO_ts;
/

create or replace trigger ACME9.tg_MOTORIZACAO_pk 
  before insert on ACME9.MOTORIZACAO
  for each row
begin
  if (nvl(:new.seq_MOTORIZACAO, 0) = 0) then 
    :new.seq_MOTORIZACAO := ACME9.sq_MOTORIZACAO.nextval;
  end if;
end tg_MOTORIZACAO_pk;
/

CREATE TABLE ACME9.PECA 
(
  SEQ_PECA NUMBER(11) NOT NULL 
, NOM_PECA VARCHAR2(50) 
, SEQ_FORNECEDOR NUMBER(11) NOT NULL 
, FLG_PROD_MONT NUMBER(1) DEFAULT 0 NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT PECA_PK PRIMARY KEY 
  (
    SEQ_PECA 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_PECA
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_PECA_ts 
  before insert or update on ACME9.PECA
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_PECA_ts;
/

create or replace trigger ACME9.tg_PECA_pk 
  before insert on ACME9.PECA
  for each row
begin
  if (nvl(:new.seq_PECA, 0) = 0) then 
    :new.seq_PECA := ACME9.sq_PECA.nextval;
  end if;
end tg_PECA_pk;
/

CREATE TABLE ACME9.PECAVEICULO 
(
  SEQ_PECAVEICULO NUMBER(11) NOT NULL 
, SEQ_PECA NUMBER(11) NOT NULL 
, SEQ_VEICULO NUMBER(11) NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT PECAVEICULO_PK PRIMARY KEY 
  (
    SEQ_PECAVEICULO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0) 
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_PECAVEICULO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_PECAVEICULO_ts 
  before insert or update on ACME9.PECAVEICULO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_PECAVEICULO_ts;
/

create or replace trigger ACME9.tg_PECAVEICULO_pk 
  before insert on ACME9.PECAVEICULO
  for each row
begin
  if (nvl(:new.seq_PECAVEICULO, 0) = 0) then 
    :new.seq_PECAVEICULO := ACME9.sq_PECAVEICULO.nextval;
  end if;
end tg_PECAVEICULO_pk;
/

CREATE TABLE ACME9.TIPOMOTORIZACAO 
(
  SEQ_TIPOMOTORIZACAO NUMBER(11) NOT NULL 
, DESC_TIPOMOTORIZACAO VARCHAR2(50) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT TIPOMOTORIZACAO_PK PRIMARY KEY 
  (
    SEQ_TIPOMOTORIZACAO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_TIPOMOTORIZACAO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_TIPOMOTORIZACAO_ts 
  before insert or update on ACME9.TIPOMOTORIZACAO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_TIPOMOTORIZACAO_ts;
/

create or replace trigger ACME9.tg_TIPOMOTORIZACAO_pk 
  before insert on ACME9.TIPOMOTORIZACAO
  for each row
begin
  if (nvl(:new.seq_TIPOMOTORIZACAO, 0) = 0) then 
    :new.seq_TIPOMOTORIZACAO := ACME9.sq_TIPOMOTORIZACAO.nextval;
  end if;
end tg_TIPOMOTORIZACAO_pk;
/

CREATE TABLE ACME9.TIPOVEICULO 
(
  SEQ_TIPOVEICULO NUMBER(11) NOT NULL 
, NOM_TIPOVEICULO VARCHAR2(50) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT TIPOVEICULO_PK PRIMARY KEY 
  (
    SEQ_TIPOVEICULO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_TIPOVEICULO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_TIPOVEICULO_ts 
  before insert or update on ACME9.TIPOVEICULO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_TIPOVEICULO_ts;
/

create or replace trigger ACME9.tg_TIPOVEICULO_pk 
  before insert on ACME9.TIPOVEICULO
  for each row
begin
  if (nvl(:new.seq_TIPOVEICULO, 0) = 0) then 
    :new.seq_TIPOVEICULO := ACME9.sq_TIPOVEICULO.nextval;
  end if;
end tg_TIPOVEICULO_pk;
/

CREATE TABLE ACME9.VEICULO 
(
  SEQ_VEICULO NUMBER(11) NOT NULL 
, NOM_VEICULO VARCHAR2(50) NOT NULL 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, SEQ_TIPOVEICULO NUMBER(11) NOT NULL 
, SEQ_CONCESSIONARIA NUMBER(11) NOT NULL 
, CONSTRAINT VEICULO_PK PRIMARY KEY 
  (
    SEQ_VEICULO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)   
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

create sequence ACME9.sq_VEICULO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_VEICULO_ts 
  before insert or update on ACME9.VEICULO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_VEICULO_ts;
/

create or replace trigger ACME9.tg_VEICULO_pk 
  before insert on ACME9.VEICULO
  for each row
begin
  if (nvl(:new.seq_VEICULO, 0) = 0) then 
    :new.seq_VEICULO := ACME9.sq_VEICULO.nextval;
  end if;
end tg_VEICULO_pk;
/

ALTER TABLE ACME9.ACESSORIOVEICULO
ADD CONSTRAINT ACESSORIOVEICULO_UK_001 UNIQUE 
(
  SEQ_ACESSORIO 
, SEQ_VEICULO 
)
USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0);

ALTER TABLE ACME9.PECAVEICULO
ADD CONSTRAINT PECAVEICULO_UK_001 UNIQUE 
(
  SEQ_PECA 
, SEQ_VEICULO 
)
USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0);

ALTER TABLE ACME9.ACESSORIO
ADD CONSTRAINT ACESSORIO_FORNECEDOR_FK FOREIGN KEY
(
  SEQ_FORNECEDOR 
)
REFERENCES ACME9.FORNECEDOR
(
  SEQ_FORNECEDOR 
)
ENABLE;

ALTER TABLE ACME9.ACESSORIO
ADD CONSTRAINT ACESSORIO_MOTORIZACAO_FK FOREIGN KEY
(
  SEQ_MOTORIZACAO 
)
REFERENCES ACME9.MOTORIZACAO
(
  SEQ_MOTORIZACAO 
)
ENABLE;

ALTER TABLE ACME9.ACESSORIOVEICULO
ADD CONSTRAINT ACESSORIOVEICULO_ACESSORIO_FK FOREIGN KEY
(
  SEQ_ACESSORIO 
)
REFERENCES ACME9.ACESSORIO
(
  SEQ_ACESSORIO 
)
ENABLE;

ALTER TABLE ACME9.ACESSORIOVEICULO
ADD CONSTRAINT ACESSORIOVEICULO_VEICULO_FK FOREIGN KEY
(
  SEQ_VEICULO 
)
REFERENCES ACME9.VEICULO
(
  SEQ_VEICULO 
)
ENABLE;

ALTER TABLE ACME9.MOTORIZACAO
ADD CONSTRAINT MOTORIZACAO_TIPOMOTORIZACAO_FK FOREIGN KEY
(
  SEQ_TIPOMOTORIZACAO 
)
REFERENCES ACME9.TIPOMOTORIZACAO
(
  SEQ_TIPOMOTORIZACAO 
)
ENABLE;

ALTER TABLE ACME9.PECA
ADD CONSTRAINT PECA_FORNECEDOR_FK FOREIGN KEY
(
  SEQ_FORNECEDOR 
)
REFERENCES ACME9.FORNECEDOR
(
  SEQ_FORNECEDOR 
)
ENABLE;

ALTER TABLE ACME9.PECAVEICULO
ADD CONSTRAINT PECAVEICULO_PECA_FK FOREIGN KEY
(
  SEQ_PECA 
)
REFERENCES ACME9.PECA
(
  SEQ_PECA 
)
ENABLE;

ALTER TABLE ACME9.PECAVEICULO
ADD CONSTRAINT PECAVEICULO_VEICULO_FK FOREIGN KEY
(
  SEQ_VEICULO 
)
REFERENCES ACME9.VEICULO
(
  SEQ_VEICULO 
)
ENABLE;

ALTER TABLE ACME9.VEICULO
ADD CONSTRAINT VEICULO_CONCESSIONARIA_FK FOREIGN KEY
(
  SEQ_CONCESSIONARIA 
)
REFERENCES ACME9.CONCESSIONARIA
(
  SEQ_CONCESSIONARIA 
)
ENABLE;

ALTER TABLE ACME9.VEICULO
ADD CONSTRAINT VEICULO_TIPOVEICULO_FK FOREIGN KEY
(
  SEQ_TIPOVEICULO 
)
REFERENCES ACME9.TIPOVEICULO
(
  SEQ_TIPOVEICULO 
)
ENABLE;

COMMENT ON TABLE ACME9.ACESSORIO IS 'Para cada modelo, há diversos tipos de configurações possíveis e exclusivas para cada modelo, sendo cada configuração é formada por vários tipos de acessórios e motorização. ';

COMMENT ON TABLE ACME9.ACESSORIOVEICULO IS 'Cada tipo de acessório e caracterizado por um código, nome e custo, e diferenciado para cada modelo de carro.';

COMMENT ON TABLE ACME9.CONCESSIONARIA IS 'A fabrica só vendem seus veículos para a rede de concessionárias associada à marca, não vendendo diretamente para o usuário final, por isso é necessário saber, a Razão social, CNPJ, endereços, telefones, e os nomes de contato das diversas redes de concessionárias.';

COMMENT ON TABLE ACME9.FORNECEDOR IS 'Os fabricantes de peças só produzem peças e os de acessórios só produzem acessórios. As informações relevantes de fornecedores são: Razão social, CNPJ, endereço, telefones e nome de contato.';

COMMENT ON TABLE ACME9.MOTORIZACAO IS 'As informações relevantes para a motorização são:  Potencia em HP, velocidade final, autonomia (consumo em litros por tipo de combustível).';

COMMENT ON TABLE ACME9.PECA IS 'Muitas das peças que compõem os carros são produzidas por uma rede de fabricantes de peças sendo que para cada tipo de peça pode ser fornecida por mais de um fornecedor.';

COMMENT ON TABLE ACME9.PECAVEICULO IS 'Muitas das peças que compõem os carros são produzidas por uma rede de fabricantes de peças sendo que para cada tipo de peça pode ser fornecida por mais de um fornecedor.';

COMMENT ON TABLE ACME9.VEICULO IS 'A ACME montadora de carros produz vários modelos de carros de passeio e de transporte leve.';

COMMENT ON COLUMN ACME9.ACESSORIO.SEQ_ACESSORIO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.ACESSORIO.NOM_ACESSORIO IS 'Nome do Acessório';

COMMENT ON COLUMN ACME9.ACESSORIO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.ACESSORIO.DAT_USUARIO IS 'Data de TimeStamp';

COMMENT ON COLUMN ACME9.ACESSORIOVEICULO.SEQ_ACESSORIOVEICULO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.ACESSORIOVEICULO.SEQ_ACESSORIO IS 'Relacionamento com ACESSORIO';

COMMENT ON COLUMN ACME9.ACESSORIOVEICULO.SEQ_VEICULO IS 'Relacionamento com VEICULO';

COMMENT ON COLUMN ACME9.ACESSORIOVEICULO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.ACESSORIOVEICULO.DAT_USUARIO IS 'Data de TimeStamp';

COMMENT ON COLUMN ACME9.CONCESSIONARIA.SEQ_CONCESSIONARIA IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.FORNECEDOR.SEQ_FORNECEDOR IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.FORNECEDOR.NOM_FORNECEDOR IS 'Nome do Fornecedor';

COMMENT ON COLUMN ACME9.FORNECEDOR.NOM_FANTASIA IS 'Nome Fantasia';

COMMENT ON COLUMN ACME9.FORNECEDOR.NUM_CNPJ IS 'Número do CNPJ';

COMMENT ON COLUMN ACME9.FORNECEDOR.DSC_RAZAO_SOCIAL IS 'Descrição da Razão Social';

COMMENT ON COLUMN ACME9.FORNECEDOR.END_FORNECEDOR IS 'Endereço do Fornecedor';

COMMENT ON COLUMN ACME9.FORNECEDOR.NOM_CONTATO IS 'Nome do Contato';

COMMENT ON COLUMN ACME9.FORNECEDOR.NUM_TELEFONE_CONTATO IS 'Telefone de Contato';

COMMENT ON COLUMN ACME9.FORNECEDOR.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.FORNECEDOR.DAT_USUARIO IS 'Data de TimeStamp';

COMMENT ON COLUMN ACME9.MOTORIZACAO.SEQ_MOTORIZACAO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.MOTORIZACAO.NUM_POTENCIA IS 'Quantidade de Potência (EM HP)';

COMMENT ON COLUMN ACME9.MOTORIZACAO.NUM_VELOCIDADE_FINAL IS 'Valor da Velocidade Final (EM KM/H)';

COMMENT ON COLUMN ACME9.MOTORIZACAO.NUM_AUTONOMIA IS 'Consumo em litros por tipo de combustível';

COMMENT ON COLUMN ACME9.MOTORIZACAO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.MOTORIZACAO.DAT_USUARIO IS 'Data de TimeStamp';

COMMENT ON COLUMN ACME9.PECA.SEQ_PECA IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.PECA.NOM_PECA IS 'Nome da Peça';

COMMENT ON COLUMN ACME9.PECA.FLG_PROD_MONT IS 'Flag de Produzido pela montadora';

COMMENT ON COLUMN ACME9.PECA.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.PECA.DAT_USUARIO IS 'Data de TimStamp';

COMMENT ON COLUMN ACME9.PECAVEICULO.SEQ_PECAVEICULO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.PECAVEICULO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.PECAVEICULO.DAT_USUARIO IS 'Data de TimeStamp';

COMMENT ON COLUMN ACME9.TIPOMOTORIZACAO.SEQ_TIPOMOTORIZACAO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.TIPOMOTORIZACAO.DESC_TIPOMOTORIZACAO IS 'Descrição do Tipo de Motorização...';

COMMENT ON COLUMN ACME9.TIPOMOTORIZACAO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.TIPOMOTORIZACAO.DAT_USUARIO IS 'Data de TimStamp';

COMMENT ON COLUMN ACME9.TIPOVEICULO.SEQ_TIPOVEICULO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.TIPOVEICULO.NOM_TIPOVEICULO IS 'Nome do Veículo';

COMMENT ON COLUMN ACME9.TIPOVEICULO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.TIPOVEICULO.DAT_USUARIO IS 'Data de TimStamp';

COMMENT ON COLUMN ACME9.VEICULO.SEQ_VEICULO IS 'Chave Primária da Tabela';

COMMENT ON COLUMN ACME9.VEICULO.NOM_VEICULO IS 'Nome do Veículo';

COMMENT ON COLUMN ACME9.VEICULO.USUARIO IS 'Usuário de TimeStamp';

COMMENT ON COLUMN ACME9.VEICULO.DAT_USUARIO IS 'Data de TimeStamp';


CREATE TABLE ACME9.PERFIL 
(
  SEQ_PERFIL NUMBER(11) NOT NULL 
, NOM_PERFIL VARCHAR2(50) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, CONSTRAINT PERFIL_PK PRIMARY KEY 
  (
    SEQ_PERFIL 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

COMMENT ON TABLE PERFIL IS 'Tabela de Perfil';
COMMENT ON COLUMN PERFIL.SEQ_PERFIL IS 'Chave Primária da Tabela';
COMMENT ON COLUMN PERFIL.NOM_PERFIL IS 'Nome do Perfil';
COMMENT ON COLUMN PERFIL.USUARIO IS 'Usuário de TimeStamp';
COMMENT ON COLUMN PERFIL.DAT_USUARIO IS 'Data de TimeStamp';

create sequence ACME9.sq_PERFIL
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_PERFIL_ts 
  before insert or update on ACME9.PERFIL
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_PERFIL_ts;
/

create or replace trigger ACME9.tg_PERFIL_pk 
  before insert on ACME9.PERFIL
  for each row
begin
  if (nvl(:new.seq_PERFIL, 0) = 0) then 
    :new.seq_PERFIL := ACME9.sq_PERFIL.nextval;
  end if;
end tg_PERFIL_pk;
/

CREATE TABLE ACME9.USUARIO 
(
  SEQ_USUARIO NUMBER(11) NOT NULL 
, NOM_USUARIO VARCHAR2(100) 
, LOGINNAME VARCHAR2(30) 
, USUARIO VARCHAR2(30) 
, DAT_USUARIO DATE 
, SEQ_PERFIL NUMBER(11) NOT NULL 
, CONSTRAINT USUARIO_PK PRIMARY KEY 
  (
    SEQ_USUARIO 
  )
  USING INDEX TABLESPACE acme9_indices STORAGE (INITIAL 20K NEXT 20k PCTINCREASE 0)  
) tablespace ACME9_DADOS pctfree 30 initrans 1 maxtrans 255 storage (initial 64K minextents 1 maxextents unlimited);

ALTER TABLE ACME9.USUARIO
ADD CONSTRAINT USUARIO_PERFIL_FK FOREIGN KEY
(
  SEQ_PERFIL 
)
REFERENCES ACME9.PERFIL
(
  SEQ_PERFIL 
)
ENABLE;

COMMENT ON TABLE ACME9.USUARIO IS 'Tabela de Usuários';
COMMENT ON COLUMN ACME9.USUARIO.SEQ_USUARIO IS 'Chave Primária da Tabela';
COMMENT ON COLUMN ACME9.USUARIO.NOM_USUARIO IS 'Nome do Usuário';
COMMENT ON COLUMN ACME9.USUARIO.LOGINNAME IS 'Login do Usuário';
COMMENT ON COLUMN ACME9.USUARIO.USUARIO IS 'Usuário de TimeStamp';
COMMENT ON COLUMN ACME9.USUARIO.DAT_USUARIO IS 'Data de TimeStamp';

create sequence ACME9.sq_USUARIO
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
nocache;

create or replace trigger ACME9.tg_USUARIO_ts 
  before insert or update on ACME9.USUARIO
  for each row
begin
  :new.usuario     := user;
  :new.dat_usuario := sysdate;
end tg_USUARIO_ts;
/

create or replace trigger ACME9.tg_USUARIO_pk 
  before insert on ACME9.USUARIO
  for each row
begin
  if (nvl(:new.seq_USUARIO, 0) = 0) then 
    :new.seq_USUARIO := ACME9.sq_USUARIO.nextval;
  end if;
end tg_USUARIO_pk;
/

ALTER TABLE ACME9.MOTORIZACAO ADD DSC_MOTORIZACAO VARCHAR2(50);
comment on column ACME9.MOTORIZACAO.DSC_MOTORIZACAO is 'Descrição Padrão da Motorização';
