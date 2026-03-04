CREATE DATABASE nexus_erp;
USE nexus_erp;

CREATE TABLE server_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    server_name VARCHAR(100),
    region VARCHAR(50),
    status VARCHAR(20)
);

INSERT INTO server_logs (server_name, region, status) VALUES
('SRV-PARIS-01', 'Europe', 'Online'),
('SRV-TOKYO-01', 'Asie', 'Online'),
('SRV-NEWYORK-01', 'Amerique', 'Offline'),
('SRV-BERLIN-02', 'Europe', 'Online'),
('SRV-SHANGHAI-01', 'Asie', 'Offline'),
('SRV-MADRID-01', 'Europe', 'Online'),
('SRV-SYDNEY-01', 'Oceanie', 'Online'),
('SRV-GHOST-01', NULL, 'Offline'),
('SRV-GHOST-02', NULL, 'Online'),
('SRV-LONDON-01', 'Europe', 'Offline');