INSERT INTO ravim.role (id, name) VALUES (default, 'admin');
INSERT INTO ravim.role (id, name) VALUES (default, 'patient');
INSERT INTO ravim.role (id, name) VALUES (default, 'doctor');

INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientN', '123', 'N');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 3, 'doctor', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientP', '123', 'P');


INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 4, 'P');

INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 2, 'mati', 'Mati', 'Maasikas');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 3, 'doc', 'Malle', 'Mustikas');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 1, 'adm', 'Ants', 'Tamm');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 2, 'kalle', 'Kalle', 'Kala');