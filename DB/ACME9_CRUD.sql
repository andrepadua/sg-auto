create or replace package acme9.pkg_ACESSORIO is 

  procedure sp_inc_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   out acme9.acessorio.seq_acessorio%type);

  procedure sp_alt_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   in acme9.acessorio.seq_acessorio%type);

  procedure sp_del_acessorio(p_seq_acessorio   in acme9.acessorio.seq_acessorio%type);

end pkg_ACESSORIO;
/

create or replace package body acme9.pkg_ACESSORIO is 

  procedure sp_inc_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   out acme9.acessorio.seq_acessorio%type) is

  begin

    execute immediate 'insert into acme9.acessorio
                          (NOM_ACESSORIO, VAL_ACESSORIO, SEQ_MOTORIZACAO, SEQ_FORNECEDOR)
                       values 
                          (:NOM_ACESSORIO, :VAL_ACESSORIO, :SEQ_MOTORIZACAO, :SEQ_FORNECEDOR)
                       returning seq_acessorio into :seq_acessorio'
      using  p_NOM_ACESSORIO, p_VAL_ACESSORIO, p_SEQ_MOTORIZACAO, p_SEQ_FORNECEDOR
      returning into p_seq_acessorio;

    commit work;

  end sp_inc_acessorio;

  procedure sp_alt_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   in acme9.acessorio.seq_acessorio%type) is

  begin

    execute immediate 'update acme9.acessorio
                          set NOM_ACESSORIO = :NOM_ACESSORIO, VAL_ACESSORIO = :VAL_ACESSORIO, SEQ_MOTORIZACAO = :SEQ_MOTORIZACAO, SEQ_FORNECEDOR = :SEQ_FORNECEDOR
                        where SEQ_ACESSORIO = :SEQ_ACESSORIO'
      using p_NOM_ACESSORIO, p_VAL_ACESSORIO, p_SEQ_MOTORIZACAO, p_SEQ_FORNECEDOR, p_SEQ_ACESSORIO;

    commit work;

  end sp_alt_acessorio;

  procedure sp_del_acessorio(p_seq_acessorio   in acme9.acessorio.seq_acessorio%type) is 

  begin

    execute immediate 'delete from acme9.acessorio where SEQ_ACESSORIO = :SEQ_ACESSORIO'
      using p_SEQ_ACESSORIO;

    commit work;

  end sp_del_acessorio;

end pkg_ACESSORIO;
/

create or replace package acme9.pkg_ACESSORIO is 

  procedure sp_inc_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   out acme9.acessorio.seq_acessorio%type);

  procedure sp_alt_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   in acme9.acessorio.seq_acessorio%type);

  procedure sp_del_acessorio(p_seq_acessorio   in acme9.acessorio.seq_acessorio%type);

end pkg_ACESSORIO;
/

create or replace package body acme9.pkg_ACESSORIO is 

  procedure sp_inc_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   out acme9.acessorio.seq_acessorio%type) is

  begin

    execute immediate 'insert into acme9.acessorio
                          (NOM_ACESSORIO, VAL_ACESSORIO, SEQ_MOTORIZACAO, SEQ_FORNECEDOR)
                       values 
                          (:NOM_ACESSORIO, :VAL_ACESSORIO, :SEQ_MOTORIZACAO, :SEQ_FORNECEDOR)
                       returning seq_acessorio into :seq_acessorio'
      using  p_NOM_ACESSORIO, p_VAL_ACESSORIO, p_SEQ_MOTORIZACAO, p_SEQ_FORNECEDOR
      returning into p_seq_acessorio;

    commit work;

  end sp_inc_acessorio;

  procedure sp_alt_acessorio(p_nom_acessorio   in acme9.acessorio.nom_acessorio%type,
                             p_val_acessorio   in acme9.acessorio.val_acessorio%type,
                             p_seq_motorizacao in acme9.acessorio.seq_motorizacao%type,
                             p_seq_fornecedor  in acme9.acessorio.seq_fornecedor%type,
                             p_seq_acessorio   in acme9.acessorio.seq_acessorio%type) is

  begin

    execute immediate 'update acme9.acessorio
                          set NOM_ACESSORIO = :NOM_ACESSORIO, VAL_ACESSORIO = :VAL_ACESSORIO, SEQ_MOTORIZACAO = :SEQ_MOTORIZACAO, SEQ_FORNECEDOR = :SEQ_FORNECEDOR
                        where SEQ_ACESSORIO = :SEQ_ACESSORIO'
      using p_NOM_ACESSORIO, p_VAL_ACESSORIO, p_SEQ_MOTORIZACAO, p_SEQ_FORNECEDOR, p_SEQ_ACESSORIO;

    commit work;

  end sp_alt_acessorio;

  procedure sp_del_acessorio(p_seq_acessorio   in acme9.acessorio.seq_acessorio%type) is 

  begin

    execute immediate 'delete from acme9.acessorio where SEQ_ACESSORIO = :SEQ_ACESSORIO'
      using p_SEQ_ACESSORIO;

    commit work;

  end sp_del_acessorio;

end pkg_ACESSORIO;
/

Procedimento PL/SQL concluído com sucesso.

create or replace package acme9.pkg_ACESSORIOVEICULO is 

  procedure sp_inc_acessorioveiculo(p_seq_acessorio        in acme9.acessorioveiculo.seq_acessorio%type,
                                    p_seq_veiculo          in acme9.acessorioveiculo.seq_veiculo%type,
                                    p_seq_acessorioveiculo out acme9.acessorioveiculo.seq_acessorioveiculo%type);

  procedure sp_alt_acessorioveiculo(p_seq_acessorio        in acme9.acessorioveiculo.seq_acessorio%type,
                                    p_seq_veiculo          in acme9.acessorioveiculo.seq_veiculo%type,
                                    p_seq_acessorioveiculo in acme9.acessorioveiculo.seq_acessorioveiculo%type);

  procedure sp_del_acessorioveiculo(p_seq_acessorioveiculo in acme9.acessorioveiculo.seq_acessorioveiculo%type);

end pkg_ACESSORIOVEICULO;
/

create or replace package body acme9.pkg_ACESSORIOVEICULO is 

  procedure sp_inc_acessorioveiculo(p_seq_acessorio        in acme9.acessorioveiculo.seq_acessorio%type,
                                    p_seq_veiculo          in acme9.acessorioveiculo.seq_veiculo%type,
                                    p_seq_acessorioveiculo out acme9.acessorioveiculo.seq_acessorioveiculo%type) is

  begin

    execute immediate 'insert into acme9.acessorioveiculo
                          (SEQ_ACESSORIO, SEQ_VEICULO)
                       values 
                          (:SEQ_ACESSORIO, :SEQ_VEICULO)
                       returning seq_acessorioveiculo into :seq_acessorioveiculo'
      using  p_SEQ_ACESSORIO, p_SEQ_VEICULO
      returning into p_seq_acessorioveiculo;

    commit work;

  end sp_inc_acessorioveiculo;

  procedure sp_alt_acessorioveiculo(p_seq_acessorio        in acme9.acessorioveiculo.seq_acessorio%type,
                                    p_seq_veiculo          in acme9.acessorioveiculo.seq_veiculo%type,
                                    p_seq_acessorioveiculo in acme9.acessorioveiculo.seq_acessorioveiculo%type) is

  begin

    execute immediate 'update acme9.acessorioveiculo
                          set SEQ_ACESSORIO = :SEQ_ACESSORIO, SEQ_VEICULO = :SEQ_VEICULO
                        where SEQ_ACESSORIOVEICULO = :SEQ_ACESSORIOVEICULO'
      using p_SEQ_ACESSORIO, p_SEQ_VEICULO, p_SEQ_ACESSORIOVEICULO;

    commit work;

  end sp_alt_acessorioveiculo;

  procedure sp_del_acessorioveiculo(p_seq_acessorioveiculo in acme9.acessorioveiculo.seq_acessorioveiculo%type) is 

  begin

    execute immediate 'delete from acme9.acessorioveiculo where SEQ_ACESSORIOVEICULO = :SEQ_ACESSORIOVEICULO'
      using p_SEQ_ACESSORIOVEICULO;

    commit work;

  end sp_del_acessorioveiculo;

end pkg_ACESSORIOVEICULO;
/

create or replace package acme9.pkg_CONCESSIONARIA is 

  procedure sp_inc_concessionaria(p_nom_concessionaria   in acme9.concessionaria.nom_concessionaria%type,
                                  p_num_cnpj             in acme9.concessionaria.num_cnpj%type,
                                  p_dsc_razao_social     in acme9.concessionaria.dsc_razao_social%type,
                                  p_end_concessionaria   in acme9.concessionaria.end_concessionaria%type,
                                  p_nom_contato          in acme9.concessionaria.nom_contato%type,
                                  p_num_telefone_contato in acme9.concessionaria.num_telefone_contato%type,
                                  p_seq_concessionaria   out acme9.concessionaria.seq_concessionaria%type);

  procedure sp_alt_concessionaria(p_nom_concessionaria   in acme9.concessionaria.nom_concessionaria%type,
                                  p_num_cnpj             in acme9.concessionaria.num_cnpj%type,
                                  p_dsc_razao_social     in acme9.concessionaria.dsc_razao_social%type,
                                  p_end_concessionaria   in acme9.concessionaria.end_concessionaria%type,
                                  p_nom_contato          in acme9.concessionaria.nom_contato%type,
                                  p_num_telefone_contato in acme9.concessionaria.num_telefone_contato%type,
                                  p_seq_concessionaria   in acme9.concessionaria.seq_concessionaria%type);

  procedure sp_del_concessionaria(p_seq_concessionaria   in acme9.concessionaria.seq_concessionaria%type);

end pkg_CONCESSIONARIA;
/

create or replace package body acme9.pkg_CONCESSIONARIA is 

  procedure sp_inc_concessionaria(p_nom_concessionaria   in acme9.concessionaria.nom_concessionaria%type,
                                  p_num_cnpj             in acme9.concessionaria.num_cnpj%type,
                                  p_dsc_razao_social     in acme9.concessionaria.dsc_razao_social%type,
                                  p_end_concessionaria   in acme9.concessionaria.end_concessionaria%type,
                                  p_nom_contato          in acme9.concessionaria.nom_contato%type,
                                  p_num_telefone_contato in acme9.concessionaria.num_telefone_contato%type,
                                  p_seq_concessionaria   out acme9.concessionaria.seq_concessionaria%type) is

  begin

    execute immediate 'insert into acme9.concessionaria
                          (NOM_CONCESSIONARIA, NUM_CNPJ, DSC_RAZAO_SOCIAL, END_CONCESSIONARIA, NOM_CONTATO, NUM_TELEFONE_CONTATO)
                       values 
                          (:NOM_CONCESSIONARIA, :NUM_CNPJ, :DSC_RAZAO_SOCIAL, :END_CONCESSIONARIA, :NOM_CONTATO, :NUM_TELEFONE_CONTATO)
                       returning seq_concessionaria into :seq_concessionaria'
      using  p_NOM_CONCESSIONARIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_CONCESSIONARIA, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO
      returning into p_seq_concessionaria;

    commit work;

  end sp_inc_concessionaria;

  procedure sp_alt_concessionaria(p_nom_concessionaria   in acme9.concessionaria.nom_concessionaria%type,
                                  p_num_cnpj             in acme9.concessionaria.num_cnpj%type,
                                  p_dsc_razao_social     in acme9.concessionaria.dsc_razao_social%type,
                                  p_end_concessionaria   in acme9.concessionaria.end_concessionaria%type,
                                  p_nom_contato          in acme9.concessionaria.nom_contato%type,
                                  p_num_telefone_contato in acme9.concessionaria.num_telefone_contato%type,
                                  p_seq_concessionaria   in acme9.concessionaria.seq_concessionaria%type) is

  begin

    execute immediate 'update acme9.concessionaria
                          set NOM_CONCESSIONARIA = :NOM_CONCESSIONARIA, NUM_CNPJ = :NUM_CNPJ, DSC_RAZAO_SOCIAL = :DSC_RAZAO_SOCIAL, END_CONCESSIONARIA = :END_CONCESSIONARIA, NOM_CONTATO = :NOM_CONTATO, NUM_TELEFONE_CONTATO = :NUM_TELEFONE_CONTATO
                        where SEQ_CONCESSIONARIA = :SEQ_CONCESSIONARIA'
      using p_NOM_CONCESSIONARIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_CONCESSIONARIA, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO, p_SEQ_CONCESSIONARIA;

    commit work;

  end sp_alt_concessionaria;

  procedure sp_del_concessionaria(p_seq_concessionaria   in acme9.concessionaria.seq_concessionaria%type) is 

  begin

    execute immediate 'delete from acme9.concessionaria where SEQ_CONCESSIONARIA = :SEQ_CONCESSIONARIA'
      using p_SEQ_CONCESSIONARIA;

    commit work;

  end sp_del_concessionaria;

end pkg_CONCESSIONARIA;
/

create or replace package acme9.pkg_FORNECEDOR is 

  procedure sp_inc_fornecedor(p_nom_fornecedor       in acme9.fornecedor.nom_fornecedor%type,
                              p_nom_fantasia         in acme9.fornecedor.nom_fantasia%type,
                              p_num_cnpj             in acme9.fornecedor.num_cnpj%type,
                              p_dsc_razao_social     in acme9.fornecedor.dsc_razao_social%type,
                              p_end_fornecedor       in acme9.fornecedor.end_fornecedor%type,
                              p_nom_contato          in acme9.fornecedor.nom_contato%type,
                              p_num_telefone_contato in acme9.fornecedor.num_telefone_contato%type,
                              p_seq_fornecedor       out acme9.fornecedor.seq_fornecedor%type);

  procedure sp_alt_fornecedor(p_nom_fornecedor       in acme9.fornecedor.nom_fornecedor%type,
                              p_nom_fantasia         in acme9.fornecedor.nom_fantasia%type,
                              p_num_cnpj             in acme9.fornecedor.num_cnpj%type,
                              p_dsc_razao_social     in acme9.fornecedor.dsc_razao_social%type,
                              p_end_fornecedor       in acme9.fornecedor.end_fornecedor%type,
                              p_nom_contato          in acme9.fornecedor.nom_contato%type,
                              p_num_telefone_contato in acme9.fornecedor.num_telefone_contato%type,
                              p_seq_fornecedor       in acme9.fornecedor.seq_fornecedor%type);

  procedure sp_del_fornecedor(p_seq_fornecedor       in acme9.fornecedor.seq_fornecedor%type);

end pkg_FORNECEDOR;
/

create or replace package body acme9.pkg_FORNECEDOR is 

  procedure sp_inc_fornecedor(p_nom_fornecedor       in acme9.fornecedor.nom_fornecedor%type,
                              p_nom_fantasia         in acme9.fornecedor.nom_fantasia%type,
                              p_num_cnpj             in acme9.fornecedor.num_cnpj%type,
                              p_dsc_razao_social     in acme9.fornecedor.dsc_razao_social%type,
                              p_end_fornecedor       in acme9.fornecedor.end_fornecedor%type,
                              p_nom_contato          in acme9.fornecedor.nom_contato%type,
                              p_num_telefone_contato in acme9.fornecedor.num_telefone_contato%type,
                              p_seq_fornecedor       out acme9.fornecedor.seq_fornecedor%type) is

  begin

    execute immediate 'insert into acme9.fornecedor
                          (NOM_FORNECEDOR, NOM_FANTASIA, NUM_CNPJ, DSC_RAZAO_SOCIAL, END_FORNECEDOR, NOM_CONTATO, NUM_TELEFONE_CONTATO)
                       values 
                          (:NOM_FORNECEDOR, :NOM_FANTASIA, :NUM_CNPJ, :DSC_RAZAO_SOCIAL, :END_FORNECEDOR, :NOM_CONTATO, :NUM_TELEFONE_CONTATO)
                       returning seq_fornecedor into :seq_fornecedor'
      using  p_NOM_FORNECEDOR, p_NOM_FANTASIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_FORNECEDOR, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO
      returning into p_seq_fornecedor;

    commit work;

  end sp_inc_fornecedor;

  procedure sp_alt_fornecedor(p_nom_fornecedor       in acme9.fornecedor.nom_fornecedor%type,
                              p_nom_fantasia         in acme9.fornecedor.nom_fantasia%type,
                              p_num_cnpj             in acme9.fornecedor.num_cnpj%type,
                              p_dsc_razao_social     in acme9.fornecedor.dsc_razao_social%type,
                              p_end_fornecedor       in acme9.fornecedor.end_fornecedor%type,
                              p_nom_contato          in acme9.fornecedor.nom_contato%type,
                              p_num_telefone_contato in acme9.fornecedor.num_telefone_contato%type,
                              p_seq_fornecedor       in acme9.fornecedor.seq_fornecedor%type) is

  begin

    execute immediate 'update acme9.fornecedor
                          set NOM_FORNECEDOR = :NOM_FORNECEDOR, NOM_FANTASIA = :NOM_FANTASIA, NUM_CNPJ = :NUM_CNPJ, DSC_RAZAO_SOCIAL = :DSC_RAZAO_SOCIAL, END_FORNECEDOR = :END_FORNECEDOR, NOM_CONTATO = :NOM_CONTATO, NUM_TELEFONE_CONTATO = :NUM_TELEFONE_CONTATO
                        where SEQ_FORNECEDOR = :SEQ_FORNECEDOR'
      using p_NOM_FORNECEDOR, p_NOM_FANTASIA, p_NUM_CNPJ, p_DSC_RAZAO_SOCIAL, p_END_FORNECEDOR, p_NOM_CONTATO, p_NUM_TELEFONE_CONTATO, p_SEQ_FORNECEDOR;

    commit work;

  end sp_alt_fornecedor;

  procedure sp_del_fornecedor(p_seq_fornecedor       in acme9.fornecedor.seq_fornecedor%type) is 

  begin

    execute immediate 'delete from acme9.fornecedor where SEQ_FORNECEDOR = :SEQ_FORNECEDOR'
      using p_SEQ_FORNECEDOR;

    commit work;

  end sp_del_fornecedor;

end pkg_FORNECEDOR;
/

create or replace package acme9.pkg_MOTORIZACAO is 

  procedure sp_inc_motorizacao(p_num_potencia         in acme9.motorizacao.num_potencia%type,
                               p_num_velocidade_final in acme9.motorizacao.num_velocidade_final%type,
                               p_num_autonomia        in acme9.motorizacao.num_autonomia%type,
                               p_seq_tipomotorizacao  in acme9.motorizacao.seq_tipomotorizacao%type,
                               p_dsc_motorizacao      in acme9.motorizacao.dsc_motorizacao%type,
                               p_seq_motorizacao      out acme9.motorizacao.seq_motorizacao%type);

  procedure sp_alt_motorizacao(p_num_potencia         in acme9.motorizacao.num_potencia%type,
                               p_num_velocidade_final in acme9.motorizacao.num_velocidade_final%type,
                               p_num_autonomia        in acme9.motorizacao.num_autonomia%type,
                               p_seq_tipomotorizacao  in acme9.motorizacao.seq_tipomotorizacao%type,
                               p_dsc_motorizacao      in acme9.motorizacao.dsc_motorizacao%type,
                               p_seq_motorizacao      in acme9.motorizacao.seq_motorizacao%type);

  procedure sp_del_motorizacao(p_seq_motorizacao      in acme9.motorizacao.seq_motorizacao%type);

end pkg_MOTORIZACAO;
/

create or replace package body acme9.pkg_MOTORIZACAO is 

  procedure sp_inc_motorizacao(p_num_potencia         in acme9.motorizacao.num_potencia%type,
                               p_num_velocidade_final in acme9.motorizacao.num_velocidade_final%type,
                               p_num_autonomia        in acme9.motorizacao.num_autonomia%type,
                               p_seq_tipomotorizacao  in acme9.motorizacao.seq_tipomotorizacao%type,
                               p_dsc_motorizacao      in acme9.motorizacao.dsc_motorizacao%type,
                               p_seq_motorizacao      out acme9.motorizacao.seq_motorizacao%type) is

  begin

    execute immediate 'insert into acme9.motorizacao
                          (NUM_POTENCIA, NUM_VELOCIDADE_FINAL, NUM_AUTONOMIA, SEQ_TIPOMOTORIZACAO, DSC_MOTORIZACAO)
                       values 
                          (:NUM_POTENCIA, :NUM_VELOCIDADE_FINAL, :NUM_AUTONOMIA, :SEQ_TIPOMOTORIZACAO, :DSC_MOTORIZACAO)
                       returning seq_motorizacao into :seq_motorizacao'
      using  p_NUM_POTENCIA, p_NUM_VELOCIDADE_FINAL, p_NUM_AUTONOMIA, p_SEQ_TIPOMOTORIZACAO, p_DSC_MOTORIZACAO
      returning into p_seq_motorizacao;

    commit work;

  end sp_inc_motorizacao;

  procedure sp_alt_motorizacao(p_num_potencia         in acme9.motorizacao.num_potencia%type,
                               p_num_velocidade_final in acme9.motorizacao.num_velocidade_final%type,
                               p_num_autonomia        in acme9.motorizacao.num_autonomia%type,
                               p_seq_tipomotorizacao  in acme9.motorizacao.seq_tipomotorizacao%type,
                               p_dsc_motorizacao      in acme9.motorizacao.dsc_motorizacao%type,
                               p_seq_motorizacao      in acme9.motorizacao.seq_motorizacao%type) is

  begin

    execute immediate 'update acme9.motorizacao
                          set NUM_POTENCIA = :NUM_POTENCIA, NUM_VELOCIDADE_FINAL = :NUM_VELOCIDADE_FINAL, NUM_AUTONOMIA = :NUM_AUTONOMIA, SEQ_TIPOMOTORIZACAO = :SEQ_TIPOMOTORIZACAO, DSC_MOTORIZACAO = :DSC_MOTORIZACAO
                        where SEQ_MOTORIZACAO = :SEQ_MOTORIZACAO'
      using p_NUM_POTENCIA, p_NUM_VELOCIDADE_FINAL, p_NUM_AUTONOMIA, p_SEQ_TIPOMOTORIZACAO, p_DSC_MOTORIZACAO, p_SEQ_MOTORIZACAO;

    commit work;

  end sp_alt_motorizacao;

  procedure sp_del_motorizacao(p_seq_motorizacao      in acme9.motorizacao.seq_motorizacao%type) is 

  begin

    execute immediate 'delete from acme9.motorizacao where SEQ_MOTORIZACAO = :SEQ_MOTORIZACAO'
      using p_SEQ_MOTORIZACAO;

    commit work;

  end sp_del_motorizacao;

end pkg_MOTORIZACAO;
/

create or replace package acme9.pkg_PECA is 

  procedure sp_inc_peca(p_nom_peca       in acme9.peca.nom_peca%type,
                        p_seq_fornecedor in acme9.peca.seq_fornecedor%type,
                        p_flg_prod_mont  in acme9.peca.flg_prod_mont%type,
                        p_seq_peca       out acme9.peca.seq_peca%type);

  procedure sp_alt_peca(p_nom_peca       in acme9.peca.nom_peca%type,
                        p_seq_fornecedor in acme9.peca.seq_fornecedor%type,
                        p_flg_prod_mont  in acme9.peca.flg_prod_mont%type,
                        p_seq_peca       in acme9.peca.seq_peca%type);

  procedure sp_del_peca(p_seq_peca       in acme9.peca.seq_peca%type);

end pkg_PECA;
/

create or replace package body acme9.pkg_PECA is 

  procedure sp_inc_peca(p_nom_peca       in acme9.peca.nom_peca%type,
                        p_seq_fornecedor in acme9.peca.seq_fornecedor%type,
                        p_flg_prod_mont  in acme9.peca.flg_prod_mont%type,
                        p_seq_peca       out acme9.peca.seq_peca%type) is

  begin

    execute immediate 'insert into acme9.peca
                          (NOM_PECA, SEQ_FORNECEDOR, FLG_PROD_MONT)
                       values 
                          (:NOM_PECA, :SEQ_FORNECEDOR, :FLG_PROD_MONT)
                       returning seq_peca into :seq_peca'
      using  p_NOM_PECA, p_SEQ_FORNECEDOR, p_FLG_PROD_MONT
      returning into p_seq_peca;

    commit work;

  end sp_inc_peca;

  procedure sp_alt_peca(p_nom_peca       in acme9.peca.nom_peca%type,
                        p_seq_fornecedor in acme9.peca.seq_fornecedor%type,
                        p_flg_prod_mont  in acme9.peca.flg_prod_mont%type,
                        p_seq_peca       in acme9.peca.seq_peca%type) is

  begin

    execute immediate 'update acme9.peca
                          set NOM_PECA = :NOM_PECA, SEQ_FORNECEDOR = :SEQ_FORNECEDOR, FLG_PROD_MONT = :FLG_PROD_MONT
                        where SEQ_PECA = :SEQ_PECA'
      using p_NOM_PECA, p_SEQ_FORNECEDOR, p_FLG_PROD_MONT, p_SEQ_PECA;

    commit work;

  end sp_alt_peca;

  procedure sp_del_peca(p_seq_peca       in acme9.peca.seq_peca%type) is 

  begin

    execute immediate 'delete from acme9.peca where SEQ_PECA = :SEQ_PECA'
      using p_SEQ_PECA;

    commit work;

  end sp_del_peca;

end pkg_PECA;
/

create or replace package acme9.pkg_PECAVEICULO is 

  procedure sp_inc_pecaveiculo(p_seq_peca        in acme9.pecaveiculo.seq_peca%type,
                               p_seq_veiculo     in acme9.pecaveiculo.seq_veiculo%type,
                               p_seq_pecaveiculo out acme9.pecaveiculo.seq_pecaveiculo%type);

  procedure sp_alt_pecaveiculo(p_seq_peca        in acme9.pecaveiculo.seq_peca%type,
                               p_seq_veiculo     in acme9.pecaveiculo.seq_veiculo%type,
                               p_seq_pecaveiculo in acme9.pecaveiculo.seq_pecaveiculo%type);

  procedure sp_del_pecaveiculo(p_seq_pecaveiculo in acme9.pecaveiculo.seq_pecaveiculo%type);

end pkg_PECAVEICULO;
/

create or replace package body acme9.pkg_PECAVEICULO is 

  procedure sp_inc_pecaveiculo(p_seq_peca        in acme9.pecaveiculo.seq_peca%type,
                               p_seq_veiculo     in acme9.pecaveiculo.seq_veiculo%type,
                               p_seq_pecaveiculo out acme9.pecaveiculo.seq_pecaveiculo%type) is

  begin

    execute immediate 'insert into acme9.pecaveiculo
                          (SEQ_PECA, SEQ_VEICULO)
                       values 
                          (:SEQ_PECA, :SEQ_VEICULO)
                       returning seq_pecaveiculo into :seq_pecaveiculo'
      using  p_SEQ_PECA, p_SEQ_VEICULO
      returning into p_seq_pecaveiculo;

    commit work;

  end sp_inc_pecaveiculo;

  procedure sp_alt_pecaveiculo(p_seq_peca        in acme9.pecaveiculo.seq_peca%type,
                               p_seq_veiculo     in acme9.pecaveiculo.seq_veiculo%type,
                               p_seq_pecaveiculo in acme9.pecaveiculo.seq_pecaveiculo%type) is

  begin

    execute immediate 'update acme9.pecaveiculo
                          set SEQ_PECA = :SEQ_PECA, SEQ_VEICULO = :SEQ_VEICULO
                        where SEQ_PECAVEICULO = :SEQ_PECAVEICULO'
      using p_SEQ_PECA, p_SEQ_VEICULO, p_SEQ_PECAVEICULO;

    commit work;

  end sp_alt_pecaveiculo;

  procedure sp_del_pecaveiculo(p_seq_pecaveiculo in acme9.pecaveiculo.seq_pecaveiculo%type) is 

  begin

    execute immediate 'delete from acme9.pecaveiculo where SEQ_PECAVEICULO = :SEQ_PECAVEICULO'
      using p_SEQ_PECAVEICULO;

    commit work;

  end sp_del_pecaveiculo;

end pkg_PECAVEICULO;
/

create or replace package acme9.pkg_TIPOMOTORIZACAO is 

  procedure sp_inc_tipomotorizacao(p_desc_tipomotorizacao in acme9.tipomotorizacao.desc_tipomotorizacao%type,
                                   p_seq_tipomotorizacao  out acme9.tipomotorizacao.seq_tipomotorizacao%type);

  procedure sp_alt_tipomotorizacao(p_desc_tipomotorizacao in acme9.tipomotorizacao.desc_tipomotorizacao%type,
                                   p_seq_tipomotorizacao  in acme9.tipomotorizacao.seq_tipomotorizacao%type);

  procedure sp_del_tipomotorizacao(p_seq_tipomotorizacao  in acme9.tipomotorizacao.seq_tipomotorizacao%type);

end pkg_TIPOMOTORIZACAO;
/

create or replace package body acme9.pkg_TIPOMOTORIZACAO is 

  procedure sp_inc_tipomotorizacao(p_desc_tipomotorizacao in acme9.tipomotorizacao.desc_tipomotorizacao%type,
                                   p_seq_tipomotorizacao  out acme9.tipomotorizacao.seq_tipomotorizacao%type) is

  begin

    execute immediate 'insert into acme9.tipomotorizacao
                          (DESC_TIPOMOTORIZACAO)
                       values 
                          (:DESC_TIPOMOTORIZACAO)
                       returning seq_tipomotorizacao into :seq_tipomotorizacao'
      using  p_DESC_TIPOMOTORIZACAO
      returning into p_seq_tipomotorizacao;

    commit work;

  end sp_inc_tipomotorizacao;

  procedure sp_alt_tipomotorizacao(p_desc_tipomotorizacao in acme9.tipomotorizacao.desc_tipomotorizacao%type,
                                   p_seq_tipomotorizacao  in acme9.tipomotorizacao.seq_tipomotorizacao%type) is

  begin

    execute immediate 'update acme9.tipomotorizacao
                          set DESC_TIPOMOTORIZACAO = :DESC_TIPOMOTORIZACAO
                        where SEQ_TIPOMOTORIZACAO = :SEQ_TIPOMOTORIZACAO'
      using p_DESC_TIPOMOTORIZACAO, p_SEQ_TIPOMOTORIZACAO;

    commit work;

  end sp_alt_tipomotorizacao;

  procedure sp_del_tipomotorizacao(p_seq_tipomotorizacao  in acme9.tipomotorizacao.seq_tipomotorizacao%type) is 

  begin

    execute immediate 'delete from acme9.tipomotorizacao where SEQ_TIPOMOTORIZACAO = :SEQ_TIPOMOTORIZACAO'
      using p_SEQ_TIPOMOTORIZACAO;

    commit work;

  end sp_del_tipomotorizacao;

end pkg_TIPOMOTORIZACAO;
/

create or replace package acme9.pkg_TIPOVEICULO is 

  procedure sp_inc_tipoveiculo(p_nom_tipoveiculo in acme9.tipoveiculo.nom_tipoveiculo%type,
                               p_seq_tipoveiculo out acme9.tipoveiculo.seq_tipoveiculo%type);

  procedure sp_alt_tipoveiculo(p_nom_tipoveiculo in acme9.tipoveiculo.nom_tipoveiculo%type,
                               p_seq_tipoveiculo in acme9.tipoveiculo.seq_tipoveiculo%type);

  procedure sp_del_tipoveiculo(p_seq_tipoveiculo in acme9.tipoveiculo.seq_tipoveiculo%type);

end pkg_TIPOVEICULO;
/

create or replace package body acme9.pkg_TIPOVEICULO is 

  procedure sp_inc_tipoveiculo(p_nom_tipoveiculo in acme9.tipoveiculo.nom_tipoveiculo%type,
                               p_seq_tipoveiculo out acme9.tipoveiculo.seq_tipoveiculo%type) is

  begin

    execute immediate 'insert into acme9.tipoveiculo
                          (NOM_TIPOVEICULO)
                       values 
                          (:NOM_TIPOVEICULO)
                       returning seq_tipoveiculo into :seq_tipoveiculo'
      using  p_NOM_TIPOVEICULO
      returning into p_seq_tipoveiculo;

    commit work;

  end sp_inc_tipoveiculo;

  procedure sp_alt_tipoveiculo(p_nom_tipoveiculo in acme9.tipoveiculo.nom_tipoveiculo%type,
                               p_seq_tipoveiculo in acme9.tipoveiculo.seq_tipoveiculo%type) is

  begin

    execute immediate 'update acme9.tipoveiculo
                          set NOM_TIPOVEICULO = :NOM_TIPOVEICULO
                        where SEQ_TIPOVEICULO = :SEQ_TIPOVEICULO'
      using p_NOM_TIPOVEICULO, p_SEQ_TIPOVEICULO;

    commit work;

  end sp_alt_tipoveiculo;

  procedure sp_del_tipoveiculo(p_seq_tipoveiculo in acme9.tipoveiculo.seq_tipoveiculo%type) is 

  begin

    execute immediate 'delete from acme9.tipoveiculo where SEQ_TIPOVEICULO = :SEQ_TIPOVEICULO'
      using p_SEQ_TIPOVEICULO;

    commit work;

  end sp_del_tipoveiculo;

end pkg_TIPOVEICULO;
/

create or replace package acme9.pkg_VEICULO is 

  procedure sp_inc_veiculo(p_nom_veiculo        in acme9.veiculo.nom_veiculo%type,
                           p_seq_tipoveiculo    in acme9.veiculo.seq_tipoveiculo%type,
                           p_seq_concessionaria in acme9.veiculo.seq_concessionaria%type,
                           p_seq_veiculo        out acme9.veiculo.seq_veiculo%type);

  procedure sp_alt_veiculo(p_nom_veiculo        in acme9.veiculo.nom_veiculo%type,
                           p_seq_tipoveiculo    in acme9.veiculo.seq_tipoveiculo%type,
                           p_seq_concessionaria in acme9.veiculo.seq_concessionaria%type,
                           p_seq_veiculo        in acme9.veiculo.seq_veiculo%type);

  procedure sp_del_veiculo(p_seq_veiculo        in acme9.veiculo.seq_veiculo%type);

end pkg_VEICULO;
/

create or replace package body acme9.pkg_VEICULO is 

  procedure sp_inc_veiculo(p_nom_veiculo        in acme9.veiculo.nom_veiculo%type,
                           p_seq_tipoveiculo    in acme9.veiculo.seq_tipoveiculo%type,
                           p_seq_concessionaria in acme9.veiculo.seq_concessionaria%type,
                           p_seq_veiculo        out acme9.veiculo.seq_veiculo%type) is

  begin

    execute immediate 'insert into acme9.veiculo
                          (NOM_VEICULO, SEQ_TIPOVEICULO, SEQ_CONCESSIONARIA)
                       values 
                          (:NOM_VEICULO, :SEQ_TIPOVEICULO, :SEQ_CONCESSIONARIA)
                       returning seq_veiculo into :seq_veiculo'
      using  p_NOM_VEICULO, p_SEQ_TIPOVEICULO, p_SEQ_CONCESSIONARIA
      returning into p_seq_veiculo;

    commit work;

  end sp_inc_veiculo;

  procedure sp_alt_veiculo(p_nom_veiculo        in acme9.veiculo.nom_veiculo%type,
                           p_seq_tipoveiculo    in acme9.veiculo.seq_tipoveiculo%type,
                           p_seq_concessionaria in acme9.veiculo.seq_concessionaria%type,
                           p_seq_veiculo        in acme9.veiculo.seq_veiculo%type) is

  begin

    execute immediate 'update acme9.veiculo
                          set NOM_VEICULO = :NOM_VEICULO, SEQ_TIPOVEICULO = :SEQ_TIPOVEICULO, SEQ_CONCESSIONARIA = :SEQ_CONCESSIONARIA
                        where SEQ_VEICULO = :SEQ_VEICULO'
      using p_NOM_VEICULO, p_SEQ_TIPOVEICULO, p_SEQ_CONCESSIONARIA, p_SEQ_VEICULO;

    commit work;

  end sp_alt_veiculo;

  procedure sp_del_veiculo(p_seq_veiculo        in acme9.veiculo.seq_veiculo%type) is 

  begin

    execute immediate 'delete from acme9.veiculo where SEQ_VEICULO = :SEQ_VEICULO'
      using p_SEQ_VEICULO;

    commit work;

  end sp_del_veiculo;

end pkg_VEICULO;
/

create or replace package acme9.pkg_USUARIO is 

  procedure sp_inc_usuario(p_nom_usuario in acme9.usuario.nom_usuario%type,
                           p_loginname   in acme9.usuario.loginname%type,
                           p_seq_perfil  in acme9.usuario.seq_perfil%type,
                           p_seq_usuario out acme9.usuario.seq_usuario%type);

  procedure sp_alt_usuario(p_nom_usuario in acme9.usuario.nom_usuario%type,
                           p_loginname   in acme9.usuario.loginname%type,
                           p_seq_perfil  in acme9.usuario.seq_perfil%type,
                           p_seq_usuario in acme9.usuario.seq_usuario%type);

  procedure sp_del_usuario(p_seq_usuario in acme9.usuario.seq_usuario%type);

end pkg_USUARIO;
/
create or replace package body acme9.pkg_USUARIO is 

  procedure sp_inc_usuario(p_nom_usuario in acme9.usuario.nom_usuario%type,
                           p_loginname   in acme9.usuario.loginname%type,
                           p_seq_perfil  in acme9.usuario.seq_perfil%type,
                           p_seq_usuario out acme9.usuario.seq_usuario%type) is

  begin

    execute immediate 'insert into acme9.usuario
                          (NOM_USUARIO, LOGINNAME, SEQ_PERFIL)
                       values 
                          (:NOM_USUARIO, :LOGINNAME, :SEQ_PERFIL)
                       returning seq_usuario into :seq_usuario'
      using  p_NOM_USUARIO, p_LOGINNAME, p_SEQ_PERFIL
      returning into p_seq_usuario;

    commit work;

  end sp_inc_usuario;

  procedure sp_alt_usuario(p_nom_usuario in acme9.usuario.nom_usuario%type,
                           p_loginname   in acme9.usuario.loginname%type,
                           p_seq_perfil  in acme9.usuario.seq_perfil%type,
                           p_seq_usuario in acme9.usuario.seq_usuario%type) is

  begin

    execute immediate 'update acme9.usuario
                          set NOM_USUARIO = :NOM_USUARIO, LOGINNAME = :LOGINNAME, SEQ_PERFIL = :SEQ_PERFIL
                        where SEQ_USUARIO = :SEQ_USUARIO'
      using p_NOM_USUARIO, p_LOGINNAME, p_SEQ_PERFIL, p_SEQ_USUARIO;

    commit work;

  end sp_alt_usuario;

  procedure sp_del_usuario(p_seq_usuario in acme9.usuario.seq_usuario%type) is 

  begin

    execute immediate 'delete from acme9.usuario where SEQ_USUARIO = :SEQ_USUARIO'
      using p_SEQ_USUARIO;

    commit work;

  end sp_del_usuario;

end pkg_USUARIO;
/

create or replace package acme9.pkg_PERFIL is 

  procedure sp_inc_perfil(p_nom_perfil  in acme9.perfil.nom_perfil%type,
                          p_seq_perfil  out acme9.perfil.seq_perfil%type);

  procedure sp_alt_perfil(p_nom_perfil  in acme9.perfil.nom_perfil%type,
                          p_seq_perfil  in acme9.perfil.seq_perfil%type);

  procedure sp_del_perfil(p_seq_perfil  in acme9.perfil.seq_perfil%type);

end pkg_PERFIL;
/

create or replace package body acme9.pkg_PERFIL is 

  procedure sp_inc_perfil(p_nom_perfil  in acme9.perfil.nom_perfil%type,
                          p_seq_perfil  out acme9.perfil.seq_perfil%type) is

  begin

    execute immediate 'insert into acme9.perfil
                          (NOM_PERFIL)
                       values 
                          (:NOM_PERFIL)
                       returning seq_perfil into :seq_perfil'
      using  p_NOM_PERFIL
      returning into p_seq_perfil;

    commit work;

  end sp_inc_perfil;

  procedure sp_alt_perfil(p_nom_perfil  in acme9.perfil.nom_perfil%type,
                          p_seq_perfil  in acme9.perfil.seq_perfil%type) is

  begin

    execute immediate 'update acme9.perfil
                          set NOM_PERFIL = :NOM_PERFIL
                        where SEQ_PERFIL = :SEQ_PERFIL'
      using p_NOM_PERFIL, p_SEQ_PERFIL;

    commit work;

  end sp_alt_perfil;

  procedure sp_del_perfil(p_seq_perfil  in acme9.perfil.seq_perfil%type) is 

  begin

    execute immediate 'delete from acme9.perfil where SEQ_PERFIL = :SEQ_PERFIL'
      using p_SEQ_PERFIL;

    commit work;

  end sp_del_perfil;

end pkg_PERFIL;
/

