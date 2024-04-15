-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-04-09 07:14:04.601

-- tables
-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         email varchar(255)  NOT NULL,
                         first_name varchar(255)  NOT NULL,
                         last_name varchar(255)  NOT NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: doctor_patient
CREATE TABLE doctor_patient (
                                id serial  NOT NULL,
                                doctor_id int  NOT NULL,
                                patient_id int  NOT NULL,
                                status char(1)  NOT NULL,
                                CONSTRAINT doctor_patient_pk PRIMARY KEY (id)
);

-- Table: logbook
CREATE TABLE logbook (
                         id serial  NOT NULL,
                         medication_plan_id int  NOT NULL,
                         date date  NOT NULL,
                         time time  NOT NULL,
                         CONSTRAINT logbook_pk PRIMARY KEY (id)
);

-- Table: medication
CREATE TABLE medication (
                            id serial  NOT NULL,
                            unit_id int  NOT NULL,
                            name varchar(255)  NOT NULL,
                            note varchar(255)  NULL,
                            description varchar(1000)  NOT NULL,
                            status char(1)  NOT NULL,
                            CONSTRAINT medication_pk PRIMARY KEY (id)
);

-- Table: medication_image
CREATE TABLE medication_image (
                                  id serial  NOT NULL,
                                  medication_id int  NOT NULL,
                                  data bytea  NOT NULL,
                                  CONSTRAINT medication_image_pk PRIMARY KEY (id)
);

-- Table: medication_plan
CREATE TABLE medication_plan (
                                 id serial  NOT NULL,
                                 patient_id int  NOT NULL,
                                 medication_id int  NOT NULL,
                                 frequency int  NOT NULL,
                                 period_start date  NOT NULL,
                                 period_end date  NOT NULL,
                                 status char(1)  NOT NULL,
                                 CONSTRAINT medication_plan_pk PRIMARY KEY (id)
);

-- Table: medication_time
CREATE TABLE medication_time (
                                 id serial  NOT NULL,
                                 medication_plan_id int  NOT NULL,
                                 slot_start time  NOT NULL,
                                 slot_end time  NOT NULL,
                                 quantity decimal(4,2)  NOT NULL,
                                 CONSTRAINT medication_time_pk PRIMARY KEY (id)
);

-- Table: message
CREATE TABLE message (
                         id serial  NOT NULL,
                         doctor_id int  NOT NULL,
                         patient_id int  NOT NULL,
                         text varchar(1000)  NOT NULL,
                         direction char(1)  NOT NULL,
                         status char(1)  NOT NULL,
                         CONSTRAINT message_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: unit
CREATE TABLE unit (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT unit_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT role_id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: doctor_user (table: doctor_patient)
ALTER TABLE doctor_patient ADD CONSTRAINT doctor_user
    FOREIGN KEY (doctor_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: logbook_medication_plan (table: logbook)
ALTER TABLE logbook ADD CONSTRAINT logbook_medication_plan
    FOREIGN KEY (medication_plan_id)
        REFERENCES medication_plan (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: medical_image_medical (table: medication_image)
ALTER TABLE medication_image ADD CONSTRAINT medical_image_medical
    FOREIGN KEY (medication_id)
        REFERENCES medication (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: medication_plan_medication (table: medication_plan)
ALTER TABLE medication_plan ADD CONSTRAINT medication_plan_medication
    FOREIGN KEY (medication_id)
        REFERENCES medication (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: medication_plan_user (table: medication_plan)
ALTER TABLE medication_plan ADD CONSTRAINT medication_plan_user
    FOREIGN KEY (patient_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: medication_time_medication_plan (table: medication_time)
ALTER TABLE medication_time ADD CONSTRAINT medication_time_medication_plan
    FOREIGN KEY (medication_plan_id)
        REFERENCES medication_plan (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: medicine_unit (table: medication)
ALTER TABLE medication ADD CONSTRAINT medicine_unit
    FOREIGN KEY (unit_id)
        REFERENCES unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_doctor (table: message)
ALTER TABLE message ADD CONSTRAINT message_doctor
    FOREIGN KEY (doctor_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_patient (table: message)
ALTER TABLE message ADD CONSTRAINT message_patient
    FOREIGN KEY (patient_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: patient_user (table: doctor_patient)
ALTER TABLE doctor_patient ADD CONSTRAINT patient_user
    FOREIGN KEY (patient_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;


-- End of file.

