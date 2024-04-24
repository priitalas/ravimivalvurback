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


INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 1, 'Aspirin', 'peale sööki', 'Aspiriin ehk atsetüülsalitsüülhape on ravim, mida kasutatakse nõrga valu ja palaviku vastu. Samuti on aspiriinil verd vedeldav toime ja seetõttu kasutataksegi südameaspiriini südame veresoonkonna haiguste ennetamiseks. Aspiriin oli esimene väljatöötatud mittesteroidne põletikuvastane ravim ja seda kasutatakse reumaatiliste haiguste raviks.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Prospan', null, 'Prospan siirupit kasutatakse köha korral röga lahtistamiseks.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 4, 'Rytmonorm, 150 mg', 'võtta veega, kas koos toiduga või ilma', 'Rytmonorm’i kasutatakse südame löögisageduse reguleerimiseks ja südame löögikiiruse aeglustamiseks. See kuulub ravimite rühma, mida nimetatakse antiarütmikumideks ning mida kasutatakse südame löögikiiruse/südamerütmi normaliseerimiseks. Rytmonorm’i tabletid sisaldavad toimeainena propafenoonvesinikkloriidi. Rytmonorm’i kasutatakse tahhüarütmia (südame rütmihäire) erinevate vormide raviks: - paroksüsmaalsed supraventrikulaarsed tahhüarütmiad, sealhulgas kodade virvendus.  - mitteisheemilise tekkega ventrikulaarsed tahhüarütmiad.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Ventolin', ' tohib manustada ainult sissehingamise teel nebulisaatorist', 'Bronhospasmi ravi või profülaktika bronhiaalastma või kroonilise obstruktiivse kopsuhaiguse korral. Ventolin on näidustatud täiskasvanutele, noorukitele ja 4 kuni 11-aastastele lastele. Imikute ja kuni 4 aastaste laste kohta vt lõigud 4.2 ja 5.1. Märkus. Salbutamool on selektiivne beeta-2-adrenomimeetikum, mis tagab lühiajalise bronhodilatatsiooni hingamisteede pöörduva obstruktsiooni korral. Salbutamooli ei tohi kasutada püsiva astma ainukese või põhiravina. Püsiva astmaga patsientidel, kes ei allu salbutamoolile, on kontrolli saavutamiseks ja säilitamiseks soovitatav ravi inhaleeritavate glükokortikosteroididega. Salbutamoolravile mitteallumine võib viidata vajadusele kohese arstliku konsultatsiooni või ravi järele.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Arthrostop', '', 'kreem liigestele. Sisaldab glükoosamiini ja MSM-i koos India viirukipuust saadava taimse ekstrakti (Boswellia serrata) ja mangaaniga.', 'A');

INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 1, 3, '2024-04-15', '2024-05-01', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 2, 2, '2024-04-15', '2024-05-01', 'A');

INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 1, '08:00:00', '12:00:00', 2.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 1, '12:00:00', '18:00:00', 2.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 2, '08:00:00', '12:00:00', 1.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 2, '12:00:00', '18:00:00', 1.00);





