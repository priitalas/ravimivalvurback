INSERT INTO ravim.role (id, name) VALUES (default, 'admin');
INSERT INTO ravim.role (id, name) VALUES (default, 'patient');
INSERT INTO ravim.role (id, name) VALUES (default, 'doctor');

INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'patientN', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 3, 'doctor', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'kalle', '123', 'P');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'vamps', '123', 'P');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 3, 'zelda', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 3, 'margarita', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'vello', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'Pikne', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'Sally', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 3, 'nelly89', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'onne', '123', 'P');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 3, 'henri', '123', 'A');
INSERT INTO ravim.user (id, role_id, username, password, status) VALUES (default, 2, 'ylar', '123', 'P');


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
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 12, 'onne@oun.ou', 'Õnne', 'Õunapuu');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 11, 'nelly@noormann.ee', 'Nelly', 'Noormann');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 13, 'h@h.hh', 'Henri', 'Hammas');
INSERT INTO ravim.contact (id, user_id, email, first_name, last_name) VALUES (default, 14, 'yl@mail.ee', 'Ülar', 'Ülane');



INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 4, 'A');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 6, 5, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 6, 8, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 7, 9, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 7, 10, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 11, 12, 'A');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 13, 14, 'P');
INSERT INTO ravim.doctor_patient (id, doctor_id, patient_id, status) VALUES (default, 3, 2, 'A');



INSERT INTO ravim.unit (id, name) VALUES (default, 'tablett');
INSERT INTO ravim.unit (id, name) VALUES (default, 'ml');
INSERT INTO ravim.unit (id, name) VALUES (default, 'pakk');
INSERT INTO ravim.unit (id, name) VALUES (default, 'mg');
INSERT INTO ravim.unit (id, name) VALUES (default, 'kapsel');



INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 1, 'Aspirin', 'Peale sööki', 'Aspiriin ehk atsetüülsalitsüülhape on ravim, mida kasutatakse nõrga valu ja palaviku vastu. Samuti on aspiriinil verd vedeldav toime ja seetõttu kasutataksegi südameaspiriini südame veresoonkonna haiguste ennetamiseks. Aspiriin oli esimene väljatöötatud mittesteroidne põletikuvastane ravim ja seda kasutatakse reumaatiliste haiguste raviks.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Ventolin', 'Manustada ainult sissehingamise teel nebulisaatorist', 'Bronhospasmi ravi või profülaktika bronhiaalastma või kroonilise obstruktiivse kopsuhaiguse korral. Ventolin on näidustatud täiskasvanutele, noorukitele ja 4 kuni 11-aastastele lastele. Imikute ja kuni 4 aastaste laste kohta vt lõigud 4.2 ja 5.1. Märkus. Salbutamool on selektiivne beeta-2-adrenomimeetikum, mis tagab lühiajalise bronhodilatatsiooni hingamisteede pöörduva obstruktsiooni korral. Salbutamooli ei tohi kasutada püsiva astma ainukese või põhiravina. Püsiva astmaga patsientidel, kes ei allu salbutamoolile, on kontrolli saavutamiseks ja säilitamiseks soovitatav ravi inhaleeritavate glükokortikosteroididega. Salbutamoolravile mitteallumine võib viidata vajadusele kohese arstliku konsultatsiooni või ravi järele.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 4, 'Rytmonorm, 150 mg', 'Võtta veega, kas koos toiduga või ilma', 'Rytmonorm’i kasutatakse südame löögisageduse reguleerimiseks ja südame löögikiiruse aeglustamiseks. See kuulub ravimite rühma, mida nimetatakse antiarütmikumideks ning mida kasutatakse südame löögikiiruse/südamerütmi normaliseerimiseks. Rytmonorm’i tabletid sisaldavad toimeainena propafenoonvesinikkloriidi. Rytmonorm’i kasutatakse tahhüarütmia (südame rütmihäire) erinevate vormide raviks: - paroksüsmaalsed supraventrikulaarsed tahhüarütmiad, sealhulgas kodade virvendus.  - mitteisheemilise tekkega ventrikulaarsed tahhüarütmiad.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Prospan', 'Peale sööki', 'Prospan siirupit kasutatakse köha korral röga lahtistamiseks.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 2, 'Arthrostop', 'Masseerida ringjate liigutustega nahale', 'Kreem liigestele. Sisaldab glükoosamiini ja MSM-i koos India viirukipuust saadava taimse ekstrakti (Boswellia serrata) ja mangaaniga.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 1, 'Actifed', '', 'ACTIFED tabletid on näidustatud nina limaskesta turse vähendamiseks nohu korral; sh allergilise nohu korral', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 1, 'C-vitamiin', 'Toidulisand', 'Vitamiin C tabletid 500 mg. Toidulisand. Kasutamine: täiendav C-vitamiini allikas. Koostisosad: l-askorbiinhape, paakumisvastased ained-mikrokristalne tselluloos, kaltsiumstearaat ja ränidioksiid, zhelatiin.', 'A');
INSERT INTO ravim.medication (id, unit_id, name, note, description, status) VALUES (default, 5, 'D-vitamiin', 'Soovitavalt söögi ajal või pärast sööki', 'Suur annus D3-vitamiini pisikeses ja kergesti neelatavas õlikapslis. Hästi omastatav päevalilleõlil baseeruv koostis. 1 kapsel päevas.Sobib lastele alates 11 aasta vanusest ja täiskasvanutele, sealhulgas rasedatele ja imetavatele naistele.', 'A');

INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 1, 3, '2024-04-15', '2024-05-01', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 2, 2, '2024-04-15', '2024-05-01', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 3, 1, '2024-04-09', '2024-04-30', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 4, 3, '2024-04-09', '2024-04-30', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 2, 5, 2, '2024-04-09', '2024-04-30', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 5, 1, 1, '2024-04-24', '2024-04-29', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 5, 2, 2, '2024-04-23', '2024-04-30', 'A');
INSERT INTO ravim.medication_plan (id, patient_id, medication_id, frequency, period_start, period_end, status) VALUES (default, 5, 3, 1, '2024-04-21', '2024-05-30', 'A');

INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 1, '08:00:00', '12:00:00', 2.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 1, '12:00:00', '18:00:00', 2.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 2, '08:00:00', '12:00:00', 1.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 2, '12:00:00', '18:00:00', 1.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 3, '08:03:04', '23:14:18', 1.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 4, '08:03:04', '23:14:18', 2.00);
INSERT INTO ravim.medication_time (id, medication_plan_id, slot_start, slot_end, quantity) VALUES (default, 5, '08:03:04', '23:14:18', 1.00);
