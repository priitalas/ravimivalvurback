INSERT INTO ravim.role (id, name) VALUES (default, 'admin');
INSERT INTO ravim.role (id, name) VALUES (default, 'patient');
INSERT INTO ravim.role (id, name) VALUES (default, 'doctor');

INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientN', '123', 'N');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 3, 'doctor', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientP', '123', 'P');


INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 4, 'P');
