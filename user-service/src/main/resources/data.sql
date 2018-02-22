INSERT INTO co_entity (name, description, parent_id) VALUES
  ('root', 'Entité racine', null),
  ('sipa', 'Entité Groupe SIPA', 1),
  ('vpn', 'Entité VPN', 2),
  ('vpn-france', 'Entité VPN France', 3),
  ('vpn-bordeaux', 'Entité VPN Bordeaux', 3),
  ('vpn-merignac', 'Entité VPN Mérignac', 3);


INSERT INTO co_workspace (name) VALUES
  ('Admin'),
  ('Acheteur'),
  ('Vendeur'),
  ('Comptabilité');

INSERT INTO co_user (workspace_id, entity_id, login, password, mail) VALUES
  (1, 2, 'nmachut', '$2a$10$7yK9yPM4/e4P26MabUiwuOwOufOakBM43D.B8zEktw3Hdk2s1H1k.', 'nmachut@mail.fr');