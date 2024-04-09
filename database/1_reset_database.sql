-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA ravim CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA ravim
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA ravim TO postgres;
GRANT ALL ON SCHEMA ravim TO PUBLIC;