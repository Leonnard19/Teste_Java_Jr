INSERT INTO CARTORIO(codigo, nome, endereco)
VALUES (SQ_CARTORIO.nextval, 'Cartório Master', 'Rua London Bridge');

INSERT INTO CERTIDAO(id, descricao, cartorio_codigo)
VALUES (SQ_CERTIDAO.nextval, 'Nascimento', 1);

INSERT INTO CERTIDAO(id, descricao, cartorio_codigo)
VALUES (SQ_CERTIDAO.nextval, 'Casamento', 1);

INSERT INTO CERTIDAO(id, descricao, cartorio_codigo)
VALUES (SQ_CERTIDAO.nextval, 'Óbito', 1);