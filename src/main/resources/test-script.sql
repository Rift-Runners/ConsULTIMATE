INSERT INTO administrador VALUES (1, 'admin', 'admin');
INSERT INTO cliente (cliente_id, cidade, cpf, email, endereco, nome, saldo, senha, rg, telefone, uf, usuario, status) VALUES 
(2,'Porto Alegre', '603.727.612-91', 'roberto@bol.com.br', 'Av. Cairu 2011',
 'Roberto Carlos', 500, '123456', '1525326589','(51) 8181-8181', 'RS', 'roberto', 'true');
INSERT INTO consultor VALUES
(3,'TI','Porto Alegre', '18.672.306/0001-50','Provedora de soluções para sistemas web',
 'itsolutions@bol.com.br', 'Av. Farrapos 111', 'IT Solutions', '123456',
 '(51) 9990-0999', 'RS', 'itsolutions', 60, 'true');
ALTER SEQUENCE hibernate_sequence RESTART WITH 4;