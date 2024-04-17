INSERT INTO ravim.role (id, name) VALUES (default, 'admin');
INSERT INTO ravim.role (id, name) VALUES (default, 'patient');
INSERT INTO ravim.role (id, name) VALUES (default, 'doctor');

INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientN', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 3, 'doctor', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'patientP', '123', 'P');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'vamps', '123', 'P');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 3, 'zelda', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 3, 'margarita', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'vello', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'Pikne', '123', 'A');
INSERT INTO ravim."user" (id, role_id, username, password, status) VALUES (default, 2, 'Sally', '123', 'A');


INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 5, 'info@vamps.com', 'Vambola', 'Vellevoog');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 1, 'adm@admin.ad', 'Ants', 'Tamm');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 6, 'zelda@arst.ee', 'Zelda', 'Zammal');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 7, 'marx@dr.dr', 'Margarita', 'Mesilane');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 8, 'vello@vigur.ee', 'Vello', 'Vigur');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 9, 'pikne@mcqueen.com', 'Pikne', 'McQueen');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 10, 'sally@universalstudios.com', 'Sally', 'Yellow');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 4, 'kalle@kalle.ka', 'Kalle', 'Kala');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 3, 'doc@mallemustikas.ee', 'Malle', 'Mustikas');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 2, 'mati@maasikas.mm', 'Mati', 'Maasikas');


INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 2, 'A');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 4, 'A');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 6, 5, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 6, 8, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 7, 9, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 7, 10, 'P');


INSERT INTO ravim.unit (id, name) VALUES (default, 'tablett');
INSERT INTO ravim.unit (id, name) VALUES (default, 'ml');
INSERT INTO ravim.unit (id, name) VALUES (default, 'pakk');
INSERT INTO ravim.unit (id, name) VALUES (default, 'mg');


INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 1, 'Aspirin', 'peale sööki', 'valuvaigisti, palaviku alandaja', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Prospan', null, 'köhasiirup', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 4, 'Rytmonorm, 150 mg', 'võtta veega, kas koos toiduga või ilma', 'südame arütmiavastane ravim', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Ventolin', ' tohib manustada ainult sissehingamise teel nebulisaatorist', 'nebuliseeritav lahus hingamisraskuse leevendamiseks astma ja sarnaste haiguste korral', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Arthrostop', '', 'kreem liigestele', 'A');

INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 1, 3, '2024-04-15', '2024-05-01', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 2, 2, '2024-04-15', '2024-05-01', 'A');


