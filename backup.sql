--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: garcons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.garcons (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.garcons OWNER TO postgres;

--
-- Name: garcons_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.garcons_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.garcons_id_seq OWNER TO postgres;

--
-- Name: garcons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.garcons_id_seq OWNED BY public.garcons.id;


--
-- Name: gerentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gerentes (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.gerentes OWNER TO postgres;

--
-- Name: gerentes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gerentes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gerentes_id_seq OWNER TO postgres;

--
-- Name: gerentes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gerentes_id_seq OWNED BY public.gerentes.id;


--
-- Name: socios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.socios (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.socios OWNER TO postgres;

--
-- Name: socios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.socios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.socios_id_seq OWNER TO postgres;

--
-- Name: socios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.socios_id_seq OWNED BY public.socios.id;


--
-- Name: garcons id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.garcons ALTER COLUMN id SET DEFAULT nextval('public.garcons_id_seq'::regclass);


--
-- Name: gerentes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerentes ALTER COLUMN id SET DEFAULT nextval('public.gerentes_id_seq'::regclass);


--
-- Name: socios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios ALTER COLUMN id SET DEFAULT nextval('public.socios_id_seq'::regclass);


--
-- Data for Name: garcons; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.garcons (id, usuario, senha) FROM stdin;
\.


--
-- Data for Name: gerentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gerentes (id, usuario, senha) FROM stdin;
1	gerente1	senha1
\.


--
-- Data for Name: socios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.socios (id, usuario, senha) FROM stdin;
1	socio1	senha123
\.


--
-- Name: garcons_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.garcons_id_seq', 1, false);


--
-- Name: gerentes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gerentes_id_seq', 1, true);


--
-- Name: socios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.socios_id_seq', 1, true);


--
-- Name: garcons garcons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.garcons
    ADD CONSTRAINT garcons_pkey PRIMARY KEY (id);


--
-- Name: gerentes gerentes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerentes
    ADD CONSTRAINT gerentes_pkey PRIMARY KEY (id);


--
-- Name: socios socios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

